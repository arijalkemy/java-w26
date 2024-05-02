package com.mercadolibre.starwars.controller.unit;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.utils.TestUtils;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
public class FindControllerTest {
    static List<CharacterDTO> charactersDTOList;

    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @BeforeAll
    static void loadCharacters () {
        charactersDTOList = TestUtils.readCharactersJSON();
    }

    @Test
    @DisplayName("Should return empty list when there are no matches")
    void shouldReturnEmptyListWhenNoMatches() {
        String query = "queryString";
        List<CharacterDTO> expectedCharactersList = new ArrayList<>();
        Mockito.when(findService.find(query)).thenReturn(expectedCharactersList);

        List<CharacterDTO> actualCharactersList = findController.find(query);

        Assertions.assertEquals(actualCharactersList, expectedCharactersList);
    }

    @Test
    @DisplayName("Should handle empty query")
    void shouldReturnEmptyListWhenEmptyQuery() {
        String query = "";
        List<CharacterDTO> expectedCharactersList = charactersDTOList;
        Mockito.when(findService.find(query)).thenReturn(expectedCharactersList);

        List<CharacterDTO> actualCharactersList = findController.find(query);

        Assertions.assertEquals(actualCharactersList, expectedCharactersList);
    }

    @Test
    @DisplayName("Should handle null query")
    void shouldReturnEmptyListWhenNullQuery() {
        String query = null;
        List<CharacterDTO> expectedCharactersList = new ArrayList<>();
        Mockito.when(findService.find(query)).thenReturn(expectedCharactersList);

        List<CharacterDTO> actualCharactersList = findController.find(query);

        Assertions.assertEquals(actualCharactersList, expectedCharactersList);
    }

    @Test
    @DisplayName("Should find character")
    void shouldFindCharacter() {
        String query = "Luke";
        List<CharacterDTO> expectedCharactersList = charactersDTOList.
                stream().
                filter(c->c.getName().toLowerCase().contains(query.toLowerCase())).
                collect(Collectors.toList());
        Mockito.when(findService.find(query)).thenReturn(expectedCharactersList);

        List<CharacterDTO> actualCharactersList = findController.find(query);

        Assertions.assertEquals(actualCharactersList, expectedCharactersList);
    }
}
