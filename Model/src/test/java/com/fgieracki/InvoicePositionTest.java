package com.fgieracki;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class InvoicePositionTest {
    InvoicePosition invoicePosition;
    @Before
    public void setUp() throws Exception {
        ArrayList<String> fields = new ArrayList<>();
        fields.add("1");
        fields.add("2");
        fields.add("3");
        fields.add("4");
        fields.add("5");
        fields.add("6");
        fields.add("7");
        fields.add("8");
        fields.add("9");
        fields.add("10");
        fields.add("11");
        fields.add("12");
        fields.add("13");
        fields.add("14");
        fields.add("15");

        invoicePosition = new InvoicePosition(fields);
    }

    @Test
    public void getP_3A() {
        assertEquals("1", invoicePosition.getP_3A());
    }

    @Test
    public void getP_3B() {
        assertEquals("2", invoicePosition.getP_3B());
    }

    @Test
    public void getP_5B() {
        assertEquals("3", invoicePosition.getP_5B());
    }

    @Test
    public void getP_1() {
        assertEquals("4", invoicePosition.getP_1());
    }

    @Test
    public void getP_6() {
        assertEquals("5", invoicePosition.getP_6());
    }

    @Test
    public void getP_2B() {
        assertEquals("6", invoicePosition.getP_2B());
    }

    @Test
    public void getP_7() {
        assertEquals("7", invoicePosition.getP_7());
    }

    @Test
    public void getP_8B() {
        assertEquals(BigDecimal.valueOf(8), invoicePosition.getP_8B());
    }

    @Test
    public void getP_9A() {
        assertEquals(BigDecimal.valueOf(9), invoicePosition.getP_9A());
    }

    @Test
    public void getP_12() {
        assertEquals(BigDecimal.valueOf(10), invoicePosition.getP_12());
    }

    @Test
    public void getP_14_1() {
        assertEquals(BigDecimal.valueOf(11), invoicePosition.getP_14_1());
    }

    @Test
    public void getP_11() {
        assertEquals(BigDecimal.valueOf(12), invoicePosition.getP_11());
    }

    @Test
    public void getP_11A() {
        assertEquals(BigDecimal.valueOf(13), invoicePosition.getP_11A());
    }

    @Test
    public void getP_13_1() {
        assertEquals(BigDecimal.valueOf(14), invoicePosition.getP_13_1());
    }

    @Test
    public void getP_15() {
        assertEquals(BigDecimal.valueOf(15), invoicePosition.getP_15());
    }

    @Test
    public void getP_9B() {
        assertEquals(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP),
                BigDecimal.valueOf(9.90).subtract(invoicePosition.getP_9B())
                        .setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    public void getP_8A() {
        assertEquals("szt", invoicePosition.getP_8A());
    }

    @Test
    public void testToString() {
            String expected = "InvoicePosition{P_3A='1', P_3B='2', " +
                    "P_5B='3', P_1='4', P_6='5', P_2B='6', P_7='7', " +
                    "P_8B=8, P_9A=9, P_12=10, P_14_1=11, P_11=12, P_11A=13, " +
                    "P_13_1=14, P_15=15, P_9B=9.90, P_8A='szt'}";
            assertEquals(expected, invoicePosition.toString().trim());
    }
}