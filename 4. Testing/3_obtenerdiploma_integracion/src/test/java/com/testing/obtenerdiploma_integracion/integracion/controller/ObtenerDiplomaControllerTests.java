package com.testing.obtenerdiploma_integracion.integracion.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void analyzeScoresByExistingStudent() throws Exception {
        MvcResult result = this.mockMvc
                .perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",1))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value((7+9+6)/3))
                .andReturn();

        System.out.println("Result: " + result.getResponse().getContentAsString());
    }

    @Test
    public void analyzeScoresByNotExistingStudent() throws Exception {
        MvcResult result = this.mockMvc
                .perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",0))
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andReturn();

        System.out.println("Result: " + result.getResponse().getContentAsString());
    }

}
