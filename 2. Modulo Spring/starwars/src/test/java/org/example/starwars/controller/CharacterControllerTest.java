package org.example.starwars.controller;

import org.example.starwars.service.ICharacterService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class CharacterControllerTest {

    @Mock
    ICharacterService characterService;

    @InjectMocks
    CharacterController characterController;

    @Test
    void findAllTest()
    {
        // arrange

        String name = "Luke";
        ResponseEntity<List<Object>> expectedResponse = ResponseEntity.ok(List.of());
        //act

        when(characterService.getAllCharactersWithName("Luke")).thenReturn(List.of());
        ResponseEntity<?> response = characterController.findAll(name);

        //assert

        assertEquals(expectedResponse, response);
    }

}
