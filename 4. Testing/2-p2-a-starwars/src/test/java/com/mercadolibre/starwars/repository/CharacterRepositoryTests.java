package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterRepositoryTests {

    private CharacterRepositoryImpl characterRepository;

    @BeforeEach
    public void setUp() {
        characterRepository = new CharacterRepositoryImpl();
    }

    @Test
    public void findAllByNameContainsTest() {
        // Given
        String query = "Skywalker";

        // When
        List<CharacterDTO> result = characterRepository.findAllByNameContains(query);

        // Then
        assertEquals(3, result.size());
        assertEquals("Luke Skywalker", result.get(0).getName());
        assertEquals("Anakin Skywalker", result.get(1).getName());
        assertEquals("Shmi Skywalker", result.get(2).getName());
    }

    @Test
    public void testFindAllByNameContains_NoResults() {
        // Given
        String query = "Andy";

        // When
        List<CharacterDTO> result = characterRepository.findAllByNameContains(query);

        // Then
        assertEquals(0, result.size());
    }
}
