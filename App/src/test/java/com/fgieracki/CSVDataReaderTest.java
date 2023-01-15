package com.fgieracki;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class CSVDataReaderTest {
    String testFilePath;

    @Before
    public void setUp() {
        URL url = this.getClass().getResource("/faktury-sprzedazowe-test-2023.csv");
        File testFile = new File(url.getFile());
        testFilePath = testFile.getAbsolutePath();
    }


    @Test
    public void readInvoicePositionsFromFile() {
        ArrayList<InvoicePosition> invoicePositions = new ArrayList<>();
        CSVDataReader csvDataReader = new CSVDataReader();
        try {
            invoicePositions =  (ArrayList<InvoicePosition>) csvDataReader.readInvoicePositionsFromFile(testFilePath, '\t');
        } catch (Exception e) {
            fail("Exception thrown");
        }
        assertEquals(107, invoicePositions.size());
    }
}