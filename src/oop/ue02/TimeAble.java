package oop.ue02;


public class TimeAble {

    public static void main(String[] args) {

        System.out.println("Testing TimeAble");
    }

    private boolean locked;
    private int remainingLockingTime;
    private int lockingTime;

    public TimeAble() {
        this.remainingLockingTime = 0;
        this.locked = false;
        this.lockingTime = 0;
    }

    public TimeAble lock() {
        this.locked = true;
        return this;
    }

    public boolean isLocked() {
        return this.locked;
    }

    public TimeAble setLockTime(int time) {
        this.remainingLockingTime = time;
        this.lockingTime = time;
        return this;
    }

    public int decreaseLockingTime() {
        this.remainingLockingTime -= 1;

        if (this.remainingLockingTime == 0)
            this.locked = false;
        return this.remainingLockingTime;
    }

}



