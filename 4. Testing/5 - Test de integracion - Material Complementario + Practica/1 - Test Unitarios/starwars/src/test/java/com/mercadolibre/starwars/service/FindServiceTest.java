package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {
    @Mock
    CharacterRepositoryImpl characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    @DisplayName("should return a list with the data of Luke Skywalker")
    public void findTest(){
        String query = "Luke";
        List<CharacterDTO> expectedCharacters = Arrays.asList(
                new CharacterDTO(
                        "Luke Skywalker",
                        "blond",
                        "fair",
                        "blue",
                        "19BBY",
                        "male",
                        "Tatooine",
                        "Human",
                        172,
                        77
                )
        );

        when(characterRepository.findAllByNameContains(query)).thenReturn(expectedCharacters);
        List<CharacterDTO> actualCharacters = findService.find(query);

        assertEquals(expectedCharacters.size(), actualCharacters.size());
        assertEquals(expectedCharacters.get(0).getName(), actualCharacters.get(0).getName());
        assertEquals(expectedCharacters.get(0).getName(), actualCharacters.get(0).getName());
        assertEquals(expectedCharacters.get(0).getHair_color(), actualCharacters.get(0).getHair_color());
        assertEquals(expectedCharacters.get(0).getSkin_color(), actualCharacters.get(0).getSkin_color());
        assertEquals(expectedCharacters.get(0).getHeight(), actualCharacters.get(0).getHeight());
        assertEquals(expectedCharacters.get(0).getGender(), actualCharacters.get(0).getGender());
        assertEquals(expectedCharacters.get(0).getMass(), actualCharacters.get(0).getMass());
        assertEquals(expectedCharacters.get(0).getBirth_year(), actualCharacters.get(0).getBirth_year());
        assertEquals(expectedCharacters.get(0).getHomeworld(), actualCharacters.get(0).getHomeworld());
    }

    @Test
    @DisplayName("should return an empty list")
    public void findTest_EmptyList(){
        String query = "empty";
        when(characterRepository.findAllByNameContains(query)).thenReturn(Collections.emptyList());

        List<CharacterDTO> actualCharacters = findService.find(query);

        assertTrue(actualCharacters.isEmpty());
    }
}
