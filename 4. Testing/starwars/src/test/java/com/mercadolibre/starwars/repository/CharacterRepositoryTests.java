package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.util.GenerateCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestComponent;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestComponent
public class CharacterRepositoryTests {
    CharacterRepository characterRepository;

    @BeforeEach
    void setUp() {
        characterRepository = new CharacterRepositoryImpl();
    }

    @Test
    void testFindAllByNameContains() {
        CharacterDTO lukeSkywalker = GenerateCharacter.generateLuke();

        List<CharacterDTO> characterLuke = characterRepository.findAllByNameContains("Luke");

        assertEquals(1, characterLuke.size());
        assertEquals(lukeSkywalker, characterLuke.get(0));
    }

    @Test
    void testFindAllByNameContainsByEmptyName() {
        int size = 87;

        List<CharacterDTO> fullList = characterRepository.findAllByNameContains("");

        assertEquals(size, fullList.size());
    }

    @Test
    void testFindAllByNameContainsByNonExistentName() {
        int size = 0;

        List<CharacterDTO> emptyList = characterRepository.findAllByNameContains("asd");

        assertEquals(size, emptyList.size());
    }

    @Test
    void testFindAllByNameContainsByDarthName() {
        List<CharacterDTO> characters = new ArrayList<>(){
            {
                add(GenerateCharacter.generateDathVader());
                add(GenerateCharacter.generateDathMaul());
            }
        };

        List<CharacterDTO> darthCharacters = characterRepository.findAllByNameContains("Darth");

        assertEquals(2, darthCharacters.size());
        assertEquals(characters, darthCharacters);
    }

}
