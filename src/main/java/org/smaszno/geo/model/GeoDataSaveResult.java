package org.smaszno.geo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by smaszno on 2017-06-05.
 */
@Data
@AllArgsConstructor
public class GeoDataSaveResult {

    public enum Status {OK, ERROR};

    Status status;
    String error;

}
