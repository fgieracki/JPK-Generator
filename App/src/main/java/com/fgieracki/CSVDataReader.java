package com.fgieracki;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("java:S106") // System.out.println is used for console output
public class CSVDataReader implements DataReader {
    public List<InvoicePosition> readInvoicePositionsFromFile(String filePath, char fieldSeparator) throws IOException {
        ArrayList<InvoicePosition> invoicePositions = new ArrayList<>();

        try (Reader reader = new FileReader(filePath)) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.builder()
                    .setDelimiter(fieldSeparator)
                    .setSkipHeaderRecord(true)
                    .setIgnoreEmptyLines(true)
                    .setIgnoreSurroundingSpaces(true)
                    .setTrim(true)
                    .build()
                    .parse(reader);

            boolean isFirstRecord = true;
            for (CSVRecord row : records) {
                if (isFirstRecord) {
                    isFirstRecord = false;
                    continue;
                }
                ArrayList<String> fields = new ArrayList<>();
                for (String field : row)
                    fields.add(field);
                for(int i = 7; i < 15; i++)
                    fields.set(i, Mappers.mapBigDecimalString(fields.get(i)));
                invoicePositions.add(new InvoicePosition(fields));
            }
        } catch (IOException e) {
            System.out.println("Error while reading file. Please check if the file is not corrupted");
        }
        return invoicePositions;
    }
}
