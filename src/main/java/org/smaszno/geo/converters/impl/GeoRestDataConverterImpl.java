package org.smaszno.geo.converters.impl;

import org.smaszno.geo.converters.GeoRestDataConverter;
import org.smaszno.geo.dto.GeoDataDTO;
import org.smaszno.geo.model.GeoData;
import org.springframework.stereotype.Service;

/**
 * Created by smaszno on 2017-06-06.
 */
@Service
public class GeoRestDataConverterImpl implements GeoRestDataConverter {

    @Override
    public GeoData convertFrom(GeoDataDTO geoDataDTO) {
        GeoData geoData = new GeoData();
        geoData.setLongitude(geoDataDTO.getLongitude());
        geoData.setLatitude(geoDataDTO.getLatitude());
        geoData.setElevation(geoDataDTO.getElevation());
        return geoData;
    }
}
