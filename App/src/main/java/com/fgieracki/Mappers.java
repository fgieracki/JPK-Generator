package com.fgieracki;

import org.apache.commons.beanutils.converters.BigDecimalConverter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("java:S106") // System.out.println is used for console output
public class Mappers {
    Mappers() {}

    public static String mapBigDecimalString(String input) {
        String value = input;

        value = value.replace("zł", "").replace(",", ".").trim()
                .replace("\u00A0", "").replaceAll("\s+", "");;
        BigDecimalConverter converter = new BigDecimalConverter();
        BigDecimal res = BigDecimal.ZERO;
        try {
            res = (BigDecimal) converter.convert(BigDecimal.class, value);
        } catch (Exception e) {
            System.out.println("BigDecimal conversion exception: " + input + " -> " + value);
        }
            return res.toString();
    }



    public static Invoice mapToInvoice(InvoicePosition invoicePosition) {
         String P_14_1 = invoicePosition.getP_15().subtract(invoicePosition.getP_13_1())
                .setScale(2, RoundingMode.HALF_EVEN).toString();

         ArrayList<String> fields = new ArrayList<>();
            fields.add(invoicePosition.getP_1());
            fields.add(invoicePosition.getP_2B());
            fields.add(invoicePosition.getP_3A());
            fields.add(invoicePosition.getP_3B());
            fields.add(ProviderId.getPelnaNazwa());
            fields.add(ProviderAddress.stringAddress());
            fields.add(ProviderId.getNIP());
            fields.add(invoicePosition.getP_5B());
            fields.add(invoicePosition.getP_6());
            fields.add(invoicePosition.getP_13_1().toString());
            fields.add(P_14_1);
            fields.add(invoicePosition.getP_15().toString());

        return new Invoice(fields);
    }
}
