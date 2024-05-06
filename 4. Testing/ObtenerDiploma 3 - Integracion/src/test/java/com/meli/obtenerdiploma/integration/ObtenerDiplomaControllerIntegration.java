package com.meli.obtenerdiploma.integration;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegration {
    private StudentDTO studentDTO;
    @MockBean
    private ObtenerDiplomaService obtenerDiplomaService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup(){
        studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Emiliano");
        studentDTO.setAverageScore(6.0);
    }

    @Test
    public void analyzeScoresOkTest() throws Exception{
        when(obtenerDiplomaService.analyzeScores(9999L)).thenReturn(studentDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 9999L))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName")
                        .value(studentDTO.getStudentName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore")
                        .value(studentDTO.getAverageScore()));
    }
}
