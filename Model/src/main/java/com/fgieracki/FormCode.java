package com.fgieracki;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "tns:kodFormularza")
public class FormCode {
    @XmlAttribute(name="kodSystemowy")
    private static String systemCode = "JPK_FA (3)";

    @XmlAttribute(name="wersjaSchemy")
    private static String schemaVersion = "1-0";

    @XmlValue
    private static String formShortCode = "JPK_FA";


    FormCode() {}
}
