package oop.ue02;

import oop.ue02.Driver;
import oop.ue02.TimeAble;
import oop.ue02.TimeAbleAccess;

public class Car {

    private Driver driver;
    private boolean driverOnCar;
    private boolean fueledUp;
    private boolean fuelingInProgress;
    private int     fuelTime;
    private TimeAble timeAble;
    private int id;

    public Car() {
        this.driverOnCar = false;
        this.fueledUp = false;
        this.fuelTime = 0;
        this.fuelingInProgress = false;
    }

    public int getId() {
        return this.id;
    }
    
    public void setId(int value) {
        this.id = value;
    }

    public boolean driverOnCar() {
        return this.driverOnCar;
    }

    public Car setFuelingInProgress() {
        this.fuelingInProgress = true;
        return this;
    }

    public boolean isFuelingInProgress() {
        return this.fuelingInProgress;
    }

    public boolean isFueledUp() {
        return this.fueledUp;
    }

    public Car setFueledUp() {
        this.fueledUp = true;
        this.fuelingInProgress = false;
        return this;
    }

    public Driver removeDriver() {
        this.driverOnCar = false;
        return this.driver;
    }

    public void addDriver(Driver driver) {
        this.driver = driver;
        this.driverOnCar = true;
    }

    public void reinsertDriver(Driver driver) {
        if (driver != this.driver) {
            throw new RuntimeException(
                String.format("Wrong Driver inserted: %s should be: %s",
                    driver,
                    this.driver
                )
            );
        }

        this.driverOnCar = true;
    }

    public int getFuelTime() {
        return this.fuelTime;
    }

    public Car setFuelTime(int t) {
        this.fuelTime = t;
        return this;
    }

    public Driver getDriver() {
        return this.driver;
    }

    public TimeAble getTimeAble() {
        return this.timeAble;
    }

    public Car setTimeAble(TimeAble t) {
        this.timeAble = t;
        return this;
    }

    public String toString() {

        String s = String.format("[Car id:%2d => fuelTime:%d driverOnCar:%s fueledUp:%s]",
            this.id,
            this.getFuelTime(),
            this.driverOnCar,
            this.fueledUp
        );

        return s;
    }
}