package com.practicaSpring.starWars.dto;

import java.io.Serializable;

public class CharacterDTO implements Serializable {
    private String nombre;
    private Integer height;
    private Integer mass;
    private String gender;
    private String homeworld;
    private String species;

    public CharacterDTO(String nombre, Integer height, Integer mass, String gender, String homeworld, String species) {
        this.nombre = nombre;
        this.height = height;
        this.mass = mass;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
    }

    public String getNombre() {
        return nombre;
    }

    public int getHeight() {
        return height;
    }

    public int getMass() {
        return mass;
    }

    public String getGender() {
        return gender;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public String getSpecies() {
        return species;
    }
}
