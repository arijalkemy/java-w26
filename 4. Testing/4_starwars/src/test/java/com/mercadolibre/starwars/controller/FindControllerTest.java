package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FindControllerTest {

    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @Test
    void findLuke() {
        // arrange
        String query = "Luke";
        List<CharacterDTO> characters = List.of(
                new CharacterDTO(
                        "Luke Skywalker",
                        "blond",
                        "fair",
                        "blue",
                        "19BBY",
                        "male",
                        "Tatooine",
                        "Human",
                        77,
                        172
                )
        );

        Mockito.when(findService.find(query)).thenReturn(characters);

        // act
        List<CharacterDTO> result = findController.find(query);

        // assert
        Mockito.verify(findService, Mockito.atLeastOnce()).find(query);

        Assertions.assertEquals(characters.size(), this.findController.find(query).size());
        Assertions.assertEquals(
                characters.get(0).getHomeworld(), this.findController.find(query).get(0).getHomeworld()
        );

    }
}