package oop.ue02.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import oop.ue02.TimeAble;


@RunWith(JUnit4.class)
public class TimeAbleTest {

    @Test
    public void shouldBeLockable() {

        TimeAble t = new TimeAble();
        t.lock();

        assertTrue("TimeAble not locked", t.isLocked());

        t.setLockTime(2);

        t.decreaseLockingTime();
        t.decreaseLockingTime();

        assertFalse("Timeable did not unlock", t.isLocked());
    }

    @Test
    @Ignore
    public void thisIsIgnored() {
    }
}