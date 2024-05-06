package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.utils.UtilTesting;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    void findTest() {

        List<CharacterDTO> characterDTOList = UtilTesting.getCharacters();

        Mockito.when(characterRepository.findAllByNameContains("Luke")).thenReturn(characterDTOList);

        List<CharacterDTO> result = findService.find("Luke");

        Mockito.verify(characterRepository, Mockito.times(1)).findAllByNameContains("Luke");
        assertEquals(characterDTOList, result);
    }
}