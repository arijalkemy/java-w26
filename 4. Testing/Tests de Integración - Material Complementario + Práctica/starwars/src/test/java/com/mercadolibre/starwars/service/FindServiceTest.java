package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {
    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    public void testFind() {
        // arrange
        String query = "Luke";
        CharacterDTO character = new CharacterDTO(
                "Luke Skywalker",
                "blond",
                "fair",
                "blue",
                "19BBY",
                "male",
                "Tatooine",
                "Human",
                172,
                77
        );
        List<CharacterDTO> characters = List.of(character);

        // act

        when(characterRepository.findAllByNameContains(query)).thenReturn(characters);
        findService.find(query);

        // assert
        verify(characterRepository, atLeastOnce()).findAllByNameContains(query);
        Assertions.assertEquals(1, findService.find(query).size());
        Assertions.assertEquals(character, findService.find(query).get(0));
    }
}
