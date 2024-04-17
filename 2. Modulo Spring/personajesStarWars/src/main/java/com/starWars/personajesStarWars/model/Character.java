package com.starWars.personajesStarWars.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Character {
    private String name;
    private Integer height;
    private Integer mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private String homeworld;
    private String species;

    public Character() {
    }

    public Character(String name, Integer height, Integer mass, String hairColor, String skinColor, String eyeColor,
                     String birthYear, String gender, String homeworld, String species) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hairColor = hairColor;
        this.skinColor = skinColor;
        this.eyeColor = eyeColor;
        this.birthYear = birthYear;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
    }
}
