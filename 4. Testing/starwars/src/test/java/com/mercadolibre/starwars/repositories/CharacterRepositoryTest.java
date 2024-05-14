package com.mercadolibre.starwars.repositories;


import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CharacterRepositoryTest {

    @Test
    public void testGetCharacter() {
        // arrange
        CharacterRepositoryImpl characterRepository = new CharacterRepositoryImpl();
        // act
        List<CharacterDTO> characters = characterRepository.findAllByNameContains("Luke Skywalker");
        // assert
        Assertions.assertEquals("Luke Skywalker", characters.get(0).getName());
    }
}
