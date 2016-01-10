package com.infopulse.testApp.service;

import com.infopulse.testApp.dao.ManufacturerDao;
import com.infopulse.testApp.dao.ManufacturerJpaDao;
import com.infopulse.testApp.domain.Manufacturer;
import com.infopulse.testApp.domain.Mobile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Влад on 31.10.2015.
 */
@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    @Autowired
    @Qualifier(value = "manufacturerJpaDao")
    private ManufacturerDao manufacturerDao;
    
    private int choose;




    public ManufacturerServiceImpl() {

    }


    public void addManufacturer(Manufacturer manufacturer, int choose) {
        this.choose = choose;

        switch (choose) {
            case 1:
                manufacturer.setManufacturerName("Samsung");
                manufacturer.setCountry("China");
                manufacturer.setContact("+ 345 4545 45 32");
                manufacturer.setEMail("service@samsung.com");
                break;
            case 2:
                manufacturer.setManufacturerName("LG");
                manufacturer.setCountry("Japan");
                manufacturer.setContact("+ 34 67 455 344 22");
                manufacturer.setEMail("service@lifeisgood.com");
                break;
            case 3:
                manufacturer.setManufacturerName("Iphone");
                manufacturer.setCountry("USA");
                manufacturer.setContact("+ 973 4545 32 12");
                manufacturer.setEMail("service@iphone.com");
        }

        manufacturerDao.addManufacturer(manufacturer);
    }

    public Manufacturer getManufacturer(long id) {
        return manufacturerDao.getManufacturer(id);

    }
}
