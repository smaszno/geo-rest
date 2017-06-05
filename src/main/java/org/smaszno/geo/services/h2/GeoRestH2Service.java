package org.smaszno.geo.services.h2;

import org.smaszno.geo.model.GeoData;
import org.smaszno.geo.services.GeoRestDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by smaszno on 2017-06-05.
 */
@Transactional
@Service
public class GeoRestH2Service implements GeoRestDBService {
    @Autowired
    GeoDataDao geoDataDao;

    public void create(GeoData geoData) {
        geoDataDao.create(geoData);
    }
}
