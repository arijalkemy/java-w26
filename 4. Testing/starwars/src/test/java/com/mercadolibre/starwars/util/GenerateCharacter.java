package com.mercadolibre.starwars.util;

import com.mercadolibre.starwars.dto.CharacterDTO;

import java.util.List;

public class GenerateCharacter {

    public static CharacterDTO generateLuke(){
        return new CharacterDTO("Luke Skywalker",
                "blond",
                "fair",
                "blue",
                "19BBY",
                "male",
                "Tatooine",
                "Human",
                172,
                77);
    }

    public static CharacterDTO generateDathVader(){
        return new CharacterDTO("Darth Vader",
                "none",
                "white",
                "yellow",
                "41.9BBY",
                "male",
                "Tatooine",
                "Human",
                202,
                136);
    }

    public static CharacterDTO generateDathMaul(){
        return new CharacterDTO("Darth Maul",
                "none",
                "red",
                "yellow",
                "54BBY",
                "male",
                "Dathomir",
                "Zabrak",
                175,
                80);
    }

    public static List<CharacterDTO> generateAllCharacters() {
        return List.of(generateLuke(), generateDathVader(), generateDathMaul());
    }
}
