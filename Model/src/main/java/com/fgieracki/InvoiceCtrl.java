package com.fgieracki;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

public class InvoiceCtrl {
    private int LiczbaFaktur;
    private BigDecimal WartoscFaktur = new BigDecimal(0);


    public InvoiceCtrl() {
        LiczbaFaktur = 0;
    }

    InvoiceCtrl(HashMap<String, Invoice> invoices){
        this.LiczbaFaktur = invoices.size();
        for(Invoice item : invoices.values()){
            this.WartoscFaktur = this.WartoscFaktur.add(item.getP_15());
        }
    }
}
