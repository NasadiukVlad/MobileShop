package com.infopulse.testApp.dao;

import com.infopulse.testApp.domain.Manufacturer;
import com.infopulse.testApp.domain.Mobile;

/**
 * Created by Влад on 31.10.2015.
 */
public interface ManufacturerDao {
      void addManufacturer(Manufacturer manufacturer);
      public Manufacturer getManufacturer(long id);
}
