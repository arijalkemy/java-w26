package com.mercadolibre.starwars.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.mercadolibre.starwars.dto.CharacterDTO;

 class CharacterRepositoryImplTest {

    private static CharacterRepositoryImpl underTest;

    @BeforeAll
    static void init() {
        underTest = new CharacterRepositoryImpl();
    }


    @Test
    void givenSkywalker_whenQuery_result3List() {
        String query = "Skywalker";

        List<CharacterDTO> actual = underTest.findAllByNameContains(query);

        assertEquals(3, actual.size());

    }



    @Test
    void givenBadQuery_whenQuery_resultEmptyList() {
        String query = "leob";

        List<CharacterDTO> actual = underTest.findAllByNameContains(query);

        assertTrue(actual.isEmpty());

    }

}
