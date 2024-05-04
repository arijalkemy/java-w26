package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.util.UtilTestCharacters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CharacterReposirotyTest {
    @Autowired
    CharacterRepository repository;

    private List<CharacterDTO> characters;

    @BeforeEach
    public void setup(){
        characters = repository.findAllByNameContains("");
    }

    @Test
    public void repositoryByNameTest(){
        String search = "lu";
        List<CharacterDTO> expected = UtilTestCharacters.filterCharacters(characters, search);
        List<CharacterDTO>  result = repository.findAllByNameContains(search);
        Assertions.assertEquals(expected, result);
    }
}
