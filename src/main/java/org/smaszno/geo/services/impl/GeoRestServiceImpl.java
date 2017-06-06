package org.smaszno.geo.services.impl;

import org.smaszno.geo.converters.GeoRestDataConverter;
import org.smaszno.geo.dto.GeoDataDTO;
import org.smaszno.geo.dto.GeoDataStoreResultDTO;
import org.smaszno.geo.model.GeoData;
import org.smaszno.geo.persistence.GeoRestPersistenceService;
import org.smaszno.geo.services.GeoRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by smaszno on 2017-06-05.
 */
@Service
public class GeoRestServiceImpl implements GeoRestService {

        @Autowired
        GeoRestPersistenceService geoRestPersistenceService;


        @Autowired
        GeoRestDataConverter geoRestDataConverter;

        public GeoDataStoreResultDTO saveData(GeoDataDTO geoDataDTO) {
                GeoData geoData = convertFromGeoDataDTOToGeoData(geoDataDTO);
                persistGeoData(geoData);
                return generateStorageResult(geoData);
        }

        private GeoData convertFromGeoDataDTOToGeoData(GeoDataDTO geoDataDTO)
        {
                return geoRestDataConverter.convertFrom(geoDataDTO);
        }

        private void persistGeoData(GeoData geoData)
        {
                geoRestPersistenceService.create(geoData);
        }

        private GeoDataStoreResultDTO generateStorageResult(GeoData geoData)
        {
                return new GeoDataStoreResultDTO(geoData.getId(), GeoDataStoreResultDTO.Status.OK, null);
        }






}
