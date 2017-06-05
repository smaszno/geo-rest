package org.smaszno.geo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.smaszno.geo.model.GeoData;
import org.smaszno.geo.model.GeoDataSaveResult;
import org.smaszno.geo.services.GeoRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.*;

/**
 * Created by smaszno on 2017-06-05.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {GeoRestService.class})
public class GeoRestServiceImplTest {


    @Autowired
    GeoRestService geoRestService;

    GeoData geoDataMock;


    @Test
    public void saveData() throws Exception {
        GeoDataSaveResult result = geoRestService.saveData(geoDataMock);
        assertEquals("Data should be successfully saved", result.getStatus(), GeoDataSaveResult.Status.OK);
    }

    @Before
    public void setUp() throws Exception {
        generateGeoDataMock();
    }

    private void generateGeoDataMock() {
        geoDataMock = new GeoData();
        geoDataMock.setLongitude("123");
        geoDataMock.setLatitude("456");
        geoDataMock.setElevation("789");
    }


}