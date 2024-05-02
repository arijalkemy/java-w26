package com.mercadolibre.starwars.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


import static org.mockito.Mockito.when;

@SpringBootTest
public class CharacterRepositoryTest {
    private CharacterRepositoryImpl repository;

    @BeforeEach
    public void setup(){
        this.repository = new CharacterRepositoryImpl();
    }

    @Test
    @DisplayName("Buscar un nombre existente")
    public void findAllByNameContainsOk() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        String query="luke";

        List<CharacterDTO> characterDTOS = new ArrayList<>();
        characterDTOS.add(new CharacterDTO(
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
        ));

        List<CharacterDTO> obtainsList = repository.findAllByNameContains(query);

        String obtainJson = mapper.writeValueAsString(obtainsList);
        String actualJson = mapper.writeValueAsString(characterDTOS);


        Assertions.assertEquals(actualJson, obtainJson);
    }

    @Test
    @DisplayName("Buscamos un nombre no existente")
    public void findAllByNameContainsNotFound() throws Exception {
        String query="pepo";

        List<CharacterDTO> obtainsList = repository.findAllByNameContains(query);

        Assertions.assertEquals(new ArrayList<>(), obtainsList);
    }


}
