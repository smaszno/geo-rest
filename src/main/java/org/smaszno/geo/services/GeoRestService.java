package org.smaszno.geo.services;

import org.smaszno.geo.dto.GeoDataDTO;
import org.smaszno.geo.dto.GeoDataStoreResultDTO;
import org.springframework.stereotype.Service;

/**
 * Created by smaszno on 2017-06-06.
 */
@Service
public interface GeoRestService {
    GeoDataStoreResultDTO saveData(GeoDataDTO geoDataDTO);
}
