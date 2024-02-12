package com.backend.amedigital;

import com.backend.amedigital.core.model.Planet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AmeDigitalBackendApplication {

    public static void main(String[] args)  {
        SpringApplication.run(AmeDigitalBackendApplication.class, args);
    }
}
