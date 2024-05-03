package com.meli.obtenerdiploma.Integration.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaIntegrationTest {

    @Autowired
    MockMvc mockMvc;
    
    @Test
    void analizeScoreOfExistingStudent() throws Exception{

        Long id = 1L;

        this.mockMvc
            .perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", id))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id));
    }

    @Test
    void analizeScoreOfNotExistingStudent() throws Exception{

        Long id = Long.MAX_VALUE;

        this.mockMvc
            .perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", id))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isNotFound());
            
    }
}
