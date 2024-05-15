package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RepositoryTest {
    CharacterRepositoryImpl characterRepository = new CharacterRepositoryImpl() ;

    @Test
    public void testFindOk(){

        CharacterDTO luke = new CharacterDTO("Luke Skywalker","blond","fair","blue","19BBY","male","Tatooine","Human",172,77);

        List<CharacterDTO> expected = List.of(luke);

        String query = "Luke";
        List<CharacterDTO> returned;

        returned = characterRepository.findAllByNameContains(query);

        Assertions.assertEquals(expected,returned);
    }
}
