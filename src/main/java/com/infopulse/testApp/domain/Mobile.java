package com.infopulse.testApp.domain;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Влад on 24.10.2015.
 */
@NamedQueries({

        @NamedQuery(name = "Mobile.decrementAmount" , query = "update Mobile set amount = :amount where (name = :name and manufacturerId = :manufacturerId)" ),
        //если модель телефона существует в БД, добавить +1 к количеству
        @NamedQuery(name = "Mobile.incrementAmount" , query = "update Mobile set amount = :amount where (name = :name and manufacturerId = :manufacturerId)" ),
        //проверить наличие телефона соответствующей модели:
        @NamedQuery(name = "Mobile.findPhone" , query = "from Mobile where (name = :name and manufacturerId = :manufacturerId)")
})

@Entity
//@Table(name = "shop_items")

public class Mobile {
    @Id
    @SequenceGenerator(initialValue=1, allocationSize=1, name="mobile_seq", sequenceName="mobile_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="mobile_seq")
    @Column(name = "mobile_id", unique = true, nullable = false)
    private long mobileId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Price")
    BigDecimal price;

    @Column(name = "Amount")
    private int amount;

    @Column(name = "Profit")
    BigDecimal profit;


    @ManyToOne()
    private Manufacturer manufacturer;

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public long getMobileId() {
        return mobileId;
    }

    public void setMobileId(long id) {
        mobileId = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BigDecimal getMargin() {
        return profit;
    }

    public void setMargin(BigDecimal margin) {
        this.profit = margin;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }


}