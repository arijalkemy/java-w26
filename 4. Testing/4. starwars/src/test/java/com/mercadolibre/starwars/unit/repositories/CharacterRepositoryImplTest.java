package com.mercadolibre.starwars.unit.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CharacterRepositoryImplTest {

    CharacterRepositoryImpl characterRepository = new CharacterRepositoryImpl();

    @Test
    void findAllByNameContains() {

        CharacterDTO expected = new CharacterDTO( "Luke Skywalker", "blond", "fair", "blue",
                "19BBY", "male", "Tatooine", "Human",172,77 );

        List<CharacterDTO> characters = characterRepository.findAllByNameContains("Luke");

        assertEquals(1, characters.size());
        assertEquals(expected.getName(), characters.get(0).getName());
    }
}