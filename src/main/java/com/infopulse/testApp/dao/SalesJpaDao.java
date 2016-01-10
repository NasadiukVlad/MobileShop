package com.infopulse.testApp.dao;

import com.infopulse.testApp.domain.Mobile;
import com.infopulse.testApp.domain.Sales;
import com.infopulse.testApp.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Created by Влад on 31.10.2015.
 */
@Repository
@Qualifier(value = "salesJpaDao")
public class SalesJpaDao implements SalesDao {

    public SalesJpaDao() {
        System.out.println("Bean SalesJpaDao was initialised");
    }

    public void add(Sales sales) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(sales);
        session.getTransaction().commit();
    }
}
