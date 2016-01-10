package com.infopulse.testApp.dao;

import com.infopulse.testApp.domain.Mobile;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Влад on 19.11.2015.
 */
@Repository
@Qualifier(value = "mobileStubDao")
public class MobileStubDao implements MobileDao {

    private List<Mobile> db;

    public MobileStubDao() {
        System.out.println("Bean MobileStubDao was initialised");
        db = new ArrayList<Mobile>();
    }

    public void add(Mobile mobile) {
        db.add(mobile);
    }

    public List<Mobile> findPhone(String name, Long manufacturerId) {
        return null;
    }

    public int incrementAmount(String name, Long manufacturerId, int amount) {
        return 0;
    }

    public int decrementAmount(String name, Long manufacturerId, int amount) {
        return 0;
    }

    public Mobile getMobile(long id) {
        return null;
    }

}
