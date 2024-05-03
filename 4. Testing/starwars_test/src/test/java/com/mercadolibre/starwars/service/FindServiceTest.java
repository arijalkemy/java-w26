package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
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
public class FindServiceTest {
    @Mock
    CharacterRepository repository;
    @InjectMocks
    FindService service;

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
        Mockito.when(repository.findAllByNameContains("Luke Skywalker"))
                .thenReturn(List.of(expectedCharacter));
    }

    @Test
    @DisplayName("Success response to get character")
    void getCharacterOk() {
        // Given - Arrange
        // When - Act
        List<CharacterDTO> response = service.find("Luke Skywalker");
        // Then - Assert
        Assertions.assertFalse(response.isEmpty());
        org.assertj.core.api.Assertions.assertThat(response).contains(expectedCharacter);
    }
}
