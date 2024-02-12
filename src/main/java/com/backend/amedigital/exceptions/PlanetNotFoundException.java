package com.backend.amedigital.exceptions;

public class PlanetNotFoundException extends  RuntimeException{

    public PlanetNotFoundException(){
        super("Planet is not exist");
    }
}
