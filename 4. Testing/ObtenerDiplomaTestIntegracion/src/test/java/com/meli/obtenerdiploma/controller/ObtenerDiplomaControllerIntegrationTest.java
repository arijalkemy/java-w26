package com.meli.obtenerdiploma.controller;


import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IObtenerDiplomaService service;

    @Test
    public void analyzeScoresTest() throws Exception {
        // Crear un StudentDTO de prueba
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        student.setStudentName("Test Student");
        student.setAverageScore(9.5);
        student.setMessage("El alumno Test Student ha obtenido un promedio de 9.50. Felicitaciones!");

        // Configurar Mockito para devolver el StudentDTO de prueba cuando se llame a analyzeScores() con el ID 1
        given(service.analyzeScores(1L)).willReturn(student);

        // Realizar una solicitud GET a /analyzeScores/1 y verificar que la respuesta tiene el estado HTTP 200 (OK)
        mockMvc.perform(get("/analyzeScores/{studentId}", 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
