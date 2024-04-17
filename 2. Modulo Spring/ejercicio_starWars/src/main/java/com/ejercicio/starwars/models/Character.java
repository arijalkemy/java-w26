package com.ejercicio.starwars.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
public class Character {
    private String name;
    private int height;
    private int mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private int birthYear;
    private String gender;
    private String homeWorld;
    private List<String> species;

    public Character(
            String name,
            int height,
            int mass,
            String hairColor,
            String skinColor,
            String eyeColor,
            int birthYear,
            String gender,
            String homeWorld,
            List<String> species) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hairColor = hairColor;
        this.skinColor = skinColor;
        this.eyeColor = eyeColor;
        this.birthYear = birthYear;
        this.gender = gender;
        this.homeWorld = homeWorld;
        this.species = species;
    }
}
