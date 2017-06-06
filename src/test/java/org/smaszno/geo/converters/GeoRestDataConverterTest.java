package org.smaszno.geo.converters;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.smaszno.geo.converters.impl.GeoRestDataConverterImpl;
import org.smaszno.geo.dto.GeoDataDTO;
import org.smaszno.geo.model.GeoData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * Created by smaszno on 2017-06-06.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {GeoRestDataConverterImpl.class})
public class GeoRestDataConverterTest {

    GeoDataDTO geoDataDTOMock;


    @Autowired
    GeoRestDataConverter geoRestDataConverter;

    @Test
    public void testConvertFrom() throws Exception {

        GeoData geoData = geoRestDataConverter.convertFrom(geoDataDTOMock);
        Assert.assertEquals("GeoRestDataConverterTest: Longitude differs", geoData.getLongitude(), geoDataDTOMock.getLongitude());
        Assert.assertEquals("GeoRestDataConverterTest: Latitude differs", geoData.getLatitude(), geoDataDTOMock.getLatitude());
        Assert.assertEquals("GeoRestDataConverterTest: Elevation differs", geoData.getElevation(), geoDataDTOMock.getElevation());

    }


    @Before
    public void setUp() throws Exception {
        geoDataDTOMock = new GeoDataDTO();
        geoDataDTOMock.setLongitude( "123");
        geoDataDTOMock.setLatitude("456");
        geoDataDTOMock.setElevation("789");
    }



}
