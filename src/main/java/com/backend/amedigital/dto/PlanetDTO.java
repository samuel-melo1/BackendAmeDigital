package com.backend.amedigital.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public record PlanetDTO(Integer id_planet, String nome, String clima, String terreno, @JsonIgnore Integer aparicoes) {
}
