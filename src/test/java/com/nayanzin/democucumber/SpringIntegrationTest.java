package com.nayanzin.democucumber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpMethod.GET;

//@SpringBootTest(classes = DemoCucumberApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//@ContextConfiguration
public class SpringIntegrationTest {


    protected final String VERSION = "http://localhost:8585/version";

    protected static ResponseResults latestResponse = null;

    //@Autowired
    protected RestTemplate restTemplate = new RestTemplate();

    void executeGet(String url) {
        final Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        final HeaderSettingRequestCallback requestCallback = new HeaderSettingRequestCallback(headers);

        final ResponseResultErrorHandler errorHandler = new ResponseResultErrorHandler();

        restTemplate.setErrorHandler(errorHandler);
        latestResponse = restTemplate.execute(url, GET, requestCallback, response -> {
            if (errorHandler.getHadError()) {
                return (errorHandler.getResults());
            } else {
                return new ResponseResults(response);
            }
        });
    }
}
