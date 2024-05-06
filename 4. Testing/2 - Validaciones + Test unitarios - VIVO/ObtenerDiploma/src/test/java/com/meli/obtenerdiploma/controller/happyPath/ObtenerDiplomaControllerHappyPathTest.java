package com.meli.obtenerdiploma.controller.happyPath;

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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ObtenerDiplomaController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerHappyPathTest {
    @MockBean
    IObtenerDiplomaService obtenerDiplomaService;

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("it should return a correct score analysis")
    public void analyzeScoreTest() throws Exception {
        // arrange
        StudentDTO student = this.createDTO();
        student.setAverageScore(this.calculateScore(student.getSubjects()));

        // act
        when(obtenerDiplomaService.analyzeScores(anyLong())).thenReturn(student);
        ResultActions result = mockMvc.perform(
                get("/analyzeScores/{studentId}", student.getId())
                .contentType(MediaType.APPLICATION_JSON)
        );

        // arrange
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.averageScore").value(student.getAverageScore()));
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
                                10.0
                        ),
                        new SubjectDTO(
                                "Graficacion",
                                9.0
                        ),
                        new SubjectDTO(
                                "Circuitos",
                                6.0
                        )
                ))
        );
    }

    public double calculateScore(List<SubjectDTO> subjects){
        return subjects.stream().mapToDouble(x -> x.getScore()).average().orElse(0.0);
    }

}
