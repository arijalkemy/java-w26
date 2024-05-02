package com.meli.obtenerdiploma.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegration {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Se obtiene el diploma del estudiante con ID = 1")
    public void analyzeScoresSuccessfully() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(
                        jsonPath("$.message")
                        .value("El alumno Juan Perez ha obtenido un promedio de 9,00. Felicitaciones!")
                );
    }

    @Test
    @DisplayName("Se busca obtener el diploma de un alumno existente y lanza excepcion")
    public void analyzeScoresThrowsStudentNotFoundException() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 7))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));
    }


}
