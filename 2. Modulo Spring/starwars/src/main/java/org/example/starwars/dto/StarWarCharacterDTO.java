package org.example.starwars.dto;

import lombok.Getter;
import org.example.starwars.model.StarWarCharacter;

@Getter
public class StarWarCharacterDTO {
    private String name;
    private int height;
    private int mass;
    private String species;

    public StarWarCharacterDTO(StarWarCharacter character) {
        this.name = character.getName();
        this.height = character.getHeight();
        this.mass = character.getMass();
        this.species = character.getSpecies();
    }
}
