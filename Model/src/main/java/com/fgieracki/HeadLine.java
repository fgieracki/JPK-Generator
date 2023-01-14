package com.fgieracki;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "tns:Naglowek")
public class HeadLine {
//    private static String kodSystemowy = "JPK_FA (3)";
//    private static String wersjaSchemy = "1-0";

    @XmlElement(name="tns:KodFormularza")
    private static String KodFormularza = "JPK_FA";

    @XmlElement(name="tns:WariantFormularza")
    private static String WariantFormularza = "3";

    @XmlElement(name="tns:CelZlozenia")
    private static String CelZlozenia = "1";

    @XmlElement(name="tns:DataWytworzeniaJPK")
    private static String DataWytworzeniaJPK = "2021-10-28T16:30:54.533";

    @XmlElement(name="tns:DataOd")
    private static String DataOd = "2021-10-01";

    @XmlElement(name="tns:DataDo")
    private static String DataDo = "2021-10-31";

    @XmlElement(name="tns:KodUrzedu")
    private static String KodUrzedu = "1208";

}
