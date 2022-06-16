package com.example.integracjaprojekt;

import java.util.Date;



public class CryptoPrice {



    public CryptoPrice() {
    }

    private String ticker;

    private java.util.Date Date;
    private Double Open;

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
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
}
