package com.fgieracki;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "tns:IdentyfikatorPodmiotu")
public class ProviderId {
    @XmlElement(name="etd:NIP")
    private static String NIP = "6762484560";

    @XmlElement(name="etd:PelnaNazwa")
    private static String PelnaNazwa = "\"CORE LOGIC\" SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ";

    public static String getNIP() {
        return NIP;
    }

    public static String getPelnaNazwa() {
        return PelnaNazwa;
    }
}
