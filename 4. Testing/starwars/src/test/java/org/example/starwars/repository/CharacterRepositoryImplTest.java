package org.example.starwars.repository;


import org.example.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterRepositoryImplTest {

    static List<CharacterDTO> characters;

    CharacterRepositoryImpl characterRepository = new CharacterRepositoryImpl();

    @BeforeAll
    static void setUp()
    {
        CharacterDTO characterOne = new CharacterDTO.Builder()
                .name("Edwin Lopez")
                .build();
        CharacterDTO characterTwo = new CharacterDTO.Builder()
                .name("Alexis Chavez")
                .build();
        characters = List.of(characterOne, characterTwo);
    }

    /**
     * Test para verificar que se obtenga una lista vacia
     * cuando se realiza una busqueda por un nombre que no existe.
     */

    @Test
    void getCharactersByNameTest() {
        // arrange

        String name = "Mario";
        List<CharacterDTO> expectedResults = List.of();

        // act

        List<CharacterDTO> results = characterRepository.getCharactersByName(name);

        // assert

        assertEquals(expectedResults, results);
    }

    /**
     * TEst para verificar que se obtengan items cuando se realiza una busqueda por un nombre que existe.
     */

    @Test
    void getCharactersByNameTest2() {
        // arrange

        String name = "Luke";

        // act

        List<CharacterDTO> results = characterRepository.getCharactersByName(name);

        // assert

        assertEquals(1, results.toArray().length);
    }
}
