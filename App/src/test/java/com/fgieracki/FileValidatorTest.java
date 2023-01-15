package com.fgieracki;

import org.junit.Test;


import java.io.File;

import static org.junit.Assert.*;

public class FileValidatorTest {

    @Test
    public void isFileValid() {
        assertTrue(FileValidator.checkSuffix("C:\\Users\\Felix\\Desktop\\test.csv"));
        assertTrue(FileValidator.checkSuffix("C:\\Users\\Felix\\Desktop\\test.xlsx"));
        assertFalse(FileValidator.checkSuffix("C:\\Users\\Felix\\Desktop\\test.txt"));
        assertFalse(FileValidator.checkSuffix("C:\\Users\\Felix\\Desktop\\test"));
        assertFalse(FileValidator.checkIfFileExists("C:\\Users123\\Felix123\\Desktop12\\test."));
        assertFalse(FileValidator.isFileValid("C:\\Users\\Felix\\Desktop\\test.txt"));
        assertFalse(FileValidator.isFileValid("C:\\Users\\Felix\\Desktop\\test"));
    }

}