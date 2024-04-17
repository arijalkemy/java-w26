package com.spring.starwars.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StarWarsCharacter {

    private String name, hairColor, skinColor, eyeColor, birthYear, gender, homeworld, species;
    private Double height, mass;

    public StarWarsCharacter(String name,
                             String hairColor,
                             String skinColor,
                             String eyeColor,
                             String birthYear,
                             String gender,
                             String homeworld,
                             String species,
                             Double height,
                             Double mass) {
        this.name = name;
        this.hairColor = hairColor;
        this.skinColor = skinColor;
        this.eyeColor = eyeColor;
        this.birthYear = birthYear;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
        this.height = height;
        this.mass = mass;
    }

    public StarWarsCharacter() {} // Created for Jackson to work with json file
}
