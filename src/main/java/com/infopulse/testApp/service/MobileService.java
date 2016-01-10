package com.infopulse.testApp.service;

import com.infopulse.testApp.domain.Manufacturer;
import com.infopulse.testApp.domain.Mobile;
import com.infopulse.testApp.domain.Sales;

/**
 * Created by ���� on 24.10.2015.
 */

public interface MobileService {
    void addMobile(Mobile mobile);
    public Mobile getMobile(long id);


}

