package org.smaszno.geo.persistence;

import org.smaszno.geo.model.GeoData;
import org.springframework.stereotype.Service;

/**
 * Created by smaszno on 2017-06-06.
 */
@Service
public interface GeoRestPersistenceService {
    void create(GeoData geoData);
}
