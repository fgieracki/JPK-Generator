package com.fgieracki;

import org.apache.commons.beanutils.converters.BigDecimalConverter;

import java.util.ArrayList;
import java.util.HashMap;

public class InvoiceGenerator {

    InvoiceGenerator() {}

    static HashMap<String, Invoice> generateInvoices(ArrayList<InvoicePosition> invoicePositions) {
        HashMap<String, Invoice> result = new HashMap<>();
        for(InvoicePosition invoicePosition : invoicePositions) {
            if(result.get(invoicePosition.getP_2B()) == null){
                result.put(invoicePosition.getP_2B(), generateInvoice(invoicePosition));
            }
        }
        return result;
    }

    private static Invoice generateInvoice(InvoicePosition invoicePosition){
        return Mappers.mapToInvoice(invoicePosition);
    }
}
