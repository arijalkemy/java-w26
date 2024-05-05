package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


public class FindServiceTests {

    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private FindService findService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    private CharacterDTO createCharacter(String name, String hairColor) {
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName(name);
        characterDTO.setHair_color(hairColor);
        return characterDTO;
    }

    @Test
    public void serviceFindOkTest() {
        // Given
        String query = "Skywalker";
        List<CharacterDTO> characters = Arrays.asList(
                createCharacter("Luke Skywalker", "blond"),
                createCharacter("Anakin Skywalker", "brown"),
                createCharacter("Leia Skywalker", "brown")
        );
        when(characterRepository.findAllByNameContains(query)).thenReturn(characters);

        // When
        List<CharacterDTO> result = findService.find(query);

        // Then
        assertEquals(3, result.size());
        assertEquals("Luke Skywalker", result.get(0).getName());
        assertEquals("Anakin Skywalker", result.get(1).getName());
        assertEquals("Leia Skywalker", result.get(2).getName());
    }

    @Test
    public void serviceFindNotFoundTest() {
        // Given
        String query = "Yoda";
        List<CharacterDTO> characters = Arrays.asList(
                createCharacter("Luke Skywalker", "blond"),
                createCharacter("Anakin Skywalker", "brown"),
                createCharacter("Leia Skywalker", "brown")
        );
        when(characterRepository.findAllByNameContains(query)).thenReturn(Collections.emptyList());

        // When
        List<CharacterDTO> result = findService.find(query);

        // Then
        assertTrue(result.isEmpty());
    }
}
