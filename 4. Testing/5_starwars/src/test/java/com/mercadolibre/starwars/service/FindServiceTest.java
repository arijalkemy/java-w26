package com.mercadolibre.starwars.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;

@ExtendWith(MockitoExtension.class)
class FindServiceTest {

    @Mock
    private CharacterRepository repository;

    @InjectMocks
    private FindService underTest;

    @Test
    void whenQuery_shouldCalllRepository() {
        String query = "";
        List<CharacterDTO> exp = List.of();
        when(repository.findAllByNameContains(query)).thenReturn(exp);

        List<CharacterDTO> actual = underTest.find(query);
        verify(repository, atLeast(1)).findAllByNameContains(anyString());
        assertEquals(exp, actual);  
    }

}
