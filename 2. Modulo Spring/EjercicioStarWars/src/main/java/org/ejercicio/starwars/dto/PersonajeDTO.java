package org.ejercicio.starwars.dto;

import lombok.Data;

@Data
public class PersonajeDTO {
    private String name;
    private String height;
    private String mass;
    private String gender;
    private String homeworld;
    private String species;

    public PersonajeDTO(String name, String mass, String height,
                        String gender, String species, String homeworld) {
        this.name = name;
        this.mass = mass;
        this.height = height;
        this.gender = gender;
        this.species = species;
        this.homeworld = homeworld;
    }
}
