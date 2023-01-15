package com.fgieracki;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;


import java.io.File;
import java.net.URL;

import static org.junit.Assert.*;

public class FileValidatorTest {
    String testFilePath;

    @Before
    public void setUp() {
        URL url = this.getClass().getResource("/faktury-sprzedazowe-test-2023.csv");
        File testFile = new File(url.getFile());
        testFilePath = testFile.getAbsolutePath();
    }

    @Test
    public void isFileValid() {
        assertTrue(FileValidator.checkSuffix("C:\\Users\\Felix\\Desktop\\test.csv"));
        assertTrue(FileValidator.checkSuffix("C:\\Users\\Felix\\Desktop\\test.xlsx"));
        assertFalse(FileValidator.checkSuffix("C:\\Users\\Felix\\Desktop\\test.txt"));
        assertFalse(FileValidator.checkSuffix("C:\\Users\\Felix\\Desktop\\test"));
        assertFalse(FileValidator.checkIfFileExists("C:\\Users123\\Felix123\\Desktop12\\test."));
        assertFalse(FileValidator.isFileValid("C:\\Users\\Felix\\Desktop\\test.txt"));
        assertFalse(FileValidator.isFileValid("C:\\Users\\Felix\\Desktop\\test"));
        assertTrue(FileValidator.isFileValid(testFilePath));
    }

}