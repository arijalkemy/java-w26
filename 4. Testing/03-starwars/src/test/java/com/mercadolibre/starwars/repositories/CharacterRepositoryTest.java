package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
public class CharacterRepositoryTest {

    CharacterRepository characterRepository;

    @BeforeEach
    public void setUp(){
        characterRepository = new CharacterRepositoryImpl();
    }

    @Test
    public void findByName(){
        String name = "Luke";

        List<CharacterDTO> result = this.characterRepository.findAllByNameContains(name);

        Assertions.assertTrue(!result.isEmpty());
    }

    @Test
    public void findEmpty(){
        String name = "Un nombre que no figura";

        List<CharacterDTO> result = this.characterRepository.findAllByNameContains(name);

        Assertions.assertTrue(result.isEmpty());
    }
}