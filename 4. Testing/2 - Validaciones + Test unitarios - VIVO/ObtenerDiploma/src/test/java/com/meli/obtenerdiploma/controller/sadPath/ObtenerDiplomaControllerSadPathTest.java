package com.meli.obtenerdiploma.controller.sadPath;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ObtenerDiplomaController.class)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerSadPathTest {
    @MockBean
    IObtenerDiplomaService obtenerDiplomaService;

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("it should return a score with negative values")
    public void analyzeScoreNegativityValidation() throws Exception{
        // arrange
        StudentDTO studentExpected = this.createDTO();
        studentExpected.setAverageScore(this.calculateScore(studentExpected.getSubjects()));

        // act
        when(obtenerDiplomaService.analyzeScores(anyLong())).thenReturn(studentExpected);
        ResultActions result = mockMvc
                .perform(get("/analyzeScores/{studentId}", studentExpected.getId())
                .contentType(MediaType.APPLICATION_JSON)
                );

        // assert
        result
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.averageScore").value(studentExpected.getAverageScore()));

    }

    @Test
    @DisplayName("it should return a error of StudentNotFound")
    public void analyzeScoreNegativityStudentNotFound() throws Exception{
        // arrange & act
        when(obtenerDiplomaService.analyzeScores(anyLong())).thenReturn(null);
        ResultActions result = mockMvc.perform(
                get("/analyzeScores/{studentId}", anyLong())
                .contentType(MediaType.APPLICATION_JSON)
        );

        // assert
        result.andExpect(jsonPath("$").doesNotExist());
    }

    public StudentDTO createDTO(){
        return new StudentDTO(
                1L,
                "Jose",
                "",
                0.0,
                new ArrayList<SubjectDTO>(Arrays.asList(
                        new SubjectDTO(
                                "Fisica",
                                -5.0
                        ),
                        new SubjectDTO(
                                "Graficacion",
                                -12.0
                        ),
                        new SubjectDTO(
                                "Circuitos",
                                -12.0
                        )
                ))
        );
    }
    public double calculateScore(List<SubjectDTO> subjects){
        return subjects.stream().mapToDouble(x -> x.getScore()).average().orElse(0.0);
    }
}
