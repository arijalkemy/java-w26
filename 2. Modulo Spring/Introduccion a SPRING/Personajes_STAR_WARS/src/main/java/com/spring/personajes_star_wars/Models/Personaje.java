package com.spring.personajes_star_wars.Models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Personaje {
    private String name;
    private Integer height;
    private Integer mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private String species;

    @JsonCreator
    public Personaje(@JsonProperty("name") String name, @JsonProperty("height") Integer height,
                     @JsonProperty("mass") Integer mass, @JsonProperty("hair_color") String hairColor,
                     @JsonProperty("skin_color") String skinColor, @JsonProperty("eye_color") String eyeColor,
                     @JsonProperty("birth_year") String birthYear, @JsonProperty("gender") String gender,
                     @JsonProperty("homeworld") String homeworld, @JsonProperty("species") String species) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hair_color = hairColor;
        this.skin_color = skinColor;
        this.eye_color = eyeColor;
        this.birth_year = birthYear;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
    }

    public Personaje() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getMass() {
        return mass;
    }

    public void setMass(Integer mass) {
        this.mass = mass;
    }

    public String getHairColor() {
        return hair_color;
    }

    public void setHairColor(String hairColor) {
        this.hair_color = hairColor;
    }

    public String getSkinColor() {
        return skin_color;
    }

    public void setSkinColor(String skinColor) {
        this.skin_color = skinColor;
    }

    public String getEyeColor() {
        return eye_color;
    }

    public void setEyeColor(String eyeColor) {
        this.eye_color = eyeColor;
    }

    public String getBirthYear() {
        return birth_year;
    }

    public void setBirthYear(String birthYear) {
        this.birth_year = birthYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHomeWorld() {
        return homeworld;
    }

    public void setHomeWorld(String homeWorld) {
        this.homeworld = homeWorld;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
