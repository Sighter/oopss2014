package oop.ue02.tests;

import java.util.*;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import oop.ue02.Simulation;
import oop.ue02.TimeAble;


@RunWith(JUnit4.class)
public class SimulationTest {

    @Test
    public void shouldRegisterAndDecreaseProperly() {

        Simulation sim = new Simulation();

        TimeAble t1 = sim.createRegisteredTimeAble();
        TimeAble t2 = sim.createRegisteredTimeAble();
        TimeAble t3 = sim.createRegisteredTimeAble();

        LinkedList<TimeAble> tl= sim.getTimeAbles();

        assertEquals("not all timeAbles registered",
            3,
            tl.size()
        );

        t1.lock(3);
        t2.lock(3);
        t3.lock(10);

        sim.decreaseAllTimeAbles();
        sim.decreaseAllTimeAbles();
        sim.decreaseAllTimeAbles();

        assertEquals("", tl.get(0).isLocked(), false);
        assertEquals("", tl.get(1).isLocked(), false);
        assertEquals("", tl.get(2).isLocked(), true);
    }

}