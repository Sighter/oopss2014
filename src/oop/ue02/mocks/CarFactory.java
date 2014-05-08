package oop.ue02.mocks;

import oop.ue02.CarFactoryIface;
import oop.ue02.DriverIface;
import oop.ue02.CarIface;

import oop.ue02.mocks.Car;

public class CarFactory implements CarFactoryIface {
    
    public DriverIface createDriver() {
        return null;
    }

    public CarIface createCar() {
        return new Car();
    }

    public CarIface getCar() {
        return null;
    }
}