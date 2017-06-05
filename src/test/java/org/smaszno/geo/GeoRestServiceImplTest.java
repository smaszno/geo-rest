package org.smaszno.geo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.smaszno.geo.model.GeoDataFromJson;
import org.smaszno.geo.model.GeoDataSaveResult;
import org.smaszno.geo.services.GeoRestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.*;

/**
 * Created by smaszno on 2017-06-05.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {GeoRestServiceImpl.class})
public class GeoRestServiceImplTest {


    @Autowired
    GeoRestServiceImpl geoRestService;

    GeoDataFromJson geoDataFromJsonMock;


    @Test
    public void saveData() throws Exception {
        GeoDataSaveResult result = geoRestService.saveData(geoDataFromJsonMock);
        assertEquals("Data should be successfully saved", result.getStatus(), GeoDataSaveResult.Status.OK);
    }

    @Before
    public void setUp() throws Exception {
        geoDataFromJsonMock = generateGeoDataMock();
    }

    private GeoDataFromJson generateGeoDataMock() {
        GeoDataFromJson geoDataFromJson = new GeoDataFromJson();
        geoDataFromJson.setLongitude("123");
        geoDataFromJson.setLatitude("456");
        geoDataFromJson.setElevation("789");
        return geoDataFromJson;
    }


}