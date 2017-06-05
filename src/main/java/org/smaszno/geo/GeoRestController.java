package org.smaszno.geo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smaszno.geo.model.GeoData;
import org.smaszno.geo.services.GeoRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by smaszno on 04/06/2017.
 */
@RestController
@RequestMapping("/")
public class GeoRestController {

    private static final Logger logger = LoggerFactory.getLogger(GeoRestController.class);
    GeoRestService geoRestService;

    String example = null;


    @Autowired
    public GeoRestController(GeoRestService geoRestService) {
        this.geoRestService = geoRestService;
    }


    @RequestMapping(value="geo", method = RequestMethod.POST)
    public ResponseEntity<?> storeData(@RequestBody GeoData geoData)
    {
        geoRestService.saveData(geoData);
        return new ResponseEntity<Object>("Stored", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> get()
    {
        try
        {
            if (example == null) {

                ObjectMapper mapper = new ObjectMapper();
                String jsonInString = mapper.writeValueAsString(new GeoData());
                example = "/geo : POST : " + jsonInString;

            }
            return new ResponseEntity<Object>(example, HttpStatus.OK);
        }
        catch(JsonProcessingException e)
        {
            logger.error("Error parsing exemplary JSON");
            return new ResponseEntity<Object>("Go away", HttpStatus.FORBIDDEN);
        }


    }




}
