package com.example.jazs22622NBP.model;

public class Currency {
    private String days;
    private Double mid;

    public Currency() {
    }

    public Currency(String days, Double mid) {
        this.days = days;
        this.mid = mid;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public Double getMid() {
        return mid;
    }

    public void setMid(Double mid) {
        this.mid = mid;
    }
}
