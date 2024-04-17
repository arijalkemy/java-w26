package com.starwars.personajes.entity;

import lombok.Data;

@Data
public class Character {
    private String name;
    private int height;
    private int mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private String species;

    public Character() {
    }

    public Character(String name, int height, int mass, String hair_Color, String skin_color, String eyeColor, String birth_year, String gender, String homeworld, String species) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hair_color = hair_Color;
        this.skin_color = skin_color;
        this.eye_color = eyeColor;
        this.birth_year = birth_year;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
    }
}