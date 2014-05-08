package oop.ue02.mocks;

import oop.ue02.CarIface;
import oop.ue02.DriverIface;
import oop.ue02.mocks.Driver;

public class Car implements CarIface {

    DriverIface driver;

    public Car() {
        this.driver = new Driver();
    }

    public boolean driverOnCar() {
        return true;
    }

    public boolean isFueledUp() {
        return true;
    }

    public DriverIface removeDriver() {
        return this.driver;
    }

    public void addDriver(DriverIface driver) {
     
    }

    public int getFuelTime() {
        return 10;
    }
}