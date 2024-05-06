package com.mercadolibre.starwars.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UtilTesting {

    public static List<CharacterDTO> getCharacters(){
        CharacterDTO lukeSkywalker = new CharacterDTO(
                "Luke Skywalker",
                "blond",
                "fair",
                "blue",
                "19BBY",
                "male",
                "Tatooine",
                "Human",
                172,
                77
        );
        CharacterDTO lukeSkywalker2 = new CharacterDTO(
                "Luke Skywalker 2",
                "blond",
                "fair",
                "blue",
                "19BBY",
                "male",
                "Tatooine",
                "Human",
                172,
                77
        );
        CharacterDTO c3po = new CharacterDTO(
                "C-3PO",
                "NA",
                "gold",
                "yellow",
                "112BBY",
                "NA",
                "Tatooine",
                "Droid",
                167,
                75
        );
        CharacterDTO r2d2 = new CharacterDTO(
                "R2-D2",
                "NA",
                "white, blue",
                "red",
                "33BBY",
                "NA",
                "Naboo",
                "Droid",
                96,
                32
        );

        // update the starwars.json with these characters

        List<CharacterDTO> characters = new ArrayList<>();
        characters.add(lukeSkywalker);
        characters.add(c3po);
        characters.add(r2d2);
        characters.add(lukeSkywalker2);

        return characters;
    }

    public static void writeCharacters(List<CharacterDTO> characterDTOS){
        File file = new File("./src/test/resources/starwars_characters.json");

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(file, characterDTOS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
