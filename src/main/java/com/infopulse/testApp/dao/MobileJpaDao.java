package com.infopulse.testApp.dao;

import com.infopulse.testApp.domain.Mobile;
import com.infopulse.testApp.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Влад on 24.10.2015.
 */
@Repository
@Qualifier(value = "mobileJpaDao")
public class MobileJpaDao implements MobileDao {

    public MobileJpaDao () {
        System.out.println("Bean MobileJpaDao was initialised");
    }

    public void add(Mobile mobile) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(mobile);
        session.getTransaction().commit();
    }

    public Mobile getMobile(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Mobile mobile = (Mobile)session.get(Mobile.class,new Long(id));
        session.getTransaction().commit();
        session.close();
        return mobile;
    }

    public List<Mobile> findPhone(String name, Long manufacturerId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.getNamedQuery("Mobile.findPhone");
        query.setString("name", name);
        query.setLong("manufacturerId", manufacturerId);
        return query.list();
    }

    public int incrementAmount(String name, Long manufacturerId, int amount) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.getNamedQuery("Mobile.incrementAmount");
        query.setString("name", name);
        query.setLong("manufacturerId", manufacturerId);
        query.setInteger("amount", amount);
        return query.executeUpdate();
    }

    public int decrementAmount(String name, Long manufacturerId, int amount) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.getNamedQuery("Mobile.incrementAmount");
        query.setString("name", name);
        query.setLong("manufacturerId", manufacturerId);
        query.setInteger("amount", amount);
        return query.executeUpdate();
    }
}