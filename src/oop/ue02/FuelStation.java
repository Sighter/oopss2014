package oop.ue02;

import java.util.*;
import java.lang.*;

import oop.ue02.*;

public class FuelStation {

    /**
     * the cue to manage the drivers
     * on the cash desk
     */
    private Queue<DriverStub> cashDeskQueue;

    /**
     * the cue to manage the cars on the 3
     * petrolpumps
     */
    private Queue<Car>[] petrolPumpQueues;

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
     * constructor
     */
    public FuelStation() {
        this.petrolPumpQueues = (LinkedList<Car>[]) new LinkedList[this.PETROLPUMPCOUNT];

        for (int idx = 0; idx < this.PETROLPUMPCOUNT; idx++) {
            this.petrolPumpQueues[idx] = new LinkedList<Car>();
        }
    }

    public int insertCar(Car car) {
        
        /* determine the shortest list and insert the car there */
        
        int shortestQueueIndex = 0;
        int minlength = this.petrolPumpQueues[0].size();

        for (int i = 1; i < this.PETROLPUMPCOUNT; i++) {
            if (this.petrolPumpQueues[i].size() < minlength) {
                shortestQueueIndex = i;
                minlength = this.petrolPumpQueues[i].size();
            }
        }

        this.petrolPumpQueues[shortestQueueIndex].add(car);

        return shortestQueueIndex;
    }

    public int[] getPetrolPumpLengths() {

        int[] sizes = new int[this.PETROLPUMPCOUNT];

        for (int i = 1; i < this.PETROLPUMPCOUNT; i++)
            sizes[i] = this.petrolPumpQueues[i].size();

        return sizes;
    }
    
}