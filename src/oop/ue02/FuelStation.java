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
     * history of times cars waited on the petrolpumps
     * for later statistics
     */
    private LinkedList<Integer> petrolPumpTimeHistory;


    /**
     * constructor
     * TODO: fix list prob see
     * http://stackoverflow.com/questions/217065/cannot-create-an-array-of-linkedlists-in-java
     */
    public FuelStation() {
        this.petrolPumpQueues = new ArrayList<Queue<Car>>(this.PETROLPUMPCOUNT);

        for (int idx = 0; idx < this.PETROLPUMPCOUNT; idx++) {
            System.out.println("init Queue");
            this.petrolPumpQueues.add(new LinkedList<Car>());
        }
    }

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

    public int[] getPetrolPumpLengths() {

        int[] sizes = new int[this.PETROLPUMPCOUNT];
        int idx = 0;

        for (Queue<Car> q : this.petrolPumpQueues) {
            sizes[idx] = q.size();
            idx++;
        }
        return sizes;
    }
    
}