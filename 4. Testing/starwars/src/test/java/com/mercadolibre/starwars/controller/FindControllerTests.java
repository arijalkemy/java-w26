package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
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
public class FindControllerTests {
    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @Test
    void testFindByLukeName() {
        when(findService.find("Luke")).thenReturn(List.of(GenerateCharacter.generateLuke()));
        CharacterDTO lukeSkywalker = GenerateCharacter.generateLuke();

        List<CharacterDTO> characterLuke = findController.find("Luke");

        assertEquals(1, characterLuke.size());
        assertEquals(lukeSkywalker, characterLuke.get(0));
    }

    @Test
    void testFindByEmptyName() {
        when(findService.find("")).thenReturn(GenerateCharacter.generateAllCharacters());
        int size = 3;

        List<CharacterDTO> fullList = findController.find("");

        assertEquals(size, fullList.size());
    }

    @Test
    void testFindByNonExistentName() {
        when(findService.find("asd")).thenReturn(new ArrayList<>());
        int size = 0;

        List<CharacterDTO> emptyList = findController.find("asd");

        assertEquals(size, emptyList.size());
    }

    @Test
    void testFindByDarthName() {
        when(findService.find("Darth")).thenReturn(List.of(GenerateCharacter.generateDathVader(), GenerateCharacter.generateDathMaul()));
        List<CharacterDTO> characters = new ArrayList<>(){
            {
                add(GenerateCharacter.generateDathVader());
                add(GenerateCharacter.generateDathMaul());
            }
        };

        List<CharacterDTO> darthCharacters = findController.find("Darth");

        assertEquals(2, darthCharacters.size());
        assertEquals(characters, darthCharacters);
    }
}
