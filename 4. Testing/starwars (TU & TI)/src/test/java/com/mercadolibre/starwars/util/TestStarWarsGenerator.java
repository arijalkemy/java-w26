package com.mercadolibre.starwars.util;

import com.mercadolibre.starwars.dto.CharacterDTO;

import java.util.List;

public class TestStarWarsGenerator {

    public static List<CharacterDTO> characterLuke() {
        CharacterDTO characterLuke = new CharacterDTO();
        characterLuke.setName("Luke Skywalker");
        characterLuke.setGender("male");
        characterLuke.setHair_color("blond");
        characterLuke.setSkin_color("fair");
        characterLuke.setEye_color("blue");
        characterLuke.setBirth_year("19BBY");
        characterLuke.setHomeworld("Tatooine");
        characterLuke.setSpecies("Human");
        characterLuke.setHeight(172);
        characterLuke.setMass(77);

        return List.of(characterLuke);

    }
}
