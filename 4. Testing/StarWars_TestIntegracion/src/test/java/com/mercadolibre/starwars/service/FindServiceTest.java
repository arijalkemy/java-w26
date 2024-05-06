package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class FindServiceTest {
    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private FindService findService;

    List<CharacterDTO> charactersExpected;


    @BeforeEach()
    public void setup(){
        CharacterDTO lukeSkywalker= new CharacterDTO();
        lukeSkywalker.setSpecies("Human");
        lukeSkywalker.setHair_color("blond");
        lukeSkywalker.setName("Luke Skywalker");
        lukeSkywalker.setHeight(172);
        lukeSkywalker.setMass(77);
        lukeSkywalker.setSkin_color("fair");
        lukeSkywalker.setEye_color("blue");
        lukeSkywalker.setBirth_year("19BBY");
        lukeSkywalker.setGender("male");
        lukeSkywalker.setHomeworld("Tatooine");
        charactersExpected = List.of(
                lukeSkywalker
        );
        when(characterRepository.findAllByNameContains("Luke")).thenReturn(charactersExpected);
    }


    @Test
    @DisplayName("Find character with query test")
    public void findTest(){

        List<CharacterDTO> result;

        result=findService.find("Luke");

        assertEquals(result,charactersExpected);

    }


}
