package com.infopulse.testApp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Влад on 31.10.2015.
 */

@Entity

public class Manufacturer {
    @Id
    @SequenceGenerator(initialValue=1, allocationSize=1, name="manufacturer_seq", sequenceName="manufacturer_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="manufacturer_seq")
    @Column(name = "manufacturer_id")
    private long manufacturerId;

    @Column(name = "Name")
    private String manufacturerName;

    @Column(name = "Country")
    private String Country;

    @Column(name = "eMail")
    private String eMail;

    @Column(name = "contact")
    private String contact;

    @OneToMany(mappedBy = "manufacturer")
    Set<Mobile> mobile;

    public Set<Mobile> getMobile() {
        return mobile;
    }

    public void setMobile(Set<Mobile> mobile) {
        this.mobile = mobile;
    }


    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String name) {
        this.manufacturerName = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }




}