package com.infopulse.testApp.dao;

import com.infopulse.testApp.domain.Manufacturer;
import com.infopulse.testApp.domain.Mobile;
import com.infopulse.testApp.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Created by Влад on 31.10.2015.
 */
@Repository
@Qualifier(value = "manufacturerJpaDao")
public class ManufacturerJpaDao implements ManufacturerDao {

    public ManufacturerJpaDao() {
        System.out.println("Bean ManufacturerJpaDao was initialised");
    }

    public void addManufacturer(Manufacturer manufacturer) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(manufacturer);
        session.getTransaction().commit();
    }

    public Manufacturer getManufacturer(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Manufacturer manufacturer = (Manufacturer) session.get(Manufacturer.class, new Long(id));
        session.getTransaction().commit();
        session.close();
        return manufacturer;

    }
}