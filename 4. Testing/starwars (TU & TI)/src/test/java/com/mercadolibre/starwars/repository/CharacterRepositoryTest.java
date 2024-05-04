package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.util.TestStarWarsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CharacterRepositoryTest {

    private CharacterRepositoryImpl characterRepository;

    @BeforeEach
    public void setup() {
        this.characterRepository = new CharacterRepositoryImpl();
    }

    @Test
    @DisplayName("Obtener una lista de todos los characters que contengan la coincidencia del query")
    public void findAllIfContainsQuery() {

        String query = "Luke Skywalker";
        List<CharacterDTO> LukeEsperado = TestStarWarsGenerator.characterLuke();

        List<CharacterDTO> LukeObtenido = characterRepository.findAllByNameContains(query);

        Assertions.assertEquals(LukeEsperado, LukeObtenido);

    }
}
