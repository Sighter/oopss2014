package oop.ue02.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import oop.ue02.FuelStation;
import oop.ue02.Car;

@RunWith(JUnit4.class)
public class FuelStationTest {

    @Test
    public void shouldBeAbleToInsertCars() {


        FuelStation f = new FuelStation();
        Car c = new Car();
        int[] lenghts = new int[f.PETROLPUMPCOUNT];
        int[] expectedLengths = {1,1,0};

        f.insertCar(c);
        f.insertCar(c);


        lenghts = f.getPetrolPumpLengths();

        assertArrayEquals("wrong petrolPumpQueues length", expectedLengths, lenghts);
    }
}

