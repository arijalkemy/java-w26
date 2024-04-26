package com.example.starwars.entity;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import org.springframework.boot.autoconfigure.domain.EntityScan;

public class Personaje implements Serializable {
    private String name;
    private int height;
    private int mass;
    @JsonProperty("hair_color")
    private String hairColor;
    @JsonProperty("skin_color")
    private String skinColor;
    @JsonProperty("eye_color")
    private String eyeColor;
    @JsonProperty("birth_year")
    private String birthYear;
    private String gender;
    private String homeworld;
    private String species;
    public Personaje(){

    }
    public Personaje(String name, int height, int mass, String hairColor, String skinColor, String eyeColor, String birthYear, String gender, String homeworld, String species){
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
    public String getName(){
        return this.name=name;
    }
    public int getHeight(){
        return this.height=height;
    }
    public int getMass(){
        return this.mass=mass;
    }
    public String getGender(){
        return this.gender=gender;
    }
    public String getHomeworld(){
        return this.homeworld=homeworld;
    }
    public String getSpecies(){
        return this.species=species;
    }
}
