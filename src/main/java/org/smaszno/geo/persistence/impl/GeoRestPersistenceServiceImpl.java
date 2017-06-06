package org.smaszno.geo.persistence.impl;

import org.smaszno.geo.model.GeoData;
import org.smaszno.geo.persistence.GeoDataDao;
import org.smaszno.geo.persistence.GeoRestPersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by smaszno on 2017-06-05.
 */
@Transactional
@Service
public class GeoRestPersistenceServiceImpl implements GeoRestPersistenceService {
    @Autowired
    GeoDataDao geoDataDao;

    public void create(GeoData geoData) {
        geoDataDao.create(geoData);
    }
}
