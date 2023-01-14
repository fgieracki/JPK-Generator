package com.fgieracki;

import org.apache.commons.beanutils.converters.BigDecimalConverter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Mappers {
    public static BigDecimal mapToBigDecimal(String input) {
        String value = input;

        value = value.replace("zł", "").replace(",", ".").trim().replace(" ", "");;
        BigDecimalConverter converter = new BigDecimalConverter();
        BigDecimal res = BigDecimal.ZERO;
        try {
            res = (BigDecimal) converter.convert(BigDecimal.class, value);
        } catch (Exception e) {
            System.out.println("BigDecimal conversion exception: " + input + " -> " + value);
        }
            return res;
    }

    public static InvoicePosition mapToInvoicePosition(InvoicePositionInput input) {
        return new InvoicePosition(
                input.getP_3A(),
                input.getP_3B(),
                input.getP_5B(),
                input.getP_1(),
                input.getP_6(),
                input.getP_2B(),
                input.getP_7(),
                mapToBigDecimal(input.getP_8B()),
                mapToBigDecimal(input.getP_9A()),
                mapToBigDecimal(input.getP_12()),
                mapToBigDecimal(input.getP_14_1()),
                mapToBigDecimal(input.getP_11()),
                mapToBigDecimal(input.getP_11A()),
                mapToBigDecimal(input.getP_13_1()),
                mapToBigDecimal(input.getP_15())
        );
    }

    public static ArrayList<InvoicePosition> mapToInvoicePositions(List<InvoicePositionInput> input) {
        ArrayList<InvoicePosition> output = new ArrayList<>();

        for(InvoicePositionInput item : input){
            output.add(mapToInvoicePosition(item));
        }

        return output;
    }

    public static Invoice mapToInvoice(InvoicePosition invoicePosition) {
         String P_14_1 = invoicePosition.getP_15().subtract(invoicePosition.getP_13_1())
                .setScale(2, RoundingMode.HALF_EVEN).toString();
        return new Invoice(
            invoicePosition.getP_1(),
            invoicePosition.getP_2B(),
            invoicePosition.getP_3A(),
            invoicePosition.getP_3B(),
            ProviderId.getPelnaNazwa(),
            ProviderAddress.stringAddress(),
            ProviderId.getNIP(),
            invoicePosition.getP_5B(),
            invoicePosition.getP_6(),
            invoicePosition.getP_13_1().toString(),
            P_14_1,
            invoicePosition.getP_15().toString()
        );
    }
}
