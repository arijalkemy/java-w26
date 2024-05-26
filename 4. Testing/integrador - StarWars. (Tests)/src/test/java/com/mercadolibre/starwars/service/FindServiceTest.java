package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    @DisplayName("Debería encontrar una coincidencia")
    public void findServiceOneTest(){
        // Act
        List<CharacterDTO> expected = new ArrayList<>(){{
            add(new CharacterDTO(
                    "Luke Skywalker",
                    "blond",
                    "fair",
                    "blue",
                    "19BBY",
                    "male",
                    "Tatooine",
                    "Human",
                    172,
                    77));
        }};

        String input = "Luke";

        // Act
        when(characterRepository.findAllByNameContains(input)).thenReturn(expected);

        // Assert
        List<CharacterDTO> result = findService.find(input);
        String expectedString = expected.stream().map(CharacterDTO::toString).collect(Collectors.joining(";"));
        String expectedResult = result.stream().map(CharacterDTO::toString).collect(Collectors.joining(";"));

        assertEquals(expectedString, expectedResult);
    }

    @Test
    @DisplayName("Debería encontrar coincidencias")
    public void findServiceVariousTest(){
        // Arrange
        List<CharacterDTO> expected = new ArrayList<>(){{
            add(new CharacterDTO(
                    "Darth Vader",
                    "none",
                    "white",
                    "yellow",
                    "41.9BBY",
                    "male",
                    "Tatooine",
                    "Human",
                    202,
                    136));

            add(new CharacterDTO(
                    "Darth Maul",
                    "none",
                    "red",
                    "yellow",
                    "54BBY",
                    "male",
                    "Dathomir",
                    "Zabrak",
                    175,
                    80));
        }};
        String input = "Darth";

        // Act
        when(characterRepository.findAllByNameContains(input)).thenReturn(expected);

        // Assert
        List<CharacterDTO> result = findService.find(input);
        String expectedString = expected.stream().map(CharacterDTO::toString).collect(Collectors.joining(";"));
        String expectedResult = result.stream().map(CharacterDTO::toString).collect(Collectors.joining(";"));

        assertEquals(expectedString, expectedResult);
    }



}