package com.backend.amedigital.controller;

import com.backend.amedigital.core.model.Planet;
import com.backend.amedigital.core.service.PlanetService;
import com.backend.amedigital.dto.PlanetDTO;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
