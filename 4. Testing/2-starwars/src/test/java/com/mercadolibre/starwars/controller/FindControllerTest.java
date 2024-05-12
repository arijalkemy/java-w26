package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
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
    private FindService findService;

    @InjectMocks
    private FindController findController;

    @Test
    public void find() {
        // Arrange
        List<CharacterDTO> list = List.of(

                new CharacterDTO(
                        "Biggs Darklighter",
                        "black",
                        "light",
                        "brown",
                        "24BBY",
                        "male",
                        "Tatooine",
                        "Human",
                        183,
                        84
                )
        );

        // Act
        when(findService.find("Dark")).thenReturn(list);
        List<CharacterDTO> result = findController.find("Dark");

        // Assert
        Assertions.assertEquals(list, result);
    }
}
