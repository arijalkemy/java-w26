package org.mercadolibre.multicapatemplate.dto;

import lombok.Getter;
import lombok.Setter;
import org.mercadolibre.multicapatemplate.entity.Character;

import java.io.Serializable;

@Setter
@Getter
public class CharacterResponseDTO implements Serializable {
    String name;
    Double heigth;
    Double mass;
    String gender;
    String homeWorld;
    String species;

    public CharacterResponseDTO(Character character) {
        this.name = character.getName();
        this.heigth = character.getHeight();
        this.mass = character.getMass();
        this.gender = character.getGender();
        this.homeWorld = character.getHomeWorld();
        this.species = character.getSpecies();
    }

}
