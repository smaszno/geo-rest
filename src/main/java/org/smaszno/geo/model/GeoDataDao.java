package org.smaszno.geo.model;

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

    public void create(GeoDataDB geoDataDB)
    {
        entityManager.persist(geoDataDB);
    }
}
