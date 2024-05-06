package com.mercadolibre.starwars.integration;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.utils.UtilTesting;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    static ObjectWriter objectWriter;

    @BeforeAll
    static void setUp() {
        UtilTesting.writeCharacters(UtilTesting.getCharacters());
        objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @AfterEach
    void tearDown() {
        UtilTesting.writeCharacters(UtilTesting.getCharacters());
    }


    @Test
    void testFindLuke() throws Exception {

        List<CharacterDTO> expectedResponse =
                UtilTesting.getCharacters()
                        .stream().filter(
                                c -> c.getName().contains("Luke")
                        ).toList();


        mockMvc.perform(get("/{query}", "Luke"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectWriter.writeValueAsString(expectedResponse)));
    }

    @Test
    void testFindWithRandomNameExpectEmptyList() throws Exception {
        List<CharacterDTO> expectedResponse = List.of();

        mockMvc.perform(get("/{query}", "RandomName"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectWriter.writeValueAsString(expectedResponse)));
    }

}
