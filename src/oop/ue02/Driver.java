package oop.ue02;

import oop.ue02.TimeAble;
import oop.ue02.Car;

public class Driver {

    int cashDeskTime;
    int leavingTime;
    TimeAble timeAble;
    boolean paying;
    boolean leaving;
    Car car;
    int id;

    public Driver(Car car) {
        this.cashDeskTime = 0;
        this.leavingTime = 0;
        this.car = car;
        this.leaving = false;
        this.paying = false;
    }

    public int getId() {
        return this.id;
    }
    
    public void setId(int value) {
        this.id = value;
    }

    public int getLeavingTime() {
        return this.leavingTime;
    }
    
    public Driver setLeavingTime(int t) {
        this.leavingTime = t;
        return this;
    }

    public int getCashDeskTime() {
        return this.cashDeskTime;
    }
    
    public Driver setCashDeskTime(int t) {
        this.cashDeskTime = t;
        return this;
    }

    public TimeAble getTimeAble() {
        return this.timeAble;
    }

    public void setTimeAble(TimeAble t) {
        this.timeAble = t;
    }

    public void setPaying(boolean value) {
        this.paying = value;
    }

    public boolean isPaying() {
        return this.paying;
    }

    public void setLeaving(boolean value) {
        this.leaving = value;
    }

    public void goBackToCar() {
        this.car.reinsertDriver(this);
    }

    public boolean isLeaving() {
        return this.leaving;
    }

    public String toString() {

        String s = String.format("[Driver id:%2d => cd:%d lt:%d ta:%s]",
            this.id,
            this.getCashDeskTime(),
            this.getLeavingTime(),
            this.getTimeAble()
        );

        return s;
    }
}
