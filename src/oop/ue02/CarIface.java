package oop.ue02;

public interface CarIface {
    public boolean driverOnCar();
    public boolean isFueledUp();
    public DriverIface removeDriver();
    public void addDriver(DriverIface driver);
    public int getFuelTime();
}