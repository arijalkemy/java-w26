package com.mercadolibre.starwars.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerTestIntegration {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Busca todos los personajes que coincidan con el query")
    public void findAllCharactersByQueryExistingTest() throws Exception {
        mockMvc.perform(get("/{query}", "Darth"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("Darth Vader"))
                .andExpect(jsonPath("$[1].name").value("Darth Maul"));
    }

    @Test
    @DisplayName("Busca solo un personaje que coincida con el query")
    public void findOneCharacterByQueryExistingTest() throws Exception {
        mockMvc.perform(get("/{query}", "Luke"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("Luke Skywalker"));
    }

    @Test
    @DisplayName("Busca un personaje que no exista")
    public void findCharacterThatNotExistTest() throws Exception {
        mockMvc.perform(get("/{query}", "Ronaldo"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(0)));
    }
}
