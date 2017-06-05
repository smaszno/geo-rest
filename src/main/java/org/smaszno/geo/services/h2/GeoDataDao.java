package org.smaszno.geo.services.h2;

import org.smaszno.geo.model.GeoData;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by smaszno on 2017-06-05.
 */
@Repository
public class GeoDataDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void create(GeoData geoData)
    {
        entityManager.persist(geoData);
    }
}
