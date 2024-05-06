package com.mercadolibre.starwars.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@SpringBootTest
class FindControllerTest {

    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;


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
    void findLukeSkywalkerTest() throws Exception {
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

        Mockito.when(findService.find("Luke")).thenReturn(List.of(lukeSkywalker));

        List<CharacterDTO> result = findController.find("Luke");

        Assertions.assertTrue(result.contains(lukeSkywalker));
        Assertions.assertTrue(result.size() == 1);

    }

}