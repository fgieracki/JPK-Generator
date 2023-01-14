package com.fgieracki;

import java.io.IOException;
import java.util.List;

public interface DataReader {
    public abstract List<InvoicePositionInput> readInvoicePositionsFromFile(String filePath, char fieldSeparator) throws IOException;
}
