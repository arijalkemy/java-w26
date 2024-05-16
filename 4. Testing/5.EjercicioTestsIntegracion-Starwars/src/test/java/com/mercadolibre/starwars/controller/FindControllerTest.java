package com.mercadolibre.starwars.controller;


import com.mercadolibre.starwars.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindControllerTest {

    @Mock
    FindService findService;

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindController findController;

    private CharacterDTO characterDTO;

    List<CharacterDTO> characters;

    @BeforeEach
    void setUp() {
        characterDTO = new CharacterDTO();
        characterDTO.setName("Leia Organa");
        characterDTO.setHeight(150);
        characterDTO.setMass(49);
        characterDTO.setHair_color("brown");
        characterDTO.setSkin_color("light");
        characterDTO.setEye_color("brown");
        characterDTO.setBirth_year("19BBY");
        characterDTO.setGender("female");
        characterDTO.setHomeworld("Alderaan");
        characterDTO.setSpecies("Human");

        characters = List.of(characterDTO);
    }

    @Test
    @DisplayName("Deberia devolver una lista de characterDto con únicamente el personaje de Leia")
    void findTest() {
        when(findService.find(characterDTO.getName())).thenReturn(characters);
        List<CharacterDTO> result = findController.find(characterDTO.getName());

        verify(findService, atLeastOnce()).find(characterDTO.getName());
        Assertions.assertEquals(characters.get(0).getName(), result.get(0).getName());
    }

    @Test
    @DisplayName("Deberia devolver una lista de caracteres vacia")
    void findWithEmptyResultTest() {
        //arrange
        String characterName = "Leiaa";
        when(findService.find(characterName)).thenReturn(List.of());
        //act
        List<CharacterDTO> result = findController.find(characterName);
        //assert
        verify(findService, atLeastOnce()).find(characterName);
        Assertions.assertEquals(0, result.size());
    }
}