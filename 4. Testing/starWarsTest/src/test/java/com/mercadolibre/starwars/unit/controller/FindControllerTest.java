package com.mercadolibre.starwars.unit.controller;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindControllerTest {
    String query;

    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @BeforeEach
    void init(){
        query = "Luke";
    }


    @Test
    void findValidQueryTest() {

        List<CharacterDTO> expected = List.of(new CharacterDTO( "Luke Skywalker", "blond", "fair", "blue",
                "19BBY", "male", "Tatooine", "Human",172,77 ));

        when( findService.find( query )).thenReturn(expected);

        List<CharacterDTO> actual = findController.find(query);

        assertEquals(expected, actual);
    }

    @Test
    void findInvalidQueryTest() {

        List<CharacterDTO> expected = new ArrayList<>();

        when( findService.find( query )).thenReturn(expected);

        List<CharacterDTO> actual = findController.find(query);

        assertEquals(expected, actual);
    }
}