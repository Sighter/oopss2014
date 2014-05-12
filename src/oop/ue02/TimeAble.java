package oop.ue02;

import java.lang.RuntimeException;

/**
 * class to make other objects timeable and blockable over
 * a certain time. In our case the unit is simply an integer
 * representing a second.
 */
public class TimeAble {

    /**
     * flag if timeAble is locked
     */
    private boolean locked;

    /**
     * the time the lock will hold on
     * this walks down to zero
     */
    private int remainingLockingTime;

    /**
     * constructor
     */
    public TimeAble() {
        this.remainingLockingTime = 0;
        this.locked = false;
    }

    /**
     * lock the timeable
     * @return the TimeAble
     */
    public TimeAble lock(int time) {
        if (time <= 0)
            throw new RuntimeException("Invalid Lock Time");

        this.remainingLockingTime = time;
        this.locked = true;
        return this;
    }

    /**
     * check whether the timeAble is locked
     * @return true if its locked
     */
    public boolean isLocked() {
        return this.locked;
    }

    /**
     * this counts down the remaining locking time by one unit
     * @return the new remaining time
     */
    public int decreaseLockingTime() {

        if (this.remainingLockingTime == 0)
           throw new RuntimeException("decreased timeable from 0");

        this.remainingLockingTime -= 1;

        if (this.remainingLockingTime == 0) {
            this.locked = false;
            //System.out.println("TimeAble was unlocked: " + this);
        }
        return this.remainingLockingTime;
    }

    public String toString() {

        String s = "[TimeAble: " +
            (this.isLocked() ?
            "locked " + this.remainingLockingTime + " Units" :
            "not locked") + 
            "]";

        return s;
    }

}
