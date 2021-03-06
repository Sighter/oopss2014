package oop.ue02;

import java.util.*;
import java.lang.*;

import oop.ue02.*;

public class FuelStation {


    /**
     * the cue to manage the drivers
     * on the cash desk
     */
    private Queue<Driver> cashDeskQueue;

    /**
     * the cue to manage the cars on the 3
     * petrolpumps
     */
    private ArrayList<Queue<Car>> petrolPumpQueues;

    /**
     * count of petrol pumps
     */
    public static final int PETROLPUMPCOUNT = 3;

    /**
     * history of times drivers waited on the cashdesk
     * for later statistics
     */
    private LinkedList<Integer> cashDeskTimeHistory;

    /**
     * getter
     * @return the time history of the cashdesk
     */
    public LinkedList<Integer> getCashDeskTimeHistory() {
        return this.cashDeskTimeHistory;
    }

    /**
     * history of times cars waited on the petrolpumps
     * for later statistics
     */
    private LinkedList<Integer> petrolPumpTimeHistory;

    /**
     * getter
     * @return the time history for the petrolpumps
     */
    public LinkedList<Integer> getPetrolPumpTimeHistory() { 
        return this.petrolPumpTimeHistory;
    }

    /**
     * the car facory 
     */
    private CarFactory carFactory;

    /**
     * variable to hold the current time
     */
    private int currentTime;

    /**
     * flag for debug mode
     */
    private boolean debug;

    /**
     * constructor
     * TODO: fix list prob see
     * http://stackoverflow.com/questions/217065/cannot-create-an-array-of-linkedlists-in-java
     */
    public FuelStation(CarFactory cf) {
        this.petrolPumpQueues = new ArrayList<Queue<Car>>(this.PETROLPUMPCOUNT);
        this.carFactory = cf;
        this.cashDeskQueue = new LinkedList<Driver>();
        this.debug = false;

        this.cashDeskTimeHistory = new LinkedList<Integer>();
        this.petrolPumpTimeHistory = new LinkedList<Integer>();

        for (int idx = 0; idx < this.PETROLPUMPCOUNT; idx++) {
            //System.out.println("init Queue");
            this.petrolPumpQueues.add(new LinkedList<Car>());
        }
    }

    /**
     * see if new car is available, 
     * if yes insert it in the petrol pump queues
     * @return true if car was inserted, else false
     */
    public boolean processIncomingCars() {

        Car newCar = this.carFactory.getCar();

        if (newCar != null) {

            if (this.debug) {
                System.out.format("%6d Incoming car %s\n",
                    this.getCurrentTime(),
                    newCar
                );
            }


            /* start wait */
            newCar.getTimeAble().setWaiting(true);

            this.insertCar(newCar);

            return true;
        } else {
            return false;
        }
    }

    /**
     * process the fuel pump cues
     */
    public void proccessFuelPumpQueues() {

        for (Queue<Car> q : this.petrolPumpQueues) {
            
            Car car = q.peek();

            /* Queue is empty */
            if (car == null) {
                continue;
            }

            Driver driver = car.getDriver();
            TimeAble driverTa = driver.getTimeAble();
            TimeAble t = car.getTimeAble();
            //System.out.println("Got timeable " + t);

            /* actions which can happen every time step */

            /* is fresh car arrived car */
            if (!t.isLocked() && !car.isFueledUp() && !car.isFuelingInProgress()) {
                t.lock(car.getFuelTime());
                car.setFuelingInProgress();
                //System.out.println("get waiting time: " + t.getWaitingTime());
                t.setWaiting(false);
                continue;
            }

            /* car has finished fueling */
            if (!t.isLocked() && car.isFuelingInProgress()) {
                car.setFueledUp();
                Driver d = car.removeDriver();
                this.cashDeskQueue.add(d);

                d.getTimeAble().setWaiting(true);

                if (this.debug) {
                    System.out.format("%6d Car finished fueling: %s\n",
                        this.getCurrentTime(),
                        car
                    );
                }

                continue;
            }

            /* driver is back from the cashdesk */
            if (!t.isLocked() && car.isFueledUp() && car.driverOnCar() && !driver.isLeaving()) {
                driver.setLeaving(true);
                driverTa.lock(driver.getLeavingTime());

                if (this.debug) {
                    System.out.format("%6d Driver gets ready to leave: %s\n",
                        this.getCurrentTime(),
                        driver
                    );
                }
                continue;
            }

            /* driver is at the cashdesk */
            if (!car.driverOnCar()) {
                continue;
            }

            /* driver and car is ready */
            if (!driverTa.isLocked() && driver.isLeaving() ) {
                if (this.debug) {
                    System.out.format("%6d Car left station: %s\n",
                        this.getCurrentTime(),
                        car
                    );
                }
                /* write wait time statistics */
                this.cashDeskTimeHistory.add(driverTa.getWaitingTime());
                this.petrolPumpTimeHistory.add(t.getWaitingTime());

                q.remove();
                continue;
            }

            /* car is fueling up or driver gets ready for leaving*/
            if (t.isLocked() || driverTa.isLocked())
                continue;

            throw new RuntimeException("Logic Failure");
        }

    }

