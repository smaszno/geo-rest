package org.smaszno.geo.services;

import org.smaszno.geo.model.GeoData;
import org.smaszno.geo.model.GeoDataSaveResult;
import org.smaszno.geo.services.h2.GeoRestH2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by smaszno on 2017-06-05.
 */
@Service
public class GeoRestService {

        @Autowired
        GeoRestH2Service geoRestH2Service;

        public GeoDataSaveResult saveData(GeoData geoData) {
                geoRestH2Service.create(geoData);
                return new GeoDataSaveResult(GeoDataSaveResult.Status.OK, null);
        }





}
