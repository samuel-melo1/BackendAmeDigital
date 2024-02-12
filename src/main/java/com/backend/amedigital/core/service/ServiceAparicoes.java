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

    final String url = "https://swapi.dev/api/planets?search=";

    private PlanetRepository planetRepository;

    public ServiceAparicoes(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public Integer buscarAparicoes(String planet) {
        String baseUrl = url + planet;
        try {
            RestTemplate restTemplate = new RestTemplate();
            String json = restTemplate.getForObject(baseUrl, String.class);

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(json);
            JsonNode resultsNode = jsonNode.get("results");

            if (resultsNode.isEmpty()) {
                throw new NotFoundResultAPI();
            }
            JsonNode firstPlanetNode = resultsNode.get(0);
            JsonNode residentsNode = firstPlanetNode.get("films");
            if (!residentsNode.isEmpty()) {
                return residentsNode.size();
            }
            return null;
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
