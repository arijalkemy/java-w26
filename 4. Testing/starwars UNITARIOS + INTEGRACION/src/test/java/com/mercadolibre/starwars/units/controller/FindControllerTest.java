package com.mercadolibre.starwars.units.controller;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {

    @Mock
    FindService findService;

    @InjectMocks
    private FindController findController;

    @Test
    @DisplayName("busca personajes existentes y devuelve lista no vacía")
    public void findCharacterExistingTest() {
        //Arrange
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Luke Skywalker");
        characterDTO.setHair_color("blond");
        characterDTO.setSkin_color("fair");
        characterDTO.setEye_color("blue");
        characterDTO.setBirth_year("19BBY");
        characterDTO.setGender("male");
        characterDTO.setHair_color("Tatooine");
        characterDTO.setSpecies("Human");
        characterDTO.setHeight(172);
        characterDTO.setMass(77);

        List<CharacterDTO> expected = List.of(characterDTO);

        String queryName = "Luke";

        //Act
        when(findService.find(queryName)).thenReturn(expected);
        List<CharacterDTO> output = findController.find(queryName);

        //Assert
        Assertions.assertEquals(expected, output);
    }

    @Test
    @DisplayName("busca personajes no existentes y devuelve lista vacía")
    public void findCharacterNotExistingTest() {
        //Arrange

        List<CharacterDTO> expected = List.of();

        String queryName = "Canelita";

        //Act
        when(findService.find(queryName)).thenReturn(expected);
        List<CharacterDTO> output = findController.find(queryName);

        //Assert
        Assertions.assertEquals(expected, output);
    }
}
