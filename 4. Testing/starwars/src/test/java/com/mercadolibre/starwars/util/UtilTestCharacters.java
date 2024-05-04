package com.mercadolibre.starwars.util;

import com.mercadolibre.starwars.dto.CharacterDTO;

import java.util.List;
import java.util.stream.Collectors;

public  class UtilTestCharacters {
    private static final List<CharacterDTO> characters = List.of();

    private static CharacterDTO generateCharacter(String name){
        CharacterDTO character = new CharacterDTO();
        character.setName(name);
        return character;
    }

    public static List<CharacterDTO> generateListOfCharacters(List<String> names){
        return names.stream().map(UtilTestCharacters::generateCharacter).collect(Collectors.toList());
    }

    public static List<CharacterDTO> generateListOfCharacters(String name){
        return List.of(generateCharacter(name));
    }

    public static List<CharacterDTO> filterCharacters(List<CharacterDTO> characters, String search){
        return characters.stream()
                .filter(c -> c.getName().toUpperCase().contains(search.toUpperCase())).collect(Collectors.toList());
    }
}
