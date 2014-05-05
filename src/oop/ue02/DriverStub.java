package oop.ue02;

import oop.ue02.*;

public class DriverStub implements oop.ue02.TimeAbleAccess {

    int cashDeskTime;
    int leavingTime;
    TimeAble timeAble;

    DriverStub(TimeAble t) {
        this.cashDeskTime = 30;
        this.leavingTime = 70;
        this.timeAble = t;
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
