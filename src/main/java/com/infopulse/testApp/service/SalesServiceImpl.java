package com.infopulse.testApp.service;

import com.infopulse.testApp.dao.*;
import com.infopulse.testApp.domain.Manufacturer;
import com.infopulse.testApp.domain.Mobile;
import com.infopulse.testApp.domain.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Влад on 31.10.2015.
 */
@Service
public class SalesServiceImpl implements SalesService {
    @Autowired
    private SalesDao salesDao;

    @Autowired
    @Qualifier(value = "mobileJpaDao")
    private MobileDao mobileDao;

    @Autowired
    private ManufacturerDao manufacturerDao;

    public void setSalesDao(SalesDao salesDao) {
        this.salesDao = salesDao;
    }

    public SalesServiceImpl() {
        System.out.println("Bean SalesServiceImpl was initialised");
    }

    public void addSale(Sales sales) { // + manufacturer and mobile for query
       salesDao.add(sales);
    }

    private static String getMobileName(Mobile mobile) {
       return mobile.getName();
    }

    private static long getMobileId(Mobile mobile) {
        return mobile.getMobileId();
    }

    private static BigDecimal getPrice(Mobile mobile) {
        return mobile.getPrice();
    }

    private static BigDecimal getProfit(Mobile mobile) {
        return mobile.getProfit();
    }

    private static Date getSaleDate() {
        Date date = new Date();
        return date;
    }





}
