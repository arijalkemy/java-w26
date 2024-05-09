package com.mercadolibre.starwars.controller.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FindIntegrationTests {


    @Autowired
    MockMvc mockMvc;

    @Test
    void find_validQuery() throws Exception {
        // Arrange
        String query = "Luke";
        // Act
        mockMvc.perform(MockMvcRequestBuilders.get("/" + query))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("Luke Skywalker"))
                .andExpect(jsonPath("$[0].height").value("172"))
                .andExpect(jsonPath("$[0].mass").value("77"))
                .andExpect(jsonPath("$[0].hair_color").value("blond"));

    }
}
