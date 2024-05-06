package com.mercadolibre.starwars.service;


import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;


    @Test
    public void FindOneCharacter(){
        String nombrePrueba = "Luke";
        CharacterDTO lukeSkywalkerCharacter = new CharacterDTO();
        lukeSkywalkerCharacter.setName("Luke Skywalker");

        Mockito.when(characterRepository.findAllByNameContains(nombrePrueba)).thenReturn(List.of(lukeSkywalkerCharacter));
        List<CharacterDTO> characterDTOList = this.findService.find(nombrePrueba);

        Assertions.assertTrue(characterDTOList.stream().anyMatch(c -> c.getName().contains(nombrePrueba)));
    }

    @Test
    public void FindEmpty(){
        String nombrePrueba = "Un nombre que no figura";

        Mockito.when(characterRepository.findAllByNameContains(nombrePrueba)).thenReturn(new ArrayList<>());

        List<CharacterDTO> characterDTOList = this.findService.find(nombrePrueba);

        Assertions.assertTrue(characterDTOList.isEmpty());
    }
}
