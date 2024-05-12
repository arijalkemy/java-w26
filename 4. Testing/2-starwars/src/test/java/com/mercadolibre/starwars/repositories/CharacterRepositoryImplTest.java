package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CharacterRepositoryImplTest {

    CharacterRepositoryImpl characterRepository;

    @BeforeEach
    void setUp() {
        characterRepository = new CharacterRepositoryImpl();
    }

    @Test
    @DisplayName("Filtra los nombres que contengan la palabra Dark")
    public void findAllByNameContains() {
        // Arrange
        List<CharacterDTO> list = List.of(

                new CharacterDTO(
                        "Biggs Darklighter",
                        "black",
                        "light",
                        "brown",
                        "24BBY",
                        "male",
                        "Tatooine",
                        "Human",
                        183,
                        84
                )
        );

        // Act
        List<CharacterDTO> result = characterRepository.findAllByNameContains("Dark");

        /// Assert
        assertThat(list).isEqualTo(result);
    }
}
