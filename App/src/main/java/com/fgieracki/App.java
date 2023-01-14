package com.fgieracki;

import jakarta.xml.bind.JAXBException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

@SuppressWarnings("java:S106") // System.out.println is used for console output
public class App {

    public static void main(String[] args) throws IOException, JAXBException {

        JPK data = new JPK();

        if(args.length < 2) {
            System.out.println("Please provide a path to the input file and a path to the output file");
            return;
        }

        String filePath = args[0];
        if(!FileValidator.isFileValid(filePath)) {
            filePath = new File("").getAbsolutePath().concat(filePath);
            if(!FileValidator.isFileValid(filePath)) {
                System.out.println("Input File not found");
                return;
            }
        }

//        filePath = filePath.concat("\\faktury-sprzedazowe-test-2023.xlsx");
        DataReader dataReader;

        if(filePath.contains(".csv")){
            dataReader = new CSVDataReader();
        } else {
            dataReader = new XLSXDataReader();
        }

//        ArrayList<InvoicePositionInput> input = (ArrayList<InvoicePositionInput>) dataReader.readInvoicePositionsFromFile(filePath, '\t');
//        data.invoicePositions = Mappers.mapToInvoicePositions(input);
        data.invoicePositions = (ArrayList<InvoicePosition>) dataReader.readInvoicePositionsFromFile(filePath, '\t');
        data.invoices = InvoiceGenerator.generateInvoices((ArrayList<InvoicePosition>) data.invoicePositions);
        data.makeSummary();


        String outputFilePath = args[1];

        FileOutputStream fileOutputStream;
        fileOutputStream = new FileOutputStream(outputFilePath);

        PrintStream outputStream = new PrintStream(fileOutputStream);
        DataWriter.writeDataToOutput(data, outputStream);
    }


}
