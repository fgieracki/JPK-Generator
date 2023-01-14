package com.fgieracki;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVDataReader implements DataReader{
     public List<InvoicePositionInput> readIntoInvoicePositions(String filePath) throws IOException {
        return (ArrayList<InvoicePositionInput>) new CsvToBeanBuilder<InvoicePositionInput>(new FileReader(filePath))
        .withType(InvoicePositionInput.class)
        .withSeparator('\t')
        .withIgnoreQuotations(true)
        .withSkipLines(1)
        .build()
        .parse();
    }
}
