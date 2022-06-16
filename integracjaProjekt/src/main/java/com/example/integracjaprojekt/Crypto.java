package com.example.integracjaprojekt;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;
import java.util.Date;

@XmlRootElement(name = "Crypto")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Crypto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ticker;
    private String TokenName;
    private Date Date;
    private Double Open;
    private Double High;
    private Double Low;
    private Double Close;
    private Double Volume;
    private Double Market_Cap;

    @Override
    public String toString() {
        return "Crypto{" +
                "id=" + id +
                ", ticker='" + ticker + '\'' +
                ", TokenName='" + TokenName + '\'' +
                ", Date='" + Date + '\'' +
                ", Open=" + Open +
                ", High=" + High +
                ", Low=" + Low +
                ", Close=" + Close +
                ", Volume=" + Volume +
                ", Market_Cap=" + Market_Cap +
                '}';
    }

    public Crypto() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getTokenName() {
        return TokenName;
    }

    public void setTokenName(String tokenName) {
        TokenName = tokenName;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public Double getOpen() {
        return Open;
    }

    public void setOpen(Double open) {
        Open = open;
    }

    public Double getHigh() {
        return High;
    }

    public void setHigh(Double high) {
        High = high;
    }

    public Double getLow() {
        return Low;
    }

    public void setLow(Double low) {
        Low = low;
    }

    public Double getClose() {
        return Close;
    }

    public void setClose(Double close) {
        Close = close;
    }


    public Double getVolume() {
        return Volume;
    }

    public void setVolume(Double volume) {
        Volume = volume;
    }

    public Double getMarket_Cap() {
        return Market_Cap;
    }

    public void setMarket_Cap(Double market_Cap) {
        Market_Cap = market_Cap;
    }
}
