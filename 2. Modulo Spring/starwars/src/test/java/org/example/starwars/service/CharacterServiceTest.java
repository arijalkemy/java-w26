package org.example.starwars.service;

import org.example.starwars.repository.CharacterRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CharacterServiceTest {

    @Mock
    CharacterRepositoryImpl characterRepository;

    @InjectMocks
    CharacterServiceService characterService;


    @Test
    void getAllCharactersWithName()
    {

        // arrange

        String name = "Luke";

        //act

        when(characterRepository.getCharactersByName("Luke")).thenReturn(List.of());
        characterRepository.getCharactersByName(name);

        // assert

        assertEquals(List.of(), characterService.getAllCharactersWithName(name));

    }
}
