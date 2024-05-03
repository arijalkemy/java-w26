package com.mercadolibre.starwars.controller.unittest;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FindControllerTest {
    @Mock
    FindService service;
    @InjectMocks
    FindController controller;
    CharacterDTO expectedCharacter;

    @BeforeEach
    void setup() {
        expectedCharacter = new CharacterDTO(
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
        Mockito.when(service.find("Luke Skywalker"))
                .thenReturn(List.of(expectedCharacter));
    }

    @Test
    @DisplayName("Success response to get character")
    void getOk() {
        // Given - Arrange
        // When - Act
        List<CharacterDTO> response = controller.find("Luke Skywalker");
        // Then - Assert
        Assertions.assertFalse(response.isEmpty());
        org.assertj.core.api.Assertions.assertThat(response).contains(expectedCharacter);
    }
}
