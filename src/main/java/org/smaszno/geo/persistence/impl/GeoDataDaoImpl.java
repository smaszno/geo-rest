package org.smaszno.geo.persistence.impl;

import org.smaszno.geo.model.GeoData;
import org.smaszno.geo.persistence.GeoDataDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by smaszno on 2017-06-05.
 */
@Repository
public class GeoDataDaoImpl implements GeoDataDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void create(GeoData geoData)
    {
        entityManager.persist(geoData);
    }


    public GeoData findGeoDataById(Long id)
    {
        return entityManager.find(GeoData.class, id);
    }
}
