package com.meli.obtenerdiploma.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ObtenerDiplomaControllerIntegrationTests {
    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;
    private static ObjectMapper mapper;


    @BeforeAll
    public static void setUpBeforeAll() {
        writer = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();

        mapper = new ObjectMapper();
    }

    @Test
    public void analyzeScoresOk() throws Exception {
        TestUtilsGenerator.emptyUsersFile();
        TestUtilsGenerator.loadData(TestUtilsGenerator.getStudents());

        MvcResult result = this.mockMvc
            .perform(get("/analyzeScores/{studentId}", 1L))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andReturn();
    }

    @Test
    public void analyzeScoresErrorPathVariable() throws Exception {
        TestUtilsGenerator.emptyUsersFile();
        TestUtilsGenerator.loadData(TestUtilsGenerator.getStudents());

        this.mockMvc
            .perform(get("/analyzeScores/{studentId}", "Error Path Variable"))
            .andDo(print())
            .andExpect(status().isBadRequest());
    }
}
