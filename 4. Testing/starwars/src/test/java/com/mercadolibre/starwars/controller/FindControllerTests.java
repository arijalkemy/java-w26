package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindControllerTests {

    @Mock
    private FindService findService;

    @InjectMocks
    private FindController findController;

    @Test
    public void find_ReturnsCharacterList() {
        String query = "Luke";
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Luke Skywalker");

        List<CharacterDTO> characters = Collections.singletonList(characterDTO);
        when(findService.find(query)).thenReturn(characters);

        findController.find(query);

        verify(findService, times(1)).find(query);
    }
}
