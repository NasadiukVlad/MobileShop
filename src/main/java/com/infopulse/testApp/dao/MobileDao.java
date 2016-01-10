package com.infopulse.testApp.dao;
import com.infopulse.testApp.domain.Manufacturer;
import com.infopulse.testApp.domain.Mobile;
import com.infopulse.testApp.domain.Sales;

import java.util.List;

/**
 * Created by Влад on 24.10.2015.
 */

public interface MobileDao {
    void add (Mobile mobile);
    List<Mobile> findPhone(String name, Long manufacturerId);
    int incrementAmount(String name, Long manufacturerId, int amount);
    int decrementAmount(String name, Long manufacturerId, int amount);
    public Mobile getMobile(long id);
}

