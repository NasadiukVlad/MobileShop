package com.infopulse.testApp.service;

import com.infopulse.testApp.dao.ManufacturerDao;
import com.infopulse.testApp.dao.ManufacturerJpaDao;
import com.infopulse.testApp.dao.MobileDao;
import com.infopulse.testApp.dao.MobileJpaDao;
import com.infopulse.testApp.domain.Manufacturer;
import com.infopulse.testApp.domain.Mobile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;


/**
 * Created by Влад on 24.10.2015.
 */

@Service
public class MobileServiceImpl implements MobileService {
    @Autowired
    @Qualifier(value = "mobileJpaDao")
    private MobileDao mobileDao;

    @Autowired
    private ManufacturerDao manufacturerDao;

    public MobileServiceImpl() {
        System.out.println("Bean MobileServiceImpl was initialised");
    }

    Random rand = new Random();

    public void addMobile(Mobile mobile) {
        long idMan = 1 + rand.nextInt(3);

        mobile.setManufacturer(manufacturerDao.getManufacturer(idMan));
        mobile.setName(generateRandomName(mobile));
        mobile.setPrice(genereateRandomPrice(mobile));
        mobile.setProfit(genereateRandomMargin(mobile));
        mobile.setAmount(genereateRandomAmount());
        mobile.setMargin(genereateRandomMargin(mobile));

        mobileDao.add(mobile);

    }

    private static Manufacturer getRandomManufacturer(long id) {
        Manufacturer manufacturer = new Manufacturer();
        return manufacturer;
    }

    private static BigDecimal genereateRandomPrice(Mobile mobile) {
        long manufacturerId = mobile.getManufacturer().getManufacturerId();

        if (manufacturerId == 1) {
            return new BigDecimal(3500);
        }
        if (manufacturerId == 2) {
            return new BigDecimal(4000);
        } else return new BigDecimal(5500);

    }

    private static String generateRandomName(Mobile mobile) {
        long manufacturerId = mobile.getManufacturer().getManufacturerId();

        if (manufacturerId == 1) {
            return "l90 D410";
        }
        if (manufacturerId == 2) {
            return "Galaxy Note";
        } else return "5S";

    }

    private static int genereateRandomAmount() {

        int amount = 1;
        return amount;

    }

    private static BigDecimal genereateRandomMargin(Mobile mobile) {

        long manufacturerId = mobile.getManufacturer().getManufacturerId();

        if (manufacturerId == 1) {
            return new BigDecimal(500);
        }
        if (manufacturerId == 2) {
            return new BigDecimal(1000);
        } else return new BigDecimal(1500);
    }

    public Mobile getMobile(long id) {
        return mobileDao.getMobile(id);
    }
}
