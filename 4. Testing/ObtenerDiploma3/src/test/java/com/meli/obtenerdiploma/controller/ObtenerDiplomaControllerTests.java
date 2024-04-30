package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void analyzeResultsTestHappyPath() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                        .value("El alumno Juana ha obtenido un promedio de 7.33. Puedes mejorar."))
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore")
                        .value(7.333333333333333));

        mockMvc
                .perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 2L))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                        .value("El alumno Pedro ha obtenido un promedio de 10.00. Felicitaciones!"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore")
                        .value(10.0));

    }

    @Test
    public void analyzeScoresTestSadPath() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 80L))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description")
                        .value("El alumno con Id 80 no se encuetra registrado."));
    }
}
