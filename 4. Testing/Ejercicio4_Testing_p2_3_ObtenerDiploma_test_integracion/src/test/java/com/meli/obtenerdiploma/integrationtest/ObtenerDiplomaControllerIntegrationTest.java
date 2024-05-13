package com.meli.obtenerdiploma.integrationtest;


import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test de integración 0001 - escenario analizar puntuaciones con id mal formado")
    void analyzeScoresbadId() throws Exception {
            Long userId = null;
            mockMvc.perform(
                            MockMvcRequestBuilders.get("/analyzeScores/{studentId}", userId)
                                    .contentType(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Test de integración 0001 - escenario analizar puntuaciones con id no asociado")
    void analyzeScoresId() throws Exception {
        Long userId = 100000L;
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/analyzeScores/{studentId}", userId)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Test de integración 0001 - escenario analizar puntuaciones con id asociado a un estudiante")
    void analyzeScores() throws Exception {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(4L);
        studentDTO.setStudentName("Andres");
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/analyzeScores/{studentId}", studentDTO.getId())
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(studentDTO.getId()))
                .andExpect(jsonPath("$.studentName").value(studentDTO.getStudentName()));
    }

}
