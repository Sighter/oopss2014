package oop.ue02;

import oop.ue02.CarIface;
import oop.ue02.DriverIface;

public interface CarFactoryIface {
    DriverIface createDriver();
    CarIface createCar();
    CarIface getCar();
}