package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.service.FindService;
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
public class FindControllerTest{
    @Mock
    private CharacterRepositoryImpl repository;

    @InjectMocks
    private FindService service;

    @Test
    public void findLukeOk(){
        //ARRANGE
        String query = "Luke";
        List<CharacterDTO> characterDTOS = new ArrayList<>();
        characterDTOS.add(new CharacterDTO(
                "Luke Skywalker",
                172,
                77,
                "blond",
                "fair",
                "blue",
                "19BBY",
                "male",
                "Tatooine",
                "Human"
        ));
        //ACT
        Mockito.when(service.find(query)).thenReturn(characterDTOS);
        //ASSERT
        Assertions.assertEquals(characterDTOS, service.find(query));
    }

    @Test
    public void findNotFound(){
        //ARRANGE
        String query = "Pedro";
        //ACT
        Mockito.when(service.find(query)).thenReturn(new ArrayList<>());
        //ASSERT
        Assertions.assertEquals(new ArrayList<>(), service.find(query));
    }
}
