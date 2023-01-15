package com.fgieracki;

import jakarta.xml.bind.JAXBException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Objects;

@SuppressWarnings("java:S106") // System.out.println is used for console output
public class App {
    static JPK data;
    private static final Boolean argsValidator(String[] args){
        return (args.length == 2);
    }

    public static void main(String[] args) throws IOException, JAXBException {

        data = new JPK();

        if(!argsValidator(args)){
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

        DataReader dataReader;

        if(filePath.contains(".csv")){
            dataReader = new CSVDataReader();
        } else {
            dataReader = new XLSXDataReader();
        }

        data.invoicePositions = dataReader.readInvoicePositionsFromFile(filePath, '\t');
        data.invoices = InvoiceGenerator.generateInvoices((ArrayList<InvoicePosition>) data.invoicePositions);
        data.makeSummary();

        String outputFilePath = !Objects.equals(args[1], "") ? args[1] : "output.xml";

        FileOutputStream fileOutputStream;
        fileOutputStream = new FileOutputStream(outputFilePath);

        PrintStream outputStream = new PrintStream(fileOutputStream);
        DataWriter.writeDataToOutput(data, outputStream);
        fileOutputStream.close();
        System.out.println("Done");
    }


}
