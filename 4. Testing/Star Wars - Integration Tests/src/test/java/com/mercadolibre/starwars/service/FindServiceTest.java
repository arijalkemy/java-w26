package com.mercadolibre.starwars.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {
    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private FindService findService;

    ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void findTest() throws JsonProcessingException {
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
        when(characterRepository.findAllByNameContains(query)).thenReturn(listExpected);

        // Assert
        List<CharacterDTO> response = findService.find(query);
        String responseObtained = objectMapper.writeValueAsString(response);

        verify(characterRepository).findAllByNameContains(query);
        Assertions.assertEquals(responseExpected, responseObtained);
    }

}
