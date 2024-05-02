package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.assertj.core.internal.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void obtenerDiplomaControllerOk() throws Exception{
        //Arrange
        long id = 1;
        String studentName = "Juan";
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matemática", 9.0));
        subjects.add(new SubjectDTO("Física", 7.0));
        subjects.add(new SubjectDTO("Química", 6.0));

        StudentDTO student = new StudentDTO(id, studentName,
                "El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.",
                7.333333333333333,
                subjects);
        String expectedJsonResponse = objectMapper.writeValueAsString(student);

        // Act
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andReturn();
        // Assert
        assertEquals(expectedJsonResponse, mvcResult.getResponse().getContentAsString());

    }

}
