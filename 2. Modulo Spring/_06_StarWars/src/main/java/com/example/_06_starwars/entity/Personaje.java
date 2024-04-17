package com.example._06_starwars.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Personaje {
    private String name;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private String species;
    private int mass;
    private int height;

    public Personaje(){}
    public Personaje(String name, String hairColor, String skinColor, String eyeColor,
                     String birthYear, String gender, String homeworld, String species, int mass, int height) {
        this.name = name;
        this.hair_color = hairColor;
        this.skin_color = skinColor;
        this.eye_color = eyeColor;
        this.birth_year = birthYear;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
        this.mass = mass;
        this.height = height;
    }
}
