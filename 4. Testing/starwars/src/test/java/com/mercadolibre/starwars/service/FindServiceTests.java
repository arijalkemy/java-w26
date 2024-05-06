package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.util.GenerateCharacter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindServiceTests {
    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    void testFindByLukeName() {
        when(characterRepository.findAllByNameContains("Luke")).thenReturn(List.of(GenerateCharacter.generateLuke()));
        CharacterDTO lukeSkywalker = GenerateCharacter.generateLuke();

        List<CharacterDTO> characterLuke = findService.find("Luke");

        assertEquals(1, characterLuke.size());
        assertEquals(lukeSkywalker, characterLuke.get(0));
    }

    @Test
    void testFindByEmptyName() {
        when(characterRepository.findAllByNameContains("")).thenReturn(GenerateCharacter.generateAllCharacters());
        int size = 3;

        List<CharacterDTO> fullList = findService.find("");

        assertEquals(size, fullList.size());
    }

    @Test
    void testFindByNonExistentName() {
        when(characterRepository.findAllByNameContains("asd")).thenReturn(new ArrayList<>());
        int size = 0;

        List<CharacterDTO> emptyList = findService.find("asd");

        assertEquals(size, emptyList.size());
    }

    @Test
    void testFindByDarthName() {
        when(characterRepository.findAllByNameContains("Darth")).thenReturn(List.of(GenerateCharacter.generateDathVader(), GenerateCharacter.generateDathMaul()));
        List<CharacterDTO> characters = new ArrayList<>(){
            {
                add(GenerateCharacter.generateDathVader());
                add(GenerateCharacter.generateDathMaul());
            }
        };

        List<CharacterDTO> darthCharacters = findService.find("Darth");

        assertEquals(2, darthCharacters.size());
        assertEquals(characters, darthCharacters);
    }
}
