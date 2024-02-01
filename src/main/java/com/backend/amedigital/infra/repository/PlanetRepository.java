package com.backend.amedigital.infra.repository;

import com.backend.amedigital.core.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Integer> {

    Planet getPlanetById_planet(Integer id);

    Planet getPlanetByNome(String nome);

}
