package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CharacterRepositoryImpTest {
    private CharacterRepositoryImpl characterRepository;

    @BeforeEach
    public void setUp(){
        this.characterRepository = new CharacterRepositoryImpl();
    }
    @Test
    @DisplayName("it should return one item about Luke SkyWalker")
    public void findAllByNameContainsTest() {
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

        List<CharacterDTO> actualCharacters = characterRepository.findAllByNameContains("Luke");
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
    @DisplayName("it should return a empty list")
    public void findAllByNameContainsTest_EmptyList(){
        String query = "empty";
        List<CharacterDTO> actualCharacterList = characterRepository.findAllByNameContains(query);

        assertTrue(actualCharacterList.isEmpty());
    }

}
