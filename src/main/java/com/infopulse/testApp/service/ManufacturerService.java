package com.infopulse.testApp.service;

import com.infopulse.testApp.domain.Manufacturer;

/**
 * Created by ���� on 31.10.2015.
 */
public interface ManufacturerService {
    void addManufacturer(Manufacturer manufacturer, int choose);
    public Manufacturer getManufacturer(long id);
}
