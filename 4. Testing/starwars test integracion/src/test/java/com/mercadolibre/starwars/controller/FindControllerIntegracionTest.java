package com.mercadolibre.starwars.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class FindControllerIntegracionTest {
    @Autowired
    private MockMvc mockMvc;


    @Test
    @DisplayName("retornar um personagem de Star Wars")
    public void retornarPersonajeStarWars() throws Exception {
        List<CharacterDTO> characters = Arrays.asList(
                new CharacterDTO("LukeSkywalker", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77)
        );

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        String responseJson = writer.writeValueAsString(characters);


        MvcResult response =  this.mockMvc.perform(MockMvcRequestBuilders.get("/{query}", "Luke")).andDo(print())
                .andExpect(status().isOk()).andExpect(content().contentType("application/json")).andReturn();

        String responseBody = response.getResponse().getContentAsString();
        Assertions.assertEquals(responseJson, responseBody);
    }
}
