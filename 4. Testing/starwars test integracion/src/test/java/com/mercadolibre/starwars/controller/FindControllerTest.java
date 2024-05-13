package com.mercadolibre.starwars.controller;


import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {

    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @Test
    @DisplayName("buscar por query")
    public void buscarPorQuery() {

        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Luke Skywalker");
        List<CharacterDTO> characterDTOList = new ArrayList<>();
        characterDTOList.add(characterDTO);

        when(findService.find("Luke Skywalker")).thenReturn(characterDTOList);

        findController.find("Luke Skywalker");

        Assertions.assertEquals("Luke Skywalker", characterDTOList.get(0).getName());
    }
}
