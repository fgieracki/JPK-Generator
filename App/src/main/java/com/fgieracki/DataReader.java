package com.fgieracki;

import java.io.IOException;
import java.util.List;

public interface DataReader {
    abstract public List<InvoicePositionInput> readIntoInvoicePositions(String filePath) throws IOException;
}
