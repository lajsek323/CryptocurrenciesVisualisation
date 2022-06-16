package com.example.integracjaprojekt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement(name = "CryptoList")
@XmlAccessorType(XmlAccessType.FIELD)
public class CryptoList {

    @XmlElement(name = "Crypto")
    public List<Crypto> Crypto;

    public CryptoList(List<com.example.integracjaprojekt.Crypto> crypto) {
        Crypto = crypto;
    }

    public CryptoList() {
    }

    public List<com.example.integracjaprojekt.Crypto> getCrypto() {
        return Crypto;
    }

    public void setCrypto(List<com.example.integracjaprojekt.Crypto> crypto) {
        Crypto = crypto;
    }

    public void getInfo(){
        Crypto.forEach(s -> System.out.println(s.toString()));
    }


}
