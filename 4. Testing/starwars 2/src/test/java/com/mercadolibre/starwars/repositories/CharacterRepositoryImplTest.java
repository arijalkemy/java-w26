package com.mercadolibre.starwars.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.utils.UtilTesting;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CharacterRepositoryImplTest {

    CharacterRepositoryImpl characterRepository = new CharacterRepositoryImpl();

    @BeforeAll
    static void setUp() throws FileNotFoundException {

        File file = ResourceUtils.getFile("./src/test/resources/starwars_characters.json");;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writeValue(file, List.of());
        } catch (IOException ioException) {
            System.out.println("Error al escribir el archivo");
        }
    }

    @AfterEach
    void tearDown() throws FileNotFoundException {
        File file = ResourceUtils.getFile("./src/test/resources/starwars_characters.json");;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writeValue(file, List.of());
        } catch (IOException ioException) {
            System.out.println("Error al escribir el archivo");
        }
    }

    @Test
    void findAllByNameContainsLuke() throws IOException {
        UtilTesting.writeCharacters(UtilTesting.getCharacters());

        CharacterDTO lukeSkywalker = new CharacterDTO(
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
        );
        CharacterDTO lukeSkywalker2 = new CharacterDTO(
                "Luke Skywalker 2",
                "blond",
                "fair",
                "blue",
                "19BBY",
                "male",
                "Tatooine",
                "Human",
                172,
                77
        );

        List<CharacterDTO> expectedList = List.of(lukeSkywalker,lukeSkywalker2);

        List<CharacterDTO> result = characterRepository.findAllByNameContains("Luke");

        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(expectedList, result);

    }

    @Test
    void findAllByNameEmpty(){
        UtilTesting.writeCharacters(UtilTesting.getCharacters());

        List<CharacterDTO> result = characterRepository.findAllByNameContains("123");

        Assertions.assertEquals(0, result.size());
    }

}