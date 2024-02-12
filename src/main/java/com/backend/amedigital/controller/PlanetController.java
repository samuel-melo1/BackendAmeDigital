package com.backend.amedigital.controller;

import com.backend.amedigital.core.model.Planet;
import com.backend.amedigital.core.service.PlanetService;
import com.backend.amedigital.dto.PlanetDTO;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planet")
public class PlanetController {

    private PlanetService planetService;

    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @PostMapping("/savePlanet")
    public ResponseEntity<Planet> create(@RequestBody @Valid PlanetDTO planetDTO) throws Exception {
        Planet planet = new Planet();
        BeanUtils.copyProperties(planetDTO, planet);
        planetService.save(planet);
        return new ResponseEntity(planetDTO, HttpStatus.CREATED);
    }

    @GetMapping("/listPlanets")
    public ResponseEntity<List<Planet>> listAllPlanets() {
        return new ResponseEntity(planetService.list(), HttpStatus.OK);
    }

    @GetMapping("/listByNome/{nome}")
    public ResponseEntity<String> listPlanetByNome(@Valid @PathVariable String nome) {
        return new ResponseEntity(planetService.listByNome(nome), HttpStatus.OK);
    }

    @GetMapping("/listByID/{id_planet}")
    public ResponseEntity<Planet> listPlanetByID(@Valid @PathVariable Integer id_planet) {
        return new ResponseEntity(planetService.listByID(id_planet), HttpStatus.OK);
    }

    @DeleteMapping("/deletePlanet/{id_planet}")
    public ResponseEntity<Void> delete(@PathVariable int id_planet) {
        boolean deletePlanet = planetService.removeById(id_planet);
        return new ResponseEntity(deletePlanet, HttpStatus.OK);

    }
}
