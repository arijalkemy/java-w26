package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {
    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    public void bucarCharacteres(){
        String param = "Luke";

        CharacterDTO luke = new CharacterDTO();
        luke.setName("Luke Skywalker");
        luke.setHair_color("blond");
        luke.setSkin_color("fair");
        luke.setEye_color("blue");
        luke.setBirth_year("19BBY");
        luke.setGender("male");
        luke.setHomeworld("Tatooine");
        luke.setSpecies("Human");
        luke.setHeight(172);
        luke.setMass(77);

        List<CharacterDTO> listMock = new ArrayList<>();
        listMock.add(luke);

        Mockito.when(characterRepository.findAllByNameContains(param)).thenReturn(listMock);
        List<CharacterDTO> lista = findService.find(param);

        for (CharacterDTO character:lista){
            Assertions.assertEquals(luke, character);
        }


    }

}
