package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension .class)
class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    void find() {
        String param = "Darth";
        List<CharacterDTO> listCharactersExpected = new ArrayList<>();
        listCharactersExpected.add(new CharacterDTO("Darth Vader", "none", "white",
                "yellow", "41.9BBY", "male", "Tatooine", "Human",
                202, 136));
        listCharactersExpected.add(new CharacterDTO("Darth Maul", "none", "red",
                "yellow", "54BBY", "male", "Darthomir", "Zabrak",
                175, 80));

        when(characterRepository.findAllByNameContains(param)).thenReturn(listCharactersExpected);
        List<CharacterDTO> listCharactersObteined= findService.find(param);

        Assertions.assertEquals(listCharactersExpected, listCharactersObteined);
    }
}