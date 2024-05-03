package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CharacterRepositoryImplTest {

    @Test
    @DisplayName("Test for return a list of Lukes")
    void findAllByNameContains() {
        // Assert
        CharacterRepositoryImpl characterRepository = new CharacterRepositoryImpl();
        String query = "Luke";

        // Act
        List<CharacterDTO> result = characterRepository.findAllByNameContains(query);

        // Assert
        assertFalse(result.isEmpty());
        assertEquals("Luke Skywalker", result.get(0).getName());
    }
}