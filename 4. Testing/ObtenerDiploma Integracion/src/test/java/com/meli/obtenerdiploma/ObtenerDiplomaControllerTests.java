package com.meli.obtenerdiploma;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAnalyzeScoresOk() throws Exception {
        mockMvc.perform(get("/analyzeScores/{studentId}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                        .value("El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar."))
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore")
                        .value(7.333333333333333));
    }

    @Test
    public void testAnalyzeScoresNotFound() throws Exception {
        mockMvc.perform(get("/analyzeScores/{studentId}", 100))
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description")
                        .value("El alumno con Id 100 no se encuetra registrado."));
    }

}