    /**
     * process the cash desk
     */
    public void processCashDeskQueue() {

        Driver d = this.cashDeskQueue.peek();

        /* cue is empty */
        if (d == null)
            return;

        TimeAble t = d.getTimeAble();

        /* driver is paying */
        if (t.isLocked())
            return;

        /* driver is fresh to cashdesk */
        if (!t.isLocked() && !d.isPaying()) {
            t.lock(d.getCashDeskTime());
            d.setPaying(true);

            if (this.debug) {
                System.out.format("%6d Driver started paying: %s\n",
                        this.getCurrentTime(),
                        d
                );
            }
            return;
        }

        /* driver is ready to leave cashdesk */
        if (!t.isLocked() && d.isPaying()) {
            d.setPaying(false);
            this.cashDeskQueue.remove();
            d.goBackToCar();
            t.setWaiting(false);

            if (this.debug) {
                System.out.format("%6d Driver paid off: %s\n",
                        this.getCurrentTime(),
                        d
                );
            }
            return;
        }

    }

    /**
     * consistently insert new cars in the cues
     * @param  car a car
     * @return teh quere where the car gots inserted
     */
    public Queue<Car> insertCar(Car car) {
        
        /* determine the shortest list and insert the car there */
        
        Queue<Car> shortestCue = this.petrolPumpQueues.get(0);
        int minlength = shortestCue.size();

        for (Queue<Car> q : this.petrolPumpQueues) {
            if (q.size() < minlength) {
                shortestCue = q;
                minlength = q.size();
            }
        }

        shortestCue.add(car);

        return shortestCue;
    }

    /**
     * get the lengths of the petrol pump cues
     * @return an array with the lengths
     */
    public int[] getPetrolPumpLengths() {

        int[] sizes = new int[this.PETROLPUMPCOUNT];
        int idx = 0;

        for (Queue<Car> q : this.petrolPumpQueues) {
            sizes[idx] = q.size();
            idx++;
        }
        return sizes;
    }

    /**
     * get cue size of the cash desk
     * @return size
     */
    public int getCashDeskLength() {
        return this.cashDeskQueue.size();
    }

    /**
     * get a petrol pump cue at specified index
     * @param  pos index
     * @return petrol pump queue
     */
    public Queue<Car> getPetrolPumpQueue(int pos) {
        if (pos >= this.PETROLPUMPCOUNT)
            throw new RuntimeException("Invalid cue index");

        return this.petrolPumpQueues.get(pos);
    }

    /**
     * set the current time
     * @param t the time
     */
    public void setCurrentTime(int t) {
        this.currentTime = t;
    }

    /**
     * get the current time
     * @return the time
     */
    public int getCurrentTime() {
        return this.currentTime;
    }

    /**
     * gets the avarage of waiting times at the fuel pumps
     * @return avarage waiting time
     */
    public int getPetrolPumpWaitingTimeAverage() {

        int sum = 0;

        for (int k : this.petrolPumpTimeHistory)
            sum += k;

        return sum / this.petrolPumpTimeHistory.size();
    }

    /**
     * gets the avarage of waiting times at the cash desk
     * @return avarage waiting time
     */
    public int getCashDeskWaitingTimeAverage() {

        int sum = 0;

        for (int k : this.cashDeskTimeHistory)
            sum += k;

        return sum / this.cashDeskTimeHistory.size();
    }
    
}