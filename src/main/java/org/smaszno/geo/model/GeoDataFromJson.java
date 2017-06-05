package org.smaszno.geo.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

/**
 * Created by smaszno on 2017-06-05.
 */
@Data
public class GeoDataFromJson {
    String longitude;
    String latitude;
    String elevation;




}
