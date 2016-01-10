package com.infopulse.testApp;

import com.infopulse.testApp.config.Config;
import com.infopulse.testApp.domain.Manufacturer;
import com.infopulse.testApp.domain.Mobile;
import com.infopulse.testApp.domain.Sales;
import com.infopulse.testApp.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Thread.sleep;

/**
 * Created by Влад on 14.10.2015.
 */
public class MobileShopMain {
    public static void main(String[] args) throws InterruptedException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        ManufacturerService manufacturerService = (ManufacturerService) context.getBean("manufacturerServiceImpl");

        Manufacturer manufacturer = new Manufacturer();

        for (int i = 1; i < 4; i++) {
            manufacturerService.addManufacturer(manufacturer, i);
        }

        MobileService mobileService = (MobileService) context.getBean("mobileServiceImpl");

        Set<Mobile> mobileSet = new HashSet<Mobile>();
        for (int i = 0; i < 20; i++) {
            Mobile mobile = new Mobile();

            mobileSet.add(mobile);
            manufacturer.setMobile(mobileSet);
            mobileService.addMobile(mobile);
        }

        SalesService salesService = (SalesService) context.getBean("salesServiceImpl");

        for (int i = 1; i <= 20; i++) {

            Sales sales = new Sales(mobileService.getMobile(i).getName(), mobileService.getMobile(i).getPrice(), new Date(), mobileService.getMobile(i).getProfit(), mobileService.getMobile(i).getMobileId());
            salesService.addSale(sales);
            sleep(2000);

        }
    }
}
