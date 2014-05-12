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

    public static void main(String[] args) {
        
        Simulation sim = new Simulation();
    }

    public Simulation() {
        this.timeAbles = new LinkedList<TimeAble>();
        this.time = 0;
        this.endTime = 3000;
        this.checkInterval = 120;

        this.carFactory = new CarFactory(this);
        this.fuelStation = new FuelStation(this.carFactory);

        this.printProtocolHeader();
        this.simLoop();
    }

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

    }

    public TimeAble createRegisteredTimeAble() {
        TimeAble t = new TimeAble();
        this.timeAbles.add(t);
        return t;
    }

    public void decreaseAllTimeAbles() {
        for (TimeAble t : this.timeAbles) {
            if (t.isLocked())
                t.decreaseLockingTime();
        }
    }

    public LinkedList<TimeAble> getTimeAbles() {
        return this.timeAbles;
    }

    public String toString() {

        String s = String.format("%6d [FuelStation => F:%s Desk:%s]",
            this.time,
            Arrays.toString(this.fuelStation.getPetrolPumpLengths()),
            this.fuelStation.getCashDeskLength()
        );

        return s;
    }

    public void printProtocolHeader() {

        System.out.format("|| %5s ", "Zeit");

        for (int i = 1; i <= this.fuelStation.PETROLPUMPCOUNT; i++) {
            System.out.format("|| %5s ", "WS" + i);
        }

        System.out.format("|| %5s ", "Cash");
        System.out.format("||\n");


    }

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