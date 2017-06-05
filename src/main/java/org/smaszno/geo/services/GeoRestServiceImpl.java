package org.smaszno.geo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smaszno.geo.model.GeoDataDao;
import org.smaszno.geo.model.GeoDataFromJson;
import org.smaszno.geo.model.GeoDataDB;
import org.smaszno.geo.model.GeoDataSaveResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by smaszno on 2017-06-05.
 */
@Service("geoRestService")
public class GeoRestServiceImpl implements GeoRestService {
    private static final Logger logger = LoggerFactory.getLogger(GeoRestServiceImpl.class);


    @Autowired
    GeoDataDao geoDataDao;

    GeoDataDB geoDataDB;

    @Override
    public GeoDataSaveResult saveData(GeoDataFromJson geoDataFromJson) {
// isolation of db object from external data
        convertGeoDataFromJsonIntoGeoDataDB(geoDataFromJson);
        storeGeoDataDB();
        return new GeoDataSaveResult(GeoDataSaveResult.Status.OK, null);
    }

    @Transactional
    private void storeGeoDataDB() {
        geoDataDao.create(geoDataDB);
    }


    private void convertGeoDataFromJsonIntoGeoDataDB(GeoDataFromJson geoDataFromJson)
    {
        geoDataDB =  new GeoDataDB();
        geoDataDB.setLongitude(geoDataFromJson.getLongitude());
        geoDataDB.setLatitude(geoDataFromJson.getLatitude());
        geoDataDB.setElevation(geoDataFromJson.getElevation());
    }


}
