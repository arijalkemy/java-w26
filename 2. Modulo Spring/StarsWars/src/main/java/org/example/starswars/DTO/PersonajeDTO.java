package org.example.starswars.DTO;


import lombok.Data;

@Data
public class PersonajeDTO {
    private String name;
    private double height;
    private double mass;
    private String gender;
    private String homeworld;
    private String species;

    public PersonajeDTO(String name, double height, double mass, String gender, String homeworld, String species) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
    }
}
