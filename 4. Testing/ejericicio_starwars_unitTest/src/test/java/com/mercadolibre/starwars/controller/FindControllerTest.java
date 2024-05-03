package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FindControllerTest {
    @Mock
    private FindService findService;

    @InjectMocks
    private FindController findController;

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
        when(findService.find("Luke")).thenReturn(expectedResult);

        // Act
        List<CharacterDTO> result = findController.find("Luke");

        // Assert
        assertEquals(result, expectedResult);
    }

    @Test
    public void findWithoutResultsTest() {
        // Arrange
        List<CharacterDTO> expectedResult = new ArrayList<CharacterDTO>();
        when(findService.find("asdasdasd")).thenReturn(expectedResult);

        // Act
        List<CharacterDTO> result = findController.find("asdasdasd");

        // Assert
        assertEquals(result, expectedResult);
    }
}
