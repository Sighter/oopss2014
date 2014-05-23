
package oop.ue03.tests;

import java.util.*;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;


import oop.ue03.Repeater;

@RunWith(JUnit4.class)
public class RepeaterTest {

    @Test
    public void shouldRepeatAMessage() {

        String input = "Hallo Ihr da";
        String expected = "Hallo Ihr daHallo Ihr daHallo Ihr da";

        Repeater repeater = new Repeater();
       
        assertEquals("Read stString not correctly repeated",
            expected, repeater.repeat(input, 3));
     
    }

}