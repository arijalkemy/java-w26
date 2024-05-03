package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CharacterRepositoryImpTest {
    @Autowired
    CharacterRepository repository;

    @Test
    @DisplayName("Success test to get character")
    void findAllByNameContains() {
        // Given - Arrange
        String charName = "Luke Skywalker";
        CharacterDTO expectedCharacter = new CharacterDTO(
                charName,
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
        // When - Act
        List<CharacterDTO> foundCharacters = repository.findAllByNameContains(charName);
        // Then - Assert
        Assertions.assertThat(foundCharacters).contains(expectedCharacter);
    }

    @Test
    @DisplayName("Test where name does not match")
    void findAllByNameNotContains() {
        // Given - Arrange
        // When - Act
        List<CharacterDTO> foundCharacters = repository.findAllByNameContains("Alfredo");
        // Then - Assert
        org.junit.jupiter.api.Assertions.assertTrue(foundCharacters.isEmpty());
    }
}
