package com.fgieracki;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.math.BigDecimal;
import java.util.ArrayList;

@XmlRootElement
public class InvoiceRowCtrl {

    @XmlElement(name="tns:LiczbaWierszyFaktur")
    private int LiczbaWierszyFaktur;

    @XmlElement(name="tns:WartoscWierszyFaktur")
    private BigDecimal WartoscWierszyFaktur = new BigDecimal(0);

    public InvoiceRowCtrl(){}

    InvoiceRowCtrl(ArrayList<InvoicePosition> invoicePositions){
        this.LiczbaWierszyFaktur = invoicePositions.size();
        for(InvoicePosition item : invoicePositions){
            this.WartoscWierszyFaktur = this.WartoscWierszyFaktur.add(item.getP_11());
        }
    }

}
