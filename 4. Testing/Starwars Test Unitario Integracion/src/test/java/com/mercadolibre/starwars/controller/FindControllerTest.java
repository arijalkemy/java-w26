package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.Util;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {

    @Mock
    private FindService findService;

    @InjectMocks
    private FindController findController;

    @Test
    @DisplayName("Buscar un personaje con su nombre")
    public void find() {
        //Arrange
        CharacterDTO characterDTO = Util.characterTest();

        //Act
        findController.find(characterDTO.getName());

        //Assert
        Mockito.verify(findService, Mockito.atLeastOnce()).find(characterDTO.getName());

    }


}
