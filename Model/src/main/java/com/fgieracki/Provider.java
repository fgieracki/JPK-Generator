package com.fgieracki;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("java:S2440") // This is needed for JAXB to work properly
@XmlRootElement(name = "tns:Podmiot1")
public class Provider {
    Provider(){}

    @XmlElement(name="tns:IdentyfikatorPodmiotu")
    static ProviderId _providerId = new ProviderId();

    @XmlElement(name = "tns:AdresPodmiotu")
    static ProviderAddress _providerAddress = new ProviderAddress();

    public static ProviderId get_providerId() {
        return _providerId;
    }

    public static ProviderAddress get_providerAddress() {
        return _providerAddress;
    }
}
