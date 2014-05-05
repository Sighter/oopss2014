package oop.ue02;

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
     * the time the lock will hold on.
     * this time will not change in the locking period
     */
    private int lockingTime;

    /**
     * constructor
     */
    public TimeAble() {
        this.remainingLockingTime = 0;
        this.locked = false;
        this.lockingTime = 0;
    }

    /**
     * lock the timeable
     * @return the TimeAble
     */
    public TimeAble lock() {
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
     * set the time for the lock to hold on
     * @param time the time
     * @return the TimeAble
     */
    public TimeAble setLockTime(int time) {
        this.remainingLockingTime = time;
        this.lockingTime = time;
        return this;
    }

    /**
     * this counts down the remaining locking time by one unit
     * @return the new remaining time
     */
    public int decreaseLockingTime() {
        this.remainingLockingTime -= 1;

        if (this.remainingLockingTime == 0)
            this.locked = false;
        return this.remainingLockingTime;
    }

}
