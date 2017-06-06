package org.smaszno.geo;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;

/**
 * Created by smaszno on 2017-06-06.
 */
public class GeoRestAppTestClient implements CommandLineRunner {


    private static final URI REST_SERVICE_URI = URI.create("http://localhost:8080/geo");

    public static void main(String[] args) throws IOException, JSONException {
        new SpringApplicationBuilder(GeoRestAppTestClient.class).web(false).run(args);
    }

    @Override
    public void run(String... strings) throws Exception {
        storeGeoData("AAA1", "BBB2", "CCC3");
        storeGeoData("ZZZ", "XXX", "YYY");
    }

    private void storeGeoData(String longitude, String latitude, String elevation) throws IOException, JSONException {
        JSONObject jsonObject = prepareJSON(longitude, latitude, elevation);
        String returnedBody = sendJSON(jsonObject);
        JSONObject returnedJSONObject = parseStringToJSON(returnedBody);
        Assert.assertTrue("Returned id should not be null", returnedJSONObject.get("id") != null);
        Assert.assertEquals("Returned status should be OK", "OK", returnedJSONObject.get("status"));
    }


    private JSONObject prepareJSON(String longitude, String latitude, String elevation) throws JSONException
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("longitude", longitude);
        jsonObject.put("latitude", latitude);
        jsonObject.put("elevation", elevation);
        return jsonObject;

    }


    private String sendJSON(JSONObject jsonObject)
    {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RequestEntity<JSONObject> requestEntity = new RequestEntity(jsonObject.toString(), headers, HttpMethod.POST, REST_SERVICE_URI);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(REST_SERVICE_URI, requestEntity, String.class);
        return responseEntity.getBody();


    }

    private JSONObject parseStringToJSON(String returnedBody) throws JSONException{
        return new JSONObject(returnedBody);
    }





}

