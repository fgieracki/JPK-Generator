package com.fgieracki;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;

@XmlRootElement(name = "tns:FakturaCtrl")
public class InvoiceCtrl {

    @XmlElement(name = "tns:LiczbaFaktur")
    private int LiczbaFaktur;

    @XmlElement(name = "tns:WartoscFaktur")
    private BigDecimal WartoscFaktur = new BigDecimal(0).setScale(2, RoundingMode.HALF_EVEN);


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
