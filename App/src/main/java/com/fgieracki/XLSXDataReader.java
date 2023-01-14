package com.fgieracki;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("java:S106") // Standard output is used to display messages to the user
public class XLSXDataReader implements DataReader {
    public List<InvoicePosition> readInvoicePositionsFromFile(String filePath, char fieldSeparator) {
        List<InvoicePosition> invoicePositions = new ArrayList<>();

        try(
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook  = new XSSFWorkbook(fis)
        ){
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                if(row.getRowNum() == 0) continue;
                invoicePositions.add(parseRow(row));
            }
        } catch (IOException e) {
            System.out.println("Error while reading file. Please check if the file is not corrupted");
        }
        return invoicePositions;
    }
    private InvoicePosition parseRow(Row row){
        ArrayList<String> fields = new ArrayList<>();
        for(Cell cell : row)
            fields.add(cell.toString());

        for(int i = 7; i < 15; i++)
            fields.set(i, Mappers.mapBigDecimalString(fields.get(i)));
        if(fields.size() != 15) {
            System.out.println("Error while reading file. Please check if the file is not corrupted");
            return null;
        }


        return new InvoicePosition(fields);
    }
}
