package org.example.starwars.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PersonajeDTO implements Serializable {
    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeworld;
    private String species;

    public PersonajeDTO(String name, int height, int mass, String gender, String homeworld, String species) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
    }

    @Override
    public String toString() {
        return "Personaje " +
                "name='" + name + '\'' +
                ", height=" + height +
                ", mass=" + mass +
                ", gender='" + gender + '\'' +
                ", homeworld='" + homeworld + '\'' +
                ", species='" + species;
    }
}
