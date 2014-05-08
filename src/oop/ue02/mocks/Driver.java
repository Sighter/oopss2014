package oop.ue02.mocks;

import oop.ue02.TimeAble;
import oop.ue02.DriverIface;

public class Driver implements DriverIface {

    int cashDeskTime;
    int leavingTime;
    TimeAble timeAble;

    public Driver() {
        this.cashDeskTime = 30;
        this.leavingTime = 70;
        //this.timeAble = t;
        
    }

    public TimeAble getTimeAble() {
        return this.timeAble;
    }

    public void setTimeAble(TimeAble t) {
        this.timeAble = t;
    }

    public int getCashDeskTime() {
        return this.cashDeskTime;
    }

    public int getLeavingTime() {
        return this.leavingTime;
    }
}
