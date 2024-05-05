package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CharacterRepositoryImplTest {

    CharacterRepository characterRepository;

    @BeforeEach
    void setUp() {
        characterRepository = new CharacterRepositoryImpl();
    }

    @Test
    void findAllByNameContainsValid() {
        String param = "Darth";
        List<CharacterDTO> charactersExpected = new ArrayList<>();
        charactersExpected.add(new CharacterDTO("Darth Vader", "none", "white",
                "yellow", "41.9BBY", "male", "Tatooine", "Human",
                202, 136));
        charactersExpected.add(new CharacterDTO("Darth Maul", "none", "red",
                "yellow", "54BBY", "male", "Darthomir", "Zabrak",
                175, 80));
        List<CharacterDTO> charactersObteined = characterRepository.findAllByNameContains(param);
        assertEquals(charactersExpected.get(0).getName(), charactersObteined.get(0).getName());
        assertEquals(charactersExpected.get(1).getName(), charactersObteined.get(1).getName());
    }

    @Test
    void findAllByNameContainsInvalid() {
        String param = "Camila";
        List<CharacterDTO> charactersObteined = characterRepository.findAllByNameContains(param);
        assertEquals(0, charactersObteined.size());

    }
}