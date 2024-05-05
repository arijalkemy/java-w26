package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FindServiceTest {

    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private FindService findService;

    @Test
    public void findSuccessfullyTest() {
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
        when(characterRepository.findAllByNameContains("Luke")).thenReturn(
            expectedResult
        );

        // Act
        List<CharacterDTO> result = findService.find("Luke");

        // Assert
        assertEquals(result, expectedResult);
    }

    @Test
    public void findWithoutResultsTest() {
        // Arrange
        List<CharacterDTO> expectedResult = new ArrayList<CharacterDTO>();
        when(characterRepository.findAllByNameContains("Luke")).thenReturn(
                expectedResult
        );

        // Act
        List<CharacterDTO> result = findService.find("Luke");

        // Assert
        assertEquals(result, expectedResult);
    }
}
