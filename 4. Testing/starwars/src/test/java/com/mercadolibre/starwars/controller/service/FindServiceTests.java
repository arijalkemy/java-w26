package com.mercadolibre.starwars.controller.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FindServiceTests {

    @Test
    public void find_ReturnsFilteredCharacterList() {
        String query = "Skywalker";
        List<CharacterDTO> characters = List.of(
                new CharacterDTO("Luke Skywalker"),
                new CharacterDTO("Anakin Skywalker")
        );

        CharacterRepository characterRepository = mock(CharacterRepository.class);
        when(characterRepository.findAllByNameContains(query)).thenReturn(characters);

        FindService findService = new FindService(characterRepository);

        List<CharacterDTO> result = findService.find(query);

        for (CharacterDTO results: result
             ) {
            System.out.println(results.getName());
        }

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertTrue(result.stream().allMatch(characterDTO -> characterDTO.getName().contains(query)));
    }
}
