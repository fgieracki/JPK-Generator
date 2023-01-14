package com.fgieracki;

import com.opencsv.bean.CsvBindByPosition;

public class InvoicePositionInput {
    @CsvBindByPosition(position = 0)
    private String P_3A; //nazwa nabywcy

    @CsvBindByPosition(position = 1)
    private String P_3B; //adres nabywcy

    @CsvBindByPosition(position = 2)
    private String P_5B; //nip nabywcy

    @CsvBindByPosition(position = 3)
    private String P_1; //data wystawienia

    @CsvBindByPosition(position = 4)
    private String P_6 = P_1; //data sprzedaży

    @CsvBindByPosition(position = 5)
    private String P_2B; //numer faktury

    @CsvBindByPosition(position = 6)
    private String P_7; //tytuł pozycji

    @CsvBindByPosition(position = 7)
    private String P_8B; //ilość

    @CsvBindByPosition(position = 8)
    private String P_9A; //cena netto (jednostkowa)

    @CsvBindByPosition(position = 9)
    private String P_12 = "23"; //stawka podatku VAT

    @CsvBindByPosition(position = 10)
    private String P_14_1; //kwota podatku VAT (dla stawki 23% DLA JEDNEJ POZYCJI)

    @CsvBindByPosition(position = 11)
    private String P_11; //wartość netto

    @CsvBindByPosition(position = 12)
    private String P_11A; //wartość brutto DO NOT DISPLAY?!

    @CsvBindByPosition(position = 13)
    private String P_13_1; //wartosc netto faktury łącznie

    @CsvBindByPosition(position = 14)
    private String P_15; //wartosc brutto faktury łącznie

    //Assigned in the constructor:
    private String P_9B; //cena brutto (łącznie)
    private String P_8A = "szt"; //jednostka miary

    public InvoicePositionInput(){}

    public InvoicePositionInput(
            String P_3A, String P_3B, String P_5B, String P_1,
            String P_6, String P_2B, String P_7, String P_8B,
            String P_9A, String P_12, String P_14_1, String P_11,
            String P_11A, String P_13_1, String P_15
    ){
        this.P_3A = P_3A;
        this.P_3B = P_3B;
        this.P_5B = P_5B;
        this.P_1 = P_1;
        this.P_6 = P_6;
        this.P_2B = P_2B;
        this.P_7 = P_7;
        this.P_8B = P_8B;
        this.P_9A = P_9A;
        this.P_12 = P_12;
        this.P_14_1 = P_14_1;
        this.P_11 = P_11;
        this.P_11A = P_11A;
        this.P_13_1 = P_13_1;
        this.P_15 = P_15;;
    }

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

    public String getP_8B() {
        return P_8B;
    }

    public String getP_9A() {
        return P_9A;
    }

    public String getP_12() {
        return P_12;
    }

    public String getP_14_1() {
        return P_14_1;
    }

    public String getP_11() {
        return P_11;
    }

    public String getP_11A() {
        return P_11A;
    }

    public String getP_13_1() {
        return P_13_1;
    }

    public String getP_15() {
        return P_15;
    }

    public String getP_9B() {
        return P_9B;
    }

    public String getP_8A() {
        return P_8A;
    }

    @Override
    public String toString() {
        return "InvoicePositionInput{" +
                "P_3A='" + P_3A + '\'' +
                ", P_3B='" + P_3B + '\'' +
                ", P_5B='" + P_5B + '\'' +
                ", P_1='" + P_1 + '\'' +
                ", P_6='" + P_6 + '\'' +
                ", P_2B='" + P_2B + '\'' +
                ", P_7='" + P_7 + '\'' +
                ", P_8B='" + P_8B + '\'' +
                ", P_9A='" + P_9A + '\'' +
                ", P_12='" + P_12 + '\'' +
                ", P_14_1='" + P_14_1 + '\'' +
                ", P_11='" + P_11 + '\'' +
                ", P_11A='" + P_11A + '\'' +
                ", P_13_1='" + P_13_1 + '\'' +
                ", P_15='" + P_15 + '\'' +
                ", P_9B='" + P_9B + '\'' +
                ", P_8A='" + P_8A + '\'' +
                "}\n";
    }
}
