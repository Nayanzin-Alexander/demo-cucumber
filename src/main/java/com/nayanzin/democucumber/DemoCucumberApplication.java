package com.nayanzin.democucumber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.management.RuntimeErrorException;

@SpringBootApplication
@RestController
public class DemoCucumberApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoCucumberApplication.class, args);
    }

    @GetMapping("/version")
    public String getVersion() {
        throw new RuntimeException("3424");
        //return "1.0";
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
