package com.fgieracki;

import jakarta.xml.bind.JAXBException;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.*;

public class AppTest {

    String testFilePath1;
    String testFilePath2;

    @Before
    public void setUp() {
        URL url = this.getClass().getResource("/faktury-sprzedazowe-test-2023.xlsx");
        File testFile = new File(url.getFile());
        testFilePath1 = testFile.getAbsolutePath();

        url = this.getClass().getResource("/faktury-sprzedazowe-test-2023.csv");
        testFile = new File(url.getFile());
        testFilePath2 = testFile.getAbsolutePath();
    }

    @Test
    public void main() {
        String[] args = new String[2];
        args[0] = testFilePath1;
        args[1] = "out.xml";
        try{
            App.main(args);
        } catch (IOException | JAXBException e) {
            fail("Exception thrown");
        }

        args[0] = testFilePath2;
        args[1] = "out.xml";
        try{
            App.main(args);
        } catch (IOException | JAXBException e) {
            fail("Exception thrown");
        }

        args[0] = "xd";
        args[1] = "out.xml";
        try{
            App.main(args);
        } catch (IOException | JAXBException e) {
            fail("Exception thrown");
        }


    }
}