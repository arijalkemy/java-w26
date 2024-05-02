package com.mercadolibre.starwars.service.unit;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import com.mercadolibre.starwars.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
public class FindServiceTest {
    static List<CharacterDTO> charactersDTOList = new ArrayList<>();

    @Autowired
    FindService findService;
    @Autowired
    private ServerProperties serverProperties;

    @BeforeAll
    static void loadCharacters () {
        charactersDTOList = TestUtils.readCharactersJSON();
    }

    @Test
    @DisplayName("Should throw exception with null query")
    void shouldThrowRuntimeExceptionInNullQuery() {
        String query = null;

        Assertions.assertThrows(NullPointerException.class, () -> findService.find(query));
    }

    @Test
    @DisplayName("Should handle empty query")
    void shouldHandleEmptyQuery() {
        String query = "";
        List<CharacterDTO> expectedCharactersList = charactersDTOList;

        List<CharacterDTO> actualCharactersList = findService.find(query);

        Assertions.assertEquals(expectedCharactersList, actualCharactersList);
    }

    @Test
    @DisplayName("Should find character")
    void shouldFindCharacter() {
        String query = "Luke";
        List<CharacterDTO> expectedCharactersList = charactersDTOList.
                stream().
                filter(c->c.getName().toLowerCase().contains(query.toLowerCase())).
                collect(Collectors.toList());


        List<CharacterDTO> actualCharactersList = findService.find(query);

        Assertions.assertEquals(actualCharactersList, expectedCharactersList);
    }

    @Test
    @DisplayName("Should return empty list when there are no matches")
    void shouldReturnEmptyListWhenNoMatches() {
        String query = "queryString";
        List<CharacterDTO> expectedCharactersList = new ArrayList<>();

        List<CharacterDTO> actualCharactersList = findService.find(query);

        Assertions.assertEquals(actualCharactersList, expectedCharactersList);
    }
}
