package com.example.jazs22622NBP.model;

import java.util.List;

public class NBPdata {

    public List<Currency> rates;

    public NBPdata() {}

    public NBPdata(List<Currency> rates) {this.rates =rates;}

    public List<Currency> getRates() {return rates;}

    public void setRates(List<Currency> rates) {
        this.rates = rates;
    }
}
