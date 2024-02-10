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
    private ServiceAparicoes serviceAparicoes;

    public PlanetService(PlanetRepository planetRepository, ServiceAparicoes serviceAparicoes) {
        this.planetRepository = planetRepository;
        this.serviceAparicoes = serviceAparicoes;
    }

    @Transactional
    public Planet save(Planet planet) throws Exception {
        Optional<Planet> planetResponse = planetRepository.findById(planet.getId_planet());
        if (planetResponse.isPresent()) {
            throw new Exception("Planet is exist");
        }
       Integer aparicoes =  serviceAparicoes.buscarAparicoes(planet.getNome());
        Planet newPlanet = new Planet(planet.getNome(), planet.getClima(), planet.getTerreno(), aparicoes);
        return planetRepository.save(newPlanet);
    }

    public List<Planet> list() {
        return planetRepository.findAll();
    }

    public Planet listByNome(String nome) {
        return planetRepository.findPlanetByNome(nome);
    }

    public Optional<Planet> listByID(Integer id_planet) {

       Optional<Planet> planet =  planetRepository.findById(id_planet);
        return planet;
    }

    @Transactional
    public boolean removeById(Integer id_planet) {
        Optional<Planet> planetResponse = planetRepository.findById(id_planet);
        if(planetResponse.isEmpty()){
            planetRepository.deleteById(id_planet);
            return true;
        }
        return false;
    }
}
