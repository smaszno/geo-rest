package org.smaszno.geo.converters;

import org.smaszno.geo.dto.GeoDataDTO;
import org.smaszno.geo.model.GeoData;
import org.springframework.stereotype.Service;

/**
 * Created by smaszno on 2017-06-06.
 */
@Service
public interface GeoRestDataConverter {
    GeoData convertFrom (GeoDataDTO geoDataDTO);
}
