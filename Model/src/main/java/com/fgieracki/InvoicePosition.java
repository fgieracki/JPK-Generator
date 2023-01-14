package com.fgieracki;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@SuppressWarnings({"java:S116", "java:S100"}) // variable names match the XML schema
@XmlRootElement(name = "tns:FakturaWiersz")
public class InvoicePosition {


    @XmlTransient
    private String P_3A; //nazwa nabywcy

    @XmlTransient
    private String P_3B; //adres nabywcy

    @XmlTransient
    private String P_5B; //nip nabywcy

    @XmlTransient
    private String P_1; //data wystawienia

    @XmlTransient
    private String P_6 = P_1; //data sprzedaży

    @XmlElement(name="tns:P_2B")
    private String P_2B; //numer faktury

    @XmlElement(name="tns:P_7")
    private String P_7; //tytuł pozycji

    @XmlElement(name="tns:P_8A")
    private String P_8A = "szt"; //jednostka miary

    @XmlElement(name="tns:P_8B")
    private String P_8B; //ilość

    @XmlElement(name="tns:P_9A")
    private String P_9A; //cena netto (jednostkowa)

    @XmlElement(name="tns:P_9B")
    private String P_9B; //cena brutto (łącznie)

    @XmlElement(name="tns:P_11")
    private String P_11; //wartość netto

    @XmlElement(name="tns:P_12")
    private String P_12; //stawka podatku VAT

    @XmlTransient
    private String P_14_1; //kwota podatku VAT (dla stawki 23% DLA JEDNEJ POZYCJI)


    @XmlTransient
    private String P_11A; //wartość brutto DO NOT DISPLAY?!

    @XmlTransient
    private String P_13_1; //wartosc netto faktury łącznie

    @XmlTransient
    private String P_15; //wartosc brutto faktury łącznie

    //Assigned in the constructor:



    public InvoicePosition(){
        //empty constructor
    }



    InvoicePosition(List<String> fields) {
        if(fields.size() != 15){
            throw new IllegalArgumentException("Wrong number of fields");
        }
        this.P_3A = fields.get(0);
        this.P_3B = fields.get(1);
        this.P_5B = fields.get(2);
        this.P_1 = fields.get(3);
        this.P_6 = fields.get(4);
        this.P_2B = fields.get(5);
        this.P_7 = fields.get(6);
        this.P_8B = fields.get(7);
        this.P_9A = fields.get(8);
        this.P_12 = fields.get(9);
        this.P_14_1 = fields.get(10);
        this.P_11 = fields.get(11);
        this.P_11A = fields.get(12);
        this.P_13_1 = fields.get(13);
        this.P_15 = fields.get(14);

        BigDecimal _multiplier = getP_12()
                .multiply(new BigDecimal("0.01")).
                add(new BigDecimal("1")); //mnożnik
        this.P_9B = getP_9A().multiply(_multiplier).setScale(2, RoundingMode.HALF_EVEN).toString(); //cena brutto
    }

    //Getters
    public String getP_3A() {
        return P_3A;
    }

    public String getP_3B() {
        return P_3B;
    }

    public String getP_5B() {
        return P_5B;
    }

    public String getP_1() {
        return P_1;
    }

    public String getP_6() {
        return P_6;
    }

    public String getP_2B() {
        return P_2B;
    }

    public String getP_7() {
        return P_7;
    }

    public BigDecimal getP_8B() {
        return new BigDecimal(P_8B);
    }

    public BigDecimal getP_9A() {
        return new BigDecimal(P_9A);
    }

    public BigDecimal getP_12() {
        return new BigDecimal(P_12);
    }

    public BigDecimal getP_14_1() {
        return new BigDecimal(P_14_1);
    }

    public BigDecimal getP_11() {
        return new BigDecimal(P_11);
    }

    public BigDecimal getP_11A() {
        return new BigDecimal(P_11A);
    }

    public BigDecimal getP_13_1() {
        return new BigDecimal(P_13_1);
    }

    public BigDecimal getP_15() {
        return new BigDecimal(P_15);
    }

    public BigDecimal getP_9B() {
        return new BigDecimal(P_9B);
    }

    public String getP_8A() {
        return P_8A;
    }

    @Override
    public String toString() {
        return "InvoicePosition{" +
                "P_3A='" + P_3A + '\'' +
                ", P_3B='" + P_3B + '\'' +
                ", P_5B='" + P_5B + '\'' +
                ", P_1='" + P_1 + '\'' +
                ", P_6='" + P_6 + '\'' +
                ", P_2B='" + P_2B + '\'' +
                ", P_7='" + P_7 + '\'' +
                ", P_8B=" + P_8B +
                ", P_9A=" + P_9A +
                ", P_12=" + P_12 +
                ", P_14_1=" + P_14_1 +
                ", P_11=" + P_11 +
                ", P_11A=" + P_11A +
                ", P_13_1=" + P_13_1 +
                ", P_15=" + P_15 +
                ", P_9B=" + P_9B +
                ", P_8A='" + P_8A + '\'' +
                "}\n";
    }
}
