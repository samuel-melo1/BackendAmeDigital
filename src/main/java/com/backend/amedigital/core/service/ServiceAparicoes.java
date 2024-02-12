package com.backend.amedigital.core.service;

import com.backend.amedigital.core.model.Planet;
import com.backend.amedigital.dto.PlanetDTO;
import com.backend.amedigital.exceptions.NotFoundResultAPI;
import com.backend.amedigital.exceptions.PlanetNotFoundException;
import com.backend.amedigital.infra.repository.PlanetRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceAparicoes {

    private static final String url = "https://swapi.dev/api/planets?search=";

    private PlanetRepository planetRepository;

    public ServiceAparicoes(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public Integer buscarAparicoes(String planet) {
        String baseUrl = url + planet;

        try {
            String json = obterJsonDaAPI(baseUrl);
            JsonNode resultsNode = extrairResultsNode(json);

            if (resultsNode.isEmpty()) {
                throw new NotFoundResultAPI();
            }

            JsonNode firstPlanetNode = resultsNode.get(0);
            JsonNode residentsNode = firstPlanetNode.get("films");

            return !residentsNode.isEmpty() ? residentsNode.size() : null;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    private String obterJsonDaAPI(String url) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }

    private JsonNode extrairResultsNode(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(json);
        return jsonNode.get("results");
    }
}
