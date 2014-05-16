package oop.ue03.tests;

import java.util.*;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;


import oop.ue03.FileWriter;
import oop.ue03.FileReader;

@RunWith(JUnit4.class)
public class FileReaderWriterTest {

    @Test
    public void readerShouldReadMessage() throws IOException {

        String shouldString = "Hallo, Welt!\n";

        FileReader fr = new FileReader();
        String got = fr.readMsgFromFile("tests/files/hello.txt");

        assertEquals("Read string is not correct", shouldString, got);
     
    }

    @Test
    public void writerShouldWriteMessage() throws IOException {

        String msg = "Hallo, Welt!\n";

        FileWriter fr = new FileWriter();
        //fr.writeMsgToFile("tests/files/test.txt", msg);

        //assertEquals("Read string is not correct", shouldString, got);
     
    }


}