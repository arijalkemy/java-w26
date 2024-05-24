package com.meli.obtenerdiploma.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTest {


    @Autowired
    private MockMvc mockMvc;
    /*
    * 1. Debería mostrar diploma
    * 2. Debería manejar excepciones
    * */

    @Test
    @DisplayName("Debería arrojar el análisis de un test")
    public void analyzeScoresTest() throws Exception {
        Long studentId = 1L;

        String url = String.format("/analyzeScores/%d", studentId);
        String expectedResponse = "{\"id\":1,\"studentName\":\"Anibal\",\"" +
                "message\":\"El alumno Anibal ha obtenido un promedio de 9,33. Felicitaciones!\",\"" +
                "averageScore\":9.333333333333334,\"subjects\":[{\"name\":\"Kahoot\",\"score" +
                "\":9.0},{\"name\":\"Musica\",\"score\":9.0},{\"name\":\"POO\",\"score" +
                "\":10.0}]}";

        mockMvc.perform(MockMvcRequestBuilders.get(url)
                .contentType("application/json"))
                .andDo(print())
                .andExpect(content().string(expectedResponse))
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("Debería arrojar una excepción bad request")
    public void analyzeScoresException() throws Exception {
        Long studentId = 99L;

        String url = String.format("/analyzeScores/%d", studentId);
        String expectedResponse = "{" +
                "\"name\":\"StudentNotFoundException\",\"description\":\"El alumno con Id 99 no se encuetra registrado.\"}";

        mockMvc.perform(MockMvcRequestBuilders.get(url)
                        .contentType("application/json"))
                .andDo(print())
                .andExpect(content().string(expectedResponse))
                .andExpect(status().is4xxClientError());
    }




}
