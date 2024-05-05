package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterRepositoryTest {
    private CharacterRepositoryImpl characterRepository;

    @BeforeEach
    public void setup() {
        characterRepository = new CharacterRepositoryImpl();
    }

    @Test
    public void findAllByNameContainsTest() {
        // Arrange
        List<CharacterDTO> expectedResult = new ArrayList<CharacterDTO>();
        expectedResult.add(
            new CharacterDTO(
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
            )
        );

        // Act
        List<CharacterDTO> result = characterRepository.findAllByNameContains("Luke");

        // Assert
        assertEquals(result.size(), expectedResult.size());
        for(int i = 0; i < result.size(); i++) {
            assertEquals(result.get(i), expectedResult.get(i));
        }
    }

    @Test
    public void findAllByNameContainsWithoutResultsTest() {
        // Act && Assert
        List<CharacterDTO> result = characterRepository.findAllByNameContains("asdasdasd");

        // Assert
        assertTrue(result.isEmpty());
    }

    @Test
    public void findAllByNameContainsNullQuery() {
        // Assert & Assert
        assertThrows(NullPointerException.class, () -> {
            characterRepository.findAllByNameContains(null);
        });
    }
}
