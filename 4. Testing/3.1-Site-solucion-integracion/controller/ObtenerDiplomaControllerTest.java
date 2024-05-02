package com.meli.obtenerdiploma.integración.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void analyzeScoresTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/analyzeScores/{studentId}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.averageScore").value((7+9+6)/3))
                .andReturn();
    }

    @Test
    public void analyzeScoresTestSadPath() throws Exception {

        ErrorDTO errorDTO = new ErrorDTO("StudentNotFoundException", "El alumno con Id 3 no se encuetra registrado.");

        MvcResult mvcResult = mockMvc.perform(get("/analyzeScores/{studentId}", 3))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        ObjectWriter ow = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();


        Assertions.assertEquals(ow.writeValueAsString(errorDTO), mvcResult.getResponse().getContentAsString());

    }
}
