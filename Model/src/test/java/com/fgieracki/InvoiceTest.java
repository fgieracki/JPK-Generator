package com.fgieracki;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class InvoiceTest {

    @Test
    public void testToString() {
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
        Invoice invoice = new Invoice(fields);
        String actual = invoice.toString();
        String expected = "Invoice{falseString='false', KodWaluty='PLN', " +
                "P_1='1', P_2A='2', P_3A='3', P_3B='4', P_3C='5', P_3D='6'," +
                " P_4A='PL', P_4B='7', P_5B='8', P_6='9', P_13_1='10', P_14_1='11', " +
                "P_15='12', P_16='false', P_17='false', P_18='false', P_18A='false', " +
                "P_19='false', P_20='false', P_21='false', P_22='false', P_23='false', " +
                "P_106E_2='false', P_106E_3='false', RodzajFaktury='VAT'}";
        assertEquals(expected, actual);
    }

    @Test
    public void getP_15() {
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
        Invoice invoice = new Invoice(fields);
        String actual = invoice.getP_15().toString();
        String expected = "12.0";
        assertEquals(expected, actual);

    }
}