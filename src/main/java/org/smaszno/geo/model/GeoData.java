package org.smaszno.geo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by smaszno on 2017-06-05.
 */
@Entity
@Table(name="geo_data")
@Data
public class GeoData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    @Column
    String longitude;

    @Column
    String latitude;

    @Column
    String elevation;
}
