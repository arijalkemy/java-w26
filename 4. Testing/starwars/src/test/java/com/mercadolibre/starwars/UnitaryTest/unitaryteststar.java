package com.mercadolibre.starwars.UnitaryTest;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class unitaryteststar {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    public void findControllerTest() {
        String query = "Luke";

        List<CharacterDTO> expected = Collections.singletonList(new CharacterDTO());

        when(characterRepository.findAllByNameContains(query)).thenReturn(expected);

        List<CharacterDTO> result = findService.find(query);

        Assertions.assertEquals(expected, result);

        verify(characterRepository).findAllByNameContains(query);
        verify(characterRepository , times(1)).findAllByNameContains(query);
        verify(characterRepository).findAllByNameContains(query);
    }

    @Test
    public void characterRepositoryTest()
    {

        String query = null;

        List<CharacterDTO> expected = Collections.emptyList();

        when(characterRepository.findAllByNameContains(query)).thenReturn(expected);

        List<CharacterDTO> result = findService.find(query);

        Assertions.assertEquals(expected, result);
        verify(characterRepository , times(1)).findAllByNameContains(query);

    }

    @Test
    public void findTest_databaseError() {
        String query = "Luke";
        when(characterRepository.findAllByNameContains(query)).thenThrow(new RuntimeException("Database error"));

        assertThrows(RuntimeException.class, () -> findService.find(query));
        verify(characterRepository, times(1)).findAllByNameContains(query);
    }


}
