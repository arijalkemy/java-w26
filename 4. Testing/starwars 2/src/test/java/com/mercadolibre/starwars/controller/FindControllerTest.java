package com.mercadolibre.starwars.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class FindControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
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
        CharacterDTO c3po = new CharacterDTO(
                "C-3PO",
                "NA",
                "gold",
                "yellow",
                "112BBY",
                "NA",
                "Tatooine",
                "Droid",
                167,
                75
        );
        CharacterDTO r2d2 = new CharacterDTO(
                "R2-D2",
                "NA",
                "white, blue",
                "red",
                "33BBY",
                "NA",
                "Naboo",
                "Droid",
                96,
                32
        );

        // update the starwars.json with these characters

        List<CharacterDTO> characters = new ArrayList<>();
        characters.add(lukeSkywalker);
        characters.add(c3po);
        characters.add(r2d2);

        // update the starwars.json with these characters

        File file = new File("starwars.json");
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writeValue(file, characters);
        } catch (IOException ioException) {
            System.out.println("Error al escribir el archivo");
        }

    }


    @Test
    void findLukeSkywalkerTest() throws Exception {
        // Given
        String query = "Luke";

        // When

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/" + query))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        // Then

        String response = result.getResponse().getContentAsString();
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
        List<CharacterDTO> reponseCharacterDTO = new ObjectMapper().readValue(
                response,
                new TypeReference<List<CharacterDTO>>() {
                }
                                                                             );

        System.out.println(reponseCharacterDTO);

        Assertions.assertEquals(lukeSkywalker, reponseCharacterDTO.get(0));
    }
}