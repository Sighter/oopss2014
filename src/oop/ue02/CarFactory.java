package oop.ue02;

import java.lang.Math;

import oop.ue02.Car;
import oop.ue02.Driver;
import oop.ue02.TimeAble;
import oop.ue02.Simulation;

public class CarFactory {

    Simulation simulation;
    double chanceTreshold;
    int runningid;

    public static void main(String[] args) {

        Simulation sim = new Simulation();

        CarFactory cf = new CarFactory(sim);

        for (int i = 0;i < 3000; i++) {
            System.out.println(cf.isCarAvaileable());
        }

        cf.getCar();
        cf.getCar();
        cf.getCar();
        cf.getCar();
        cf.getCar();
        cf.getCar();
    }

    public CarFactory(Simulation sim) {
        this.simulation = sim;
        this.chanceTreshold = 1.0 / (4 * 60);
        this.runningid = 1;
    }

    public Driver createDriver(Car c) {
        //System.out.println("creating driver:");

        Driver d = new Driver(c);
        d.setId(this.runningid);
        d.setLeavingTime(this.randomizeLeavingTime());
        d.setCashDeskTime(this.randomizeCashDeskTime());
        d.setTimeAble(this.simulation.createRegisteredTimeAble());


        //System.out.println(d);

        return d;
    }

    public Car createCar() {
        Car c = new Car();
        //System.out.println("creating car:");
        c.setFuelTime(this.randomizeFuelTime());
        //System.out.println(c);
        
        c.setTimeAble(this.simulation.createRegisteredTimeAble());
        c.setId(this.runningid);
        return c;
    }

    public Car getCar() {

        if (this.isCarAvaileable()) {
            Car c = this.createCar();
            c.addDriver(this.createDriver(c));
            this.runningid++;
            return c;
        } else {
            return null;
        }
    }

    public boolean isCarAvaileable() {
        double chance = Math.random();
        return (chance <= this.chanceTreshold);
    }

    private static int randomizeFuelTime() {
        return CarFactory.randomWithRange(200, 300);
    }

    private static int randomizeCashDeskTime() {
        return CarFactory.randomWithRange(20, 50);
    }

    private static int randomizeLeavingTime() {
        return CarFactory.randomWithRange(30, 70);
    }

    public static int randomWithRange(int min, int max) {
       int range = (max - min) + 1;
       return (int)(Math.random() * range) + min;
    }
}