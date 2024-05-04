package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import com.mercadolibre.starwars.util.TestStarWarsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {

    @Mock
    FindService service;

    @InjectMocks
    FindController controller;

    @Test
    @DisplayName("Obtencion de un personaje de Star wars por nombre obtenido de manera exitosa")
    public void obtenerPersonaje() {
        String query = "Luke";

        List<CharacterDTO> Luke = TestStarWarsGenerator.characterLuke();

        when(service.find(query)).thenReturn(Luke);
        List<CharacterDTO> characterObtained = controller.find(query);

        Assertions.assertEquals(Luke, characterObtained);


    }
}
