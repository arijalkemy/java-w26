package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ObtenerDiplomaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IObtenerDiplomaService service;


    @Test
    @DisplayName("Analyze the scores integration test")
    void testAnalyzeScoreSuccessful() throws Exception {
        // arrange
        Long idStudent = 1L;
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWithId(idStudent);
        when(service.analyzeScores(idStudent)).thenReturn(studentDTO);

        // act and assert
        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", idStudent)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(studentDTO.getId()))
                .andExpect(jsonPath("$.studentName").value(studentDTO.getStudentName()))
                .andReturn();
    }

    @Test
    @DisplayName("Analyze the scores integration with Bad Request")
    void testAnalyzeScore_BadRequest() throws Exception {
        // arrange
        String idStudent = "1L";

        // act and assert
        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", idStudent)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }


}
