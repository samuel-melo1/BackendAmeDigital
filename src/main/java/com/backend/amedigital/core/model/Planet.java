package com.backend.amedigital.core.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id_planet;

    private String nome;
    private String clima;
    private String terreno;
    @JsonIgnore
    private Integer aparicoes;

    public Planet(String nome, String clima, String terreno, Integer aparicoes){
        this.nome = nome;
        this.clima = clima;
        this.terreno = terreno;
        this.aparicoes = aparicoes;
    }
}
