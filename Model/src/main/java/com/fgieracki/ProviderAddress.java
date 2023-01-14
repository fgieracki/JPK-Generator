package com.fgieracki;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "tns:AdresPodmiotu")
public class ProviderAddress {

    @XmlElement(name="etd:KodKraju")
    private static String KodKraju = "PL";

    @XmlElement(name="etd:Wojewodztwo")
    private static String Wojewodztwo = "małopolskie";

    @XmlElement(name="etd:Powiat")
    private static String Powiat = "m. Kraków";

    @XmlElement(name="etd:Gmina")
    private static String Gmina = "Kraków";

    @XmlElement(name="etd:Ulica")
    private static String Ulica = "ul. Karmelicka";

    @XmlElement(name="etd:NrDomu")
    private static String NrDomu = "15";

    @XmlElement(name="etd:NrLokalu")
    private static String NrLokalu = "1";

    @XmlElement(name="etd:Miejscowosc")
    private static String Miejscowosc = "Kraków";

    @XmlElement(name="etd:KodPocztowy")
    private static String KodPocztowy = "31-001";

    public static String stringAddress() {
        return Ulica + " " + NrDomu + "/" + NrLokalu + ", " + KodPocztowy + " " + Miejscowosc;
    }
}
