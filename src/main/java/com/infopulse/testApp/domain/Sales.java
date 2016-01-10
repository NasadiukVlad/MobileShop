package com.infopulse.testApp.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ���� on 24.10.2015.
 */

@Entity
//@Table(name = "sales")

public class Sales {
    @Id
    @SequenceGenerator(initialValue=1, allocationSize=1, name="sales_seq", sequenceName="sales_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sales_seq")
    @Column(name = "sale_Id")
    private long saleId;

    @Column(name = "name")
    private String name;

    @Column(name = "sale_Price")
    BigDecimal price;

    @Column(name = "sale_time")
    Date saleDate;

    @Column(name = "profit")
    BigDecimal profit;


    @Column(name = "mobile_id")
    private long mobileId;

    public Sales(String name, BigDecimal price, Date saleDate, BigDecimal profit, long mobileId ) {
        this.name = name;
        this.price = price;
        this.saleDate = saleDate;
        this.profit = profit;
        this.mobileId = mobileId;

    }


    public long getSaleId() {
        return saleId;
    }


    public void setSaleId(long id) {
        saleId = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public long getMobileId() {
        return mobileId;
    }

    public void setMobileId(long mobileId) {
        this.mobileId = mobileId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

}
