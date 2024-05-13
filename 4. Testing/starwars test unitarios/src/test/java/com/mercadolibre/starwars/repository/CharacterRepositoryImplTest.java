package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterRepositoryImplTest {
    private CharacterRepositoryImpl characterRepository;
    private List<CharacterDTO> database;
    @BeforeEach
    public void setUp() {
        characterRepository = new CharacterRepositoryImpl();
        database = characterRepository.loadDataBase();
    }

    @Test
    @DisplayName("encontar personajes por nombre")
    public void testFindAllByNameContains() {
        List<CharacterDTO> result = characterRepository.findAllByNameContains("Luke Skywalker");

        assertEquals("Luke Skywalker", result.get(0).getName());
    }
}
