package com.fgieracki;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

import java.math.BigDecimal;

@XmlRootElement(name = "tns:Faktura")
public class Invoice {
    @XmlTransient
    private String falseString = "false";

    @XmlElement(name="tns:KodWaluty")
    private String KodWaluty = "PLN";

    @XmlElement(name="tns:P_1")
    private String P_1;

    @XmlElement(name="tns:P_2A")
    private String P_2A;

    @XmlElement(name="tns:P_3A")
    private String P_3A;

    @XmlElement(name="tns:P_3B")
    private String P_3B;

    @XmlElement(name="tns:P_3C")
    private String P_3C;

    @XmlElement(name="tns:P_3D")
    private String P_3D;

    @XmlElement(name="tns:P_4A")
    private String P_4A = "PL";

    @XmlElement(name="tns:P_4B")
    private String P_4B;

    @XmlElement(name="tns:P_5B")
    private String P_5B;

    @XmlElement(name="tns:P_6")
    private String P_6;

    @XmlElement(name="tns:P_13_1")
    private String P_13_1;

    @XmlElement(name="tns:P_14_1")
    private String P_14_1;

    @XmlElement(name="tns:P_15")
    private String P_15;

    @XmlElement(name="tns:P_16")
    private String P_16 = falseString;

    @XmlElement(name="tns:P_17")
    private String P_17 = falseString;

    @XmlElement(name="tns:P_18")
    private String P_18 = falseString;

    @XmlElement(name="tns:P_18A")
    private String P_18A = falseString;

    @XmlElement(name="tns:P_19")
    private String P_19 = falseString;

    @XmlElement(name="tns:P_20")
    private String P_20 = falseString;

    @XmlElement(name="tns:P_21")
    private String P_21 = falseString;

    @XmlElement(name="tns:P_22")
    private String P_22 = falseString;

    @XmlElement(name="tns:P_23")
    private String P_23 = falseString;

    @XmlElement(name="tns:P_106E_2")
    private String P_106E_2 = falseString;

    @XmlElement(name="tns:P_106E_3")
    private String P_106E_3 = falseString;

    @XmlElement(name="tns:RodzajFaktury")
    private String RodzajFaktury = "VAT";


    public Invoice() {
    }

    public Invoice(
            String P_1, String P_2A, String P_3A, String P_3B,
            String P_3C, String P_3D, String P_4B,
            String P_5B, String P_6, String P_13_1, String P_14_1,
            String P_15) {
                this.P_1 = P_1;
                this.P_2A = P_2A;
                this.P_3A = P_3A;
                this.P_3B = P_3B;
                this.P_3C = P_3C;
                this.P_3D = P_3D;
                this.P_4B = P_4B;
                this.P_5B = P_5B;
                this. P_6 = P_6;
                this.P_13_1 = P_13_1;
                this.P_14_1 = P_14_1;
                this.P_15 = P_15;

    }

    @Override
    public String toString() {
        return "Invoice{" +
                "falseString='" + falseString + '\'' +
                ", KodWaluty='" + KodWaluty + '\'' +
                ", P_1='" + P_1 + '\'' +
                ", P_2A='" + P_2A + '\'' +
                ", P_3A='" + P_3A + '\'' +
                ", P_3B='" + P_3B + '\'' +
                ", P_3C='" + P_3C + '\'' +
                ", P_3D='" + P_3D + '\'' +
                ", P_4A='" + P_4A + '\'' +
                ", P_4B='" + P_4B + '\'' +
                ", P_5B='" + P_5B + '\'' +
                ", P_6='" + P_6 + '\'' +
                ", P_13_1='" + P_13_1 + '\'' +
                ", P_14_1='" + P_14_1 + '\'' +
                ", P_15='" + P_15 + '\'' +
                ", P_16='" + P_16 + '\'' +
                ", P_17='" + P_17 + '\'' +
                ", P_18='" + P_18 + '\'' +
                ", P_18A='" + P_18A + '\'' +
                ", P_19='" + P_19 + '\'' +
                ", P_20='" + P_20 + '\'' +
                ", P_21='" + P_21 + '\'' +
                ", P_22='" + P_22 + '\'' +
                ", P_23='" + P_23 + '\'' +
                ", P_106E_2='" + P_106E_2 + '\'' +
                ", P_106E_3='" + P_106E_3 + '\'' +
                ", RodzajFaktury='" + RodzajFaktury + '\'' +
                '}';
    }

    public BigDecimal getP_15() {
        return BigDecimal.valueOf(Double.parseDouble(P_15));
    }
}
