package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CharacterRepositoryTest {
    static CharacterRepository characterRepository;

    @BeforeAll
    public static void setUp() {
        characterRepository = new CharacterRepositoryImpl();
    }

    @Test
    public void findAllByNameContains() {
        // Arrange
        String name = "Luke";
        CharacterDTO characterExpected = new CharacterDTO(
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

        // Act
        List<CharacterDTO> result = characterRepository.findAllByNameContains(name);

        // Assert
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(characterExpected, result.get(0));
    }
}
