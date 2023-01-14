package com.fgieracki;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XLSXDataReader implements DataReader {
    public List<InvoicePositionInput> readInvoicePositionsFromFile(String filePath, char fieldSeparator) throws IOException {
        FileInputStream fis = null;
        Workbook workbook = null;

        List<InvoicePositionInput> invoicePositionInputs = new ArrayList<InvoicePositionInput>();

        try{
            fis = new FileInputStream(filePath);
            workbook  = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                if(row.getRowNum() == 0) continue;
                InvoicePositionInput invoicePositionInput = parseRow(row);
                invoicePositionInputs.add(invoicePositionInput);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null)
                fis.close();

            if(workbook != null)
                workbook.close();
        }
        return invoicePositionInputs;
    }
    private InvoicePositionInput parseRow(Row row){
        
        
        return new InvoicePositionInput(
            row.getCell(0).toString(),
            row.getCell(1).toString(),
            row.getCell(2).toString(),
            row.getCell(3).toString(),
            row.getCell(4).toString(),
            row.getCell(5).toString(),
            row.getCell(6).toString(),
            row.getCell(7).toString(),
            row.getCell(8).toString(),
            row.getCell(9).toString(),
            row.getCell(10).toString(),
            row.getCell(11).toString(),
            row.getCell(12).toString(),
            row.getCell(13).toString(),
            row.getCell(14).toString()
        );
    }
}
