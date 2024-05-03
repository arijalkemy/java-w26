package org.tests.starwars.utils;


import org.tests.starwars.dto.CharacterDTO;

import java.util.ArrayList;
import java.util.List;

public class TestGeneratorCharacters {

    public static List<CharacterDTO> getCharactersWithDarth() {
        List<CharacterDTO> characters = new ArrayList<>();
        characters.add(CharacterDTO.builder()
                .name("Darth Vader")
                .hair_color("none")
                .skin_color("white")
                .eye_color("yellow")
                .birth_year("41.9BBY")
                .gender("male")
                .homeworld("Tatooine")
                .species("Human")
                .height(202)
                .mass(136)
                .build()
        );
        characters.add(CharacterDTO.builder()
                .name("Darth Maul")
                .hair_color("none")
                .skin_color("red")
                .eye_color("yellow")
                .birth_year("54BBY")
                .gender("male")
                .homeworld("Dathomir")
                .species("Zabrak")
                .height(175)
                .mass(80)
                .build()
        );
        return characters;
    }

}
