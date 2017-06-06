package org.smaszno.geo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by smaszno on 2017-06-05.
 */
@Data
@AllArgsConstructor
public class GeoDataStoreResultDTO {

    public enum Status {OK, ERROR};

    Long id;
    Status status;
    String error;

}
