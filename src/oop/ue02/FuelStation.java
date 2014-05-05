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
    private Queue<CarStub>[] petrolPumpQueues;

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

    }
    
}