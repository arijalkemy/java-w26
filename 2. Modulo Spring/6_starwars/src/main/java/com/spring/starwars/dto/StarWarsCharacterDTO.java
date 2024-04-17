package com.spring.starwars.dto;

import com.spring.starwars.entity.StarWarsCharacter;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class StarWarsCharacterDTO implements Serializable {

    private String name, gender, homeworld, species;
    private Double height, mass;

    public StarWarsCharacterDTO(StarWarsCharacter character) {
        this.name = character.getName();
        this.gender = character.getGender();
        this.homeworld = character.getHomeworld();
        this.species = character.getSpecies();
        this.height = character.getHeight();
        this.mass = character.getMass();
    }
}
