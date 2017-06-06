package org.smaszno.geo.persistence;

import org.smaszno.geo.model.GeoData;
import org.springframework.stereotype.Repository;

/**
 * Created by smaszno on 2017-06-06.
 */
@Repository
public interface GeoDataDao {
    void create(GeoData geoData);
    GeoData findGeoDataById(Long id);
}
