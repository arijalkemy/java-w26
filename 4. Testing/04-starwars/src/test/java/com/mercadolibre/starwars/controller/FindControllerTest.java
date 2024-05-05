package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class, SpringExtension.class})
@SpringBootTest
class FindControllerTest {

    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

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

        when(findService.find(param)).thenReturn(listCharactersExpected);
        List<CharacterDTO> listCharactersObteined= findController.find(param);

        Assertions.assertEquals(listCharactersExpected, listCharactersObteined);
    }
}