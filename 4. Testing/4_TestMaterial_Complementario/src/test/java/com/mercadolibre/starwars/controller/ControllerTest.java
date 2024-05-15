package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {
    @Mock
    FindService findService;
    @InjectMocks
    FindController findController;

    @Test
    public void controllerTestOK(){
        String query = "Luke";
        List<CharacterDTO> response = new ArrayList<>();

        when(findService.find(query)).thenReturn(response);

        List<CharacterDTO> expected = findController.find(query);

        verify(findService,atLeastOnce()).find(query);

        Assertions.assertEquals(response,expected);
    }
}
