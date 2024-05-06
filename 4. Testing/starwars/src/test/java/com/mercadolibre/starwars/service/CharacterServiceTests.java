package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

public class CharacterServiceTests {
    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    public void testFind() {
        //arrange
        CharacterDTO expected = new CharacterDTO();
        expected.setName("Luke Skywalker");

        //act
        CharacterDTO response = findService.find("Luke").get(0);
        //assert
        verify(characterRepository, atLeastOnce()).findAllByNameContains("Luke");

        Assertions.assertEquals(expected.getName(), response.getName());
    }

    @Test
    public void testFindEmpty() {
        //arrange
        CharacterDTO expected = new CharacterDTO();
        expected.setName("Luke Skywalker");

        //act
        CharacterDTO response = findService.find("Luke").get(0);
        //assert
        verify(characterRepository, atLeastOnce()).findAllByNameContains("Luke");

        Assertions.assertEquals(expected.getName(), response.getName());
    }



}
