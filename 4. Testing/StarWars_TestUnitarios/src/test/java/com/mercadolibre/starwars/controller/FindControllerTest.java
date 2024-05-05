package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {
    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    List<CharacterDTO> charactersExpected;

    @BeforeEach()
    public void setUp(){
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
        when(findService.find("Luke")).thenReturn(charactersExpected);
    }

    @Test
    @DisplayName("")
    public void findByNameControllerTest(){
        String query = "Luke";
        List<CharacterDTO> result= findController.find(query);
        assertEquals(charactersExpected,result);
    }
}
