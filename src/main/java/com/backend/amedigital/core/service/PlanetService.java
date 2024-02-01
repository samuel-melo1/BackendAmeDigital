package com.backend.amedigital.core.service;

import com.backend.amedigital.core.model.Planet;
import com.backend.amedigital.infra.repository.PlanetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PlanetService {

    private PlanetRepository planetRepository;

    public PlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    @Transactional
    public Planet save(Planet planet) throws Exception {
        Planet planetResponse = planetRepository.getPlanetById_planet(planet.getId_planet());
        if (planetResponse != null) {
            throw new Exception("Planet is exist");
        }
        Planet newPlanet = new Planet(planet.getNome(), planet.getClima(), planet.getTerreno());
        return planetRepository.save(newPlanet);
    }

    public List<Planet> list() {
        return planetRepository.findAll();
    }

    public Planet listByNome(String nome) {
        return planetRepository.getPlanetByNome(nome);
    }

    public Planet listByID(Integer id_planet) {
        return planetRepository.getPlanetById_planet(id_planet);
    }

    @Transactional
    public boolean removeById(Integer id_planet) {
        Planet planetResponse = planetRepository.getPlanetById_planet(id_planet);
        if(planetResponse != null){
            planetRepository.deleteById(id_planet);
            return true;
        }
        return false;
    }
}
