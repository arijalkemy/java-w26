package com.mercadolibre.starwars.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerTestsIntegration {

    @Autowired
    MockMvc mockMvc;

    @DisplayName("Encontrar los personajes por una palabra clave con exito - integrador")
    @Test
    void findCharactersTestOk() throws Exception {
        ObjectMapper writter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false);
        List<CharacterDTO> characters = TestUtilsGenerator.getAllByNameContains("Luke");

        String payLoadJson = writter.writeValueAsString(characters);

        MvcResult mvcResult = mockMvc.perform(get("/{query}","Luke"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(payLoadJson, mvcResult.getResponse().getContentAsString());
    }
}
