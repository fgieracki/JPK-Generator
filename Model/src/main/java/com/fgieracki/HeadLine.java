package com.fgieracki;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("java:S2440") // This is needed for JAXB to work properly
@XmlRootElement(name = "tns:Naglowek")
public class HeadLine {


    @XmlElement(name="tns:KodFormularza")
    private static FormCode formCode = new FormCode();

    @XmlElement(name="tns:WariantFormularza")
    private static String formVariant = "3";

    @XmlElement(name="tns:CelZlozenia")
    private static String submissionPurpose = "1";

    @XmlElement(name="tns:DataWytworzeniaJPK")
    private static String creationDateTime = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS"));

    @XmlElement(name="tns:DataOd")
    private static String dateFrom = "2021-10-01";

    @XmlElement(name="tns:DataDo")
    private static String dateTo = "2021-10-31";

    @XmlElement(name="tns:KodUrzedu")
    private static String officeCode = "1208";

    HeadLine() {}

}
