package oop.ue02.tests;

import java.util.Arrays;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import oop.ue02.FuelStation;

import oop.ue02.mocks.Car;
import oop.ue02.mocks.CarFactory;

@RunWith(JUnit4.class)
public class FuelStationTest {

    @Test
    public void shouldBeAbleToInsertCars() {

        CarFactory cf = new CarFactory();
        
        FuelStation f = new FuelStation(cf);
        
        Car c = new Car();
        int[] lenghts = new int[f.PETROLPUMPCOUNT];
        int[] expectedLengths = {1,1,0};

        f.insertCar(c);
        f.insertCar(c);


        lenghts = f.getPetrolPumpLengths();

        assertArrayEquals("wrong petrolPumpQueues length", expectedLengths, lenghts);

        assertEquals("cue has wrong lengh", f.getPetrolPumpQueue(0).size(), 1);
        assertEquals("cue has wrong lengh", f.getPetrolPumpQueue(1).size(), 1);
        assertEquals("cue has wrong lengh", f.getPetrolPumpQueue(2).size(), 0);
    }

    @Test
    public void shouldBeAbleToProcessFuelpumps() {

        CarFactory cf = new CarFactory();

        FuelStation f = new FuelStation(cf);

        Car c = new Car();
        int[] lenghts = new int[f.PETROLPUMPCOUNT];
        int[] expectedLengths = {2,2,1};
        int expectedCashDeskLength = 0;

        f.insertCar(cf.createCar());
        f.insertCar(cf.createCar());
        f.insertCar(cf.createCar());
        f.insertCar(cf.createCar());
        f.insertCar(cf.createCar());

        lenghts = f.getPetrolPumpLengths();

        assertArrayEquals("wrong petrolPumpQueues length " + Arrays.toString(lenghts),
            expectedLengths,
            lenghts
        );

        assertEquals("wrong cashDeskQueue length " + Arrays.toString(lenghts),
            expectedCashDeskLength,
            f.getCashDeskLength()
        );

        f.proccessFuelPumpQueues();

        lenghts = f.getPetrolPumpLengths();

        expectedLengths[0] = 2;
        expectedLengths[1] = 2;
        expectedLengths[2] = 1;

        assertArrayEquals("wrong petrolPumpQueues length " + Arrays.toString(lenghts), expectedLengths, lenghts);

        assertEquals("wrong cashDeskQueue length " + Arrays.toString(lenghts),
            3,
            f.getCashDeskLength()
        );
    }
}

