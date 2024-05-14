package com.mercadolibre.starwars.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CharacterRepositoryImplTest {
    CharacterRepositoryImpl characterRepository;
    ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        characterRepository = new CharacterRepositoryImpl();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void findAllByNameContainsTest() throws JsonProcessingException {
        // Arrange
        String query = "luke";

        CharacterDTO character = new CharacterDTO();
        character.setName("Luke Skywalker");
        character.setHeight(172);
        character.setMass(77);
        character.setHair_color("blond");
        character.setSkin_color("fair");
        character.setEye_color("blue");
        character.setBirth_year("19BBY");
        character.setGender("male");
        character.setHomeworld("Tatooine");
        character.setSpecies("Human");

        List<CharacterDTO> listExpected = List.of(character);
        String responseExpected = objectMapper.writeValueAsString(listExpected);

        // Act
        List<CharacterDTO> characters = characterRepository.findAllByNameContains(query);
        String response = objectMapper.writeValueAsString(characters);

        // Assert
        Assertions.assertEquals(responseExpected, response);
    }
}
