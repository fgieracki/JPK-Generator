package com.fgieracki;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@XmlRootElement(name = "tns:JPK")
public class AppData {

    @XmlAttribute(name = "xmlns:tns")
    private String tns = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/";

    @XmlAttribute(name = "xmlns:xsi")
    private String xsi = "http://www.w3.org/2001/XMLSchema-instance";

    @XmlAttribute(name = "xmlns:etd")
    private String etd = "http://crd.gov.pl/xml/schematy/dziedzinowe/mf/2018/08/24/eD/DefinicjeTypy/";

    @XmlAttribute(name = "xmlns:kck")
    private String kck = "http://crd.gov.pl/xml/schematy/dziedzinowe/mf/2013/05/23/eD/KodyCECHKRAJOW/";

    @XmlAttribute(name = "xmlns:xsd")
    private String xsd = "http://www.w3.org/2001/XMLSchema";

    @XmlAttribute(name = "xmlns:msxsl")
    private String msxsl = "urn:schemas-microsoft-com:xslt";

    @XmlAttribute(name = "xmlns:usr")
    private String usr = "urn:the-xml-files:xslt";

    @XmlAttribute(name = "xsi:schemaLocation")
    private String schemaLocation = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/ https://www.gov.pl/attachment/1abeab45-4e71-4616-b8d5-6b71699e86f8";

    @XmlElement(name = "tns:Naglowek")
    public HeadLine headLine = new HeadLine();

    @XmlElement(name = "tns:Podmiot1")
    public Provider provider = new Provider();


    @XmlTransient
    public HashMap<String, Invoice> invoices = new HashMap<String, Invoice>();

    @XmlElement(name = "tns:Faktura")
    public List<Invoice> invoicesList = new ArrayList<>();

    @XmlElement
    public InvoiceCtrl invoiceCtrl = new InvoiceCtrl(invoices);


    @XmlElement(name = "tns:FakturaWiersz")
    public List<InvoicePosition> invoicePositions = new ArrayList<InvoicePosition>();

    @XmlElement(name = "tns:FakturaWierszCtrl")
    public InvoiceRowCtrl invoiceRowCtrl = new InvoiceRowCtrl((ArrayList<InvoicePosition>) invoicePositions);

    public void makeSummary () {
        invoiceCtrl = new InvoiceCtrl(invoices);
        invoiceRowCtrl = new InvoiceRowCtrl((ArrayList<InvoicePosition>) invoicePositions);
        invoicesList = new ArrayList<>(invoices.values());
    }


}
