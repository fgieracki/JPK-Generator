package com.fgieracki;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class InvoiceGeneratorTest {

    @Test
    public void generateInvoices() {
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

        InvoicePosition invoicePosition = new InvoicePosition(fields);
        ArrayList<InvoicePosition> invoicePositions = new ArrayList<>();
        invoicePositions.add(invoicePosition);
        String actual = InvoiceGenerator.generateInvoices(invoicePositions).toString();
        String expected = "{6=Invoice{falseString='false', " +
                "KodWaluty='PLN', " +
                "P_1='4', " +
                "P_2A='6', " +
                "P_3A='1', " +
                "P_3B='2', " +
                "P_3C='\"CORE LOGIC\" SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ', " +
                "P_3D='ul. Karmelicka 15/1, 31-065 Kraków', " +
                "P_4A='PL', P_4B='6762484560', " +
                "P_5B='3', P_6='5', P_13_1='14', " +
                "P_14_1='1.00', P_15='15', P_16='false', " +
                "P_17='false', P_18='false', P_18A='false', " +
                "P_19='false', P_20='false', P_21='false', " +
                "P_22='false', P_23='false', P_106E_2='false', " +
                "P_106E_3='false', RodzajFaktury='VAT'}}";
        assertEquals(expected, actual);
    }
}