package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {
    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    public void findTestOk() {
        // Arrange
        String name = "Luke";
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
        List<CharacterDTO> characterDTOs = new ArrayList<>(){{
            add(character);
        }};

        // Act
        when(characterRepository.findAllByNameContains(name)).thenReturn(characterDTOs);
        List<CharacterDTO> result = findService.find(name);

        // Assert
        Assertions.assertEquals(characterDTOs, result);
    }
}
