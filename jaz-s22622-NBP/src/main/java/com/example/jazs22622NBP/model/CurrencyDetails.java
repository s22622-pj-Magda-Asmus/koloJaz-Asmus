package com.example.jazs22622NBP.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@ApiModel

public class CurrencyDetails {

    public CurrencyDetails() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty
    private Long id;
    @ApiModelProperty
    private BigDecimal avg;
    @ApiModelProperty
    private double value;
    @ApiModelProperty
    private LocalDate fromDate;
    @ApiModelProperty
    private LocalDate toDate;
    @ApiModelProperty
    private LocalDateTime createdAt = LocalDateTime.now();



//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }


    public CurrencyDetails(BigDecimal avg) {
        this.avg=avg;
    }

    public CurrencyDetails( BigDecimal avg, double value, LocalDate from, LocalDate to) {
        this.avg = avg;
        this.value=value;
        this.fromDate=from;
        this.toDate=to;

    }


            public Long getId() {return id;}

        public void setId(Long id) {this.id = id;}

    public double getWartosc() {
        return value;
    }

    public void setWartosc(double value) {
        this.value = value;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate from) {
        this.fromDate = from;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate to) {
        this.toDate = to;
    }


}