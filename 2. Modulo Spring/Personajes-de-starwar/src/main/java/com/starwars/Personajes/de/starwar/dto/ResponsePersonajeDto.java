package com.starwars.Personajes.de.starwar.dto;

public class ResponsePersonajeDto {
    private String name;
    private Integer heigth;
    private Integer mass;
    private String gender;
    private String homeworld;
    private String species;

    public ResponsePersonajeDto(String name, Integer heigth, Integer mass, String gender, String homeworld, String species) {
        this.name = name;
        this.heigth = heigth;
        this.mass = mass;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
    }

    public ResponsePersonajeDto() {
    }

    public String getName() {
        return name;
    }

    public Integer getHeigth() {
        return heigth;
    }

    public Integer getMass() {
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

    @Override
    public String toString() {
        return "ResponsePersonajeDto{" +
                "name='" + name + '\'' +
                ", heigth=" + heigth +
                ", mass=" + mass +
                ", gender='" + gender + '\'' +
                ", homeworld='" + homeworld + '\'' +
                ", species='" + species + '\'' +
                '}';
    }
}
