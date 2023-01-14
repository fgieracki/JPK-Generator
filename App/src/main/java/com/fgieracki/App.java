package com.fgieracki;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException, ParseException, JAXBException {
//        System.out.println("Hello world!");

        AppData data = new AppData();

        String filePath = new File("").getAbsolutePath();

        filePath = filePath.concat("\\faktury-sprzedazowe-test-2023.csv");
        DataReader dataReader = new CSVDataReader();
//        System.out.println(filePath);
        ArrayList<InvoicePositionInput> input = (ArrayList<InvoicePositionInput>) dataReader.readIntoInvoicePositions(filePath);
        data.invoicePositions = Mappers.mapToInvoicePositions(input);

        data.invoices = InvoiceGenerator.generateInvoices((ArrayList<InvoicePosition>) data.invoicePositions);

        data.makeSummary();

        // Do metody newInstance można dodawać więcej klas po przecinku
        JAXBContext context = JAXBContext.newInstance(AppData.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        marshaller.marshal(data, System.out);

//        for(Invoice invoice : data.invoices.values()) {
//            marshaller.marshal(invoice, System.out);
//        }


//        System.out.println(invoices.size());

    }


}
