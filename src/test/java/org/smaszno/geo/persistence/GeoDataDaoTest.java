package org.smaszno.geo.persistence;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.smaszno.geo.model.GeoData;
import org.smaszno.geo.persistence.impl.GeoDataDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;


/**
 * Created by smaszno on 2017-06-06.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
@Import(GeoDataDaoImpl.class)
public class GeoDataDaoTest {


    @Autowired
    GeoDataDao geoDataDao;


    GeoData geoDataMock;


    @Test
    public void testStoringGeoData() throws Exception {
        geoDataDao.create(geoDataMock);
        GeoData storedGeoData = geoDataDao.findGeoDataById(geoDataMock.getId());
        Assert.assertEquals("GeoDataDaoTest: Longitude differs", geoDataMock.getLongitude(), storedGeoData.getLongitude());
        Assert.assertEquals("GeoDataDaoTest: Latitude differs", geoDataMock.getLatitude(), storedGeoData.getLatitude());
        Assert.assertEquals("GeoDataDaoTest: Elevation differs", geoDataMock.getElevation(), storedGeoData.getElevation());


    }

    @Before
    public void setUp() throws Exception {
        geoDataMock = new GeoData();
        geoDataMock.setLongitude( "123");
        geoDataMock.setLatitude("456");
        geoDataMock.setElevation("789");

    }
}