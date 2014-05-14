package oop.ue02;

import java.util.LinkedList;
import java.util.Arrays;

import oop.ue02.TimeAble;
import oop.ue02.CarFactory;
import oop.ue02.FuelStation;


public class Simulation {
    
    LinkedList<TimeAble> timeAbles;

    int time;
    int endTime;
    int checkInterval;
    FuelStation fuelStation;
    CarFactory carFactory;

    /**
     * main method to start the simulation
     * @param command line args
     */
    public static void main(String[] args) {

        Simulation sim = new Simulation();
    }

    /**
     * constructor
     */
    public Simulation() {
        this.timeAbles = new LinkedList<TimeAble>();
        this.time = 0;
        this.endTime = 3600; // 1 hour in seconds
        this.checkInterval = 300; // 

        this.carFactory = new CarFactory(this);
        this.fuelStation = new FuelStation(this.carFactory);

        this.printProtocolHeader();
        this.simLoop();
    }

    /**
     * this method runs the main simulation loop. One loop cycle
     * represents one time unit. In our special case, this is one
     * second
     */
    public void simLoop() {

        for (this.time = 0; this.time < this.endTime; this.time++) {

            this.fuelStation.setCurrentTime(this.time);

            this.fuelStation.processIncomingCars();
            this.fuelStation.proccessFuelPumpQueues();
            this.fuelStation.processCashDeskQueue();

            if (time % checkInterval == 0) {
                //System.out.println(this);
                this.printProtocolLine();
            }

            this.decreaseAllTimeAbles();
        }

        /* print stats */
        System.out.format(
            "Petrol Pump Waitingtime Average: %d\n",
            this.fuelStation.getPetrolPumpWaitingTimeAverage()
        );
        
        System.out.format(
            "Cash Desk Waiting Times Average: %d\n",
            this.fuelStation.getCashDeskWaitingTimeAverage()
        );

    }

    /**
     * create a timeable and store it for later callbacks
     * @return the created timeable
     */
    public TimeAble createRegisteredTimeAble() {
        TimeAble t = new TimeAble();
        this.timeAbles.add(t);
        return t;
    }

    /**
     * decrease all locking times and increase all
     * waiting times in the timeables
     */
    public void decreaseAllTimeAbles() {
        for (TimeAble t : this.timeAbles) {
            if (t.isLocked())
                t.decreaseLockingTime();

            if (t.isWaiting())
                t.increaseWaitingTime();
        }
    }

    /**
     * get all registered timeAbles as list
     * @return the list
     */
    public LinkedList<TimeAble> getTimeAbles() {
        return this.timeAbles;
    }

    /**
     * convenience method string converter
     * @return string representation
     */
    public String toString() {

        String s = String.format("%6d [FuelStation => F:%s Desk:%s]",
            this.time,
            Arrays.toString(this.fuelStation.getPetrolPumpLengths()),
            this.fuelStation.getCashDeskLength()
        );

        return s;
    }

    /**
     * print a formatted protocol header
     */
    public void printProtocolHeader() {

        System.out.format("|| %5s ", "Zeit");

        for (int i = 1; i <= this.fuelStation.PETROLPUMPCOUNT; i++) {
            System.out.format("|| %5s ", "WS" + i);
        }

        System.out.format("|| %5s ", "Cash");
        System.out.format("||\n");


    }

    /**
     * print a new formatted line with fuel pump and chash
     * desk sizes
     */
    public void printProtocolLine() {
        System.out.format("|| %5d ", this.time);

        int[] plenghts = this.fuelStation.getPetrolPumpLengths();

        for (int i = 0; i < this.fuelStation.PETROLPUMPCOUNT; i++) {
            System.out.format("|| %5d ", plenghts[i]);
        }

        System.out.format("|| %5s ", this.fuelStation.getCashDeskLength());
        System.out.format("||\n");

    }


}