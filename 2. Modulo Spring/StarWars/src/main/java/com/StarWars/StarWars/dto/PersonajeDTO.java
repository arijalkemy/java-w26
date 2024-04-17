package com.StarWars.StarWars.dto;

import java.io.Serializable;

public class PersonajeDTO implements Serializable {
    private String name;
    private String gender;
    private String homeworld;
    private String species;

    public PersonajeDTO(String name, String gender, String homeworld, String species) {
        this.name = name;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
    }
}
