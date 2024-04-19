package com.example.starwars.dto;

import com.example.starwars.model.Personaje;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class PersonajeDto implements Serializable {

    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeworld;
    private String species;

    public PersonajeDto( Personaje personaje ){
        this.name = personaje.getName();
        this.height = personaje.getHeight();
        this.mass = personaje.getMass();
        this.gender = personaje.getGender();
        this.homeworld = personaje.getHomeworld();
        this.species = personaje.getSpecies();
    }
}
