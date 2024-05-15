package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
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
public class ServiceTest {
    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    public void findOk(){
        String query = "Luke";
        List<CharacterDTO> response = new ArrayList<>();

        when(characterRepository.findAllByNameContains(query)).thenReturn(response);

        List<CharacterDTO> expected = findService.find(query);

        verify(characterRepository,atLeastOnce()).findAllByNameContains(query);

        Assertions.assertEquals(response,expected);
    }
}
