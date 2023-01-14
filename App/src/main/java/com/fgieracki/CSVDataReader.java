package com.fgieracki;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVDataReader implements DataReader{
     public List<InvoicePositionInput> readInvoicePositionsFromFile(String filePath, char fieldSeparator) throws IOException {
        return new CsvToBeanBuilder<InvoicePositionInput>(new FileReader(filePath))
            .withType(InvoicePositionInput.class)
            .withSeparator(fieldSeparator)
            .withIgnoreQuotations(true)
            .withSkipLines(1)
            .build()
            .parse();
    }
}
