package com.mercadolibre.starwars.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer;

    @BeforeEach
    public void setup(){
        writer = new ObjectMapper().findAndRegisterModules().writer();
    }

    @Test
    public void findLukeOk() throws Exception {
        //arrange
        String query = "Luk";
        List<CharacterDTO> charactersExpected = new ArrayList<>();
        charactersExpected.add(new CharacterDTO(
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

        ResultActions results = mockMvc.perform(
                MockMvcRequestBuilders.get("/{query}", query))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));

        String expected = writer.writeValueAsString(charactersExpected);
        String obtained = results.andReturn().getResponse().getContentAsString();


        Assertions.assertEquals(expected, obtained);
    }

}
