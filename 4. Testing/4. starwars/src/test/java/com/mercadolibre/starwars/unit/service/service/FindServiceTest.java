package com.mercadolibre.starwars.unit.service.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindServiceTest {

    private List<CharacterDTO> characters;

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;


    @BeforeEach
    void setUp() {
        characters = List.of(new CharacterDTO( "Luke Skywalker", "blond", "fair", "blue",
                "19BBY", "male", "Tatooine", "Human",172,77 ));

        when(characterRepository.findAllByNameContains("Luke")).thenReturn(characters);
    }

    @Test
    void find() {
        List<CharacterDTO> result = findService.find("Luke");

        assertIterableEquals(result, characters);
    }
}