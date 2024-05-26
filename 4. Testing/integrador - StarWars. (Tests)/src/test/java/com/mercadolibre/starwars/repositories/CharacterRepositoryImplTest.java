package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;


public class CharacterRepositoryImplTest {

    CharacterRepositoryImpl repositoryTest;

    @BeforeEach
    public void setup(){
        this.repositoryTest = new CharacterRepositoryImpl();
    }

    @Test
    @DisplayName("Debería mostrar una coincidencia")
    public void findAllByNameContainsOne(){
        // Arrange
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
        List<CharacterDTO> result = repositoryTest.findAllByNameContains(input);
        String expectedString = expected.stream().map(CharacterDTO::toString).collect(Collectors.joining(";"));
        String expectedResult = result.stream().map(CharacterDTO::toString).collect(Collectors.joining(";"));

        // Assert
        assertEquals(expectedString, expectedResult);
    }

    @Test
    @DisplayName("Debería mostrar varias coincidencias")
    public void findAllByNameContainsVarious(){
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
        List<CharacterDTO> result = repositoryTest.findAllByNameContains(input);
        String expectedString = expected.stream().map(CharacterDTO::toString).collect(Collectors.joining(";"));
        String expectedResult = result.stream().map(CharacterDTO::toString).collect(Collectors.joining(";"));

        // Assert
        assertEquals(expectedString, expectedResult);
    }








}