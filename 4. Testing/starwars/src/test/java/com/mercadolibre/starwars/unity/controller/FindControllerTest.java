package com.mercadolibre.starwars.unity.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class FindControllerTest {
    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;
    
    private CharacterDTO characterDTO;

    @BeforeEach
    void setUp() {
        characterDTO = new CharacterDTO("Luke Skywalker", "blond", "fair", "blue",
                "19BBY", "male", "Tatoine", "Human", 172, 77);
    }

    @Test
    @DisplayName("Find character in Controller successful")
     void testFindCharactersSuccessful() {
        // Arrange
        when(findService.find(characterDTO.getName())).thenReturn(List.of(characterDTO));
        // Act:
        List<CharacterDTO> result = findController.find(characterDTO.getName());

        // Assert:
        assertEquals(1, result.size());
        assertEquals(characterDTO.getName(), result.get(0).getName());
        verify(findService, atLeastOnce()).find(characterDTO.getName());
    }

    @Test
    @DisplayName("Find character not found in Controller")
     void testFindCharactersNotFound() {
        // Arrange:
        when(findService.find(characterDTO.getName())).thenReturn(List.of());

        // Act
        List<CharacterDTO> result = findController.find(characterDTO.getName());

        // Assert
        assertEquals(0, result.size());
        verify(findService, atLeastOnce()).find(characterDTO.getName());
    }
}
