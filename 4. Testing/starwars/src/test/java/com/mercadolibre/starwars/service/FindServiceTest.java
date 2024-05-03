package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class FindServiceTest {

    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private FindService findService;

    @Test
    @DisplayName("Test for return a list of Lukes")
    void find() {
        // Arrange
        String query = "Luke";
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Luke Skywalker");
        when(characterRepository.findAllByNameContains(query)).thenReturn(List.of(characterDTO));

        // Act
        List<CharacterDTO> result = findService.find(query);

        // Assert
        verify(characterRepository, atLeast(1)).findAllByNameContains(query);
        assertEquals(1, result.size());
        assertEquals("Luke Skywalker", result.get(0).getName());
    }
}