package org.smaszno.geo.services;

import org.smaszno.geo.model.GeoDataFromJson;
import org.smaszno.geo.model.GeoDataSaveResult;

/**
 * Created by smaszno on 2017-06-05.
 */

public interface GeoRestService {
        GeoDataSaveResult saveData(GeoDataFromJson geoDataFromJson);

}
