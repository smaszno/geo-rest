package org.smaszno.geo.persistence;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.smaszno.geo.converters.impl.GeoRestDataConverterImpl;
import org.smaszno.geo.dto.GeoDataDTO;
import org.smaszno.geo.model.GeoData;
import org.smaszno.geo.persistence.impl.GeoDataDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.mockito.Mockito.mock;


/**
 * Created by smaszno on 2017-06-06.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {GeoDataDaoImpl.class})

public class GeoDataDaoTest {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    GeoDataDao geoDataDao;


    GeoData geoDataMock;


    @Test
    @Transactional
    @Rollback(true)
    public void testStoringGeoData() throws Exception {
        geoDataDao.create(geoDataMock);
        GeoData storedGeoData = geoDataDao.findGeoDataById(geoDataMock.getId());
        Assert.assertEquals("GeoDataDaoTest: Longitude differs", storedGeoData.getLongitude(), geoDataMock.getLongitude());
        Assert.assertEquals("GeoDataDaoTest: Latitude differs", storedGeoData.getLatitude(), geoDataMock.getLatitude());
        Assert.assertEquals("GeoDataDaoTest: Elevation differs", storedGeoData.getElevation(), geoDataMock.getElevation());


    }

    @Before
    public void setUp() throws Exception {
        geoDataMock = new GeoData();
        geoDataMock.setLongitude( "123");
        geoDataMock.setLatitude("456");
        geoDataMock.setElevation("789");
    }
}