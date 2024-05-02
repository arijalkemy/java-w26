package com.mercadolibre.starwars.unit.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CharacterRepositoryTest {

    CharacterRepositoryImpl characterRepository = new CharacterRepositoryImpl();

    @Test
    void findAllByNameContainsTest() {
        String query = "Luke";

        List<CharacterDTO> expected = List.of(new CharacterDTO( "Luke Skywalker", "blond", "fair", "blue",
                "19BBY", "male", "Tatooine", "Human",172,77 ));

        List<CharacterDTO> characters = characterRepository.findAllByNameContains(query);

        assertIterableEquals(expected, characters);
    }

    @Test
    void findAllByNameNotContainsTest() {
        String query = "Roberto";

        List<CharacterDTO> expected = new ArrayList<>();

        List<CharacterDTO> characters = characterRepository.findAllByNameContains(query);

        assertIterableEquals(expected, characters);
    }
}