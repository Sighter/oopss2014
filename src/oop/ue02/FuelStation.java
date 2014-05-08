package oop.ue02;

import java.util.*;
import java.lang.*;

import oop.ue02.*;

public class FuelStation {


    /**
     * the cue to manage the drivers
     * on the cash desk
     */
    private Queue<DriverIface> cashDeskQueue;

    /**
     * the cue to manage the cars on the 3
     * petrolpumps
     */
    private ArrayList<Queue<CarIface>> petrolPumpQueues;

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
     * history of times cars waited on the petrolpumps
     * for later statistics
     */
    private LinkedList<Integer> petrolPumpTimeHistory;

    /**
     * the car facory 
     */
    private CarFactoryIface carFactory;


    /**
     * constructor
     * TODO: fix list prob see
     * http://stackoverflow.com/questions/217065/cannot-create-an-array-of-linkedlists-in-java
     */
    public FuelStation(CarFactoryIface cf) {
        this.petrolPumpQueues = new ArrayList<Queue<CarIface>>(this.PETROLPUMPCOUNT);
        this.carFactory = cf;
        this.cashDeskQueue = new LinkedList<DriverIface>();

        for (int idx = 0; idx < this.PETROLPUMPCOUNT; idx++) {
            System.out.println("init Queue");
            this.petrolPumpQueues.add(new LinkedList<CarIface>());
        }
    }

    public void processIncomingCars() {

    }

    public void proccessFuelPumpQueues() {

        for (Queue<CarIface> q : this.petrolPumpQueues) {
            
            CarIface car = q.peek();
            DriverIface driver = null;

            if (car.isFueledUp())
                driver = car.removeDriver();

            this.cashDeskQueue.add(driver);
        }

    }

    public Queue<CarIface> insertCar(CarIface car) {
        
        /* determine the shortest list and insert the car there */
        
        Queue<CarIface> shortestCue = this.petrolPumpQueues.get(0);
        int minlength = shortestCue.size();

        for (Queue<CarIface> q : this.petrolPumpQueues) {
            if (q.size() < minlength) {
                shortestCue = q;
                minlength = q.size();
            }
        }

        shortestCue.add(car);

        return shortestCue;
    }

    public int[] getPetrolPumpLengths() {

        int[] sizes = new int[this.PETROLPUMPCOUNT];
        int idx = 0;

        for (Queue<CarIface> q : this.petrolPumpQueues) {
            sizes[idx] = q.size();
            idx++;
        }
        return sizes;
    }

    public int getCashDeskLength() {
        return this.cashDeskQueue.size();
    }

    public Queue<CarIface> getPetrolPumpQueue(int pos) {
        if (pos >= this.PETROLPUMPCOUNT)
            throw new RuntimeException("Invalid cue index");

        return this.petrolPumpQueues.get(pos);
    }
    
}