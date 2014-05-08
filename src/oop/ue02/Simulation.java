package oop.ue02;

import oop.ue02.TimeAble;
import java.util.LinkedList;




public class Simulation {
    
    LinkedList<TimeAble> timeAbles;

    int time;


    public Simulation() {
        this.timeAbles = new LinkedList<TimeAble>();
        this.time = 0;
    }

    public void simLoop() {

    }

    public TimeAble createRegisteredTimeAble() {

        TimeAble t = new TimeAble();

        this.timeAbles.add(t);

        return t;
    }

    public void decreaseAllTimeAbles() {
        for (TimeAble t : this.timeAbles) {
            t.decreaseLockingTime();
        }
    }

    public LinkedList<TimeAble> getTimeAbles() {
        return this.timeAbles;
    }


}