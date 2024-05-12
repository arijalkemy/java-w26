package com.meli.obtenerdiploma.integrationtest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testRegisterStudent_ValidStudent() throws Exception {
        // Arrange
        StudentDTO studentDTO = generateStudentWithScores(Arrays.asList(
                new SubjectDTO("Matemáticas", 7.0),
                new SubjectDTO("Español", 8.0),
                new SubjectDTO("Ciencias", 9.0)
        ));

        // Act
        ResultActions result = this.mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(studentDTO)));

        // Assert
        result.andExpect(status().isOk());
    }

    @Test
    void analyzeScoresTest() throws Exception {
        // Arrange
        StudentDTO studentDTO = generateStudentWithScores(Arrays.asList(
                new SubjectDTO("Matemáticas", 7.0),
                new SubjectDTO("Español", 8.0),
                new SubjectDTO("Ciencias", 9.0)
        ));

        String expectedJson = new ObjectMapper().writeValueAsString(studentDTO); // Convert dto to json

        String id = "1";
        String path = "/analyzeScores/"+id;

        this.mockMvc.perform(get(path))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expectedJson)) // Verify the expected json
                .andExpect(status().isOk());
    }

    @Test
    void testModifyStudent_ValidStudent() throws Exception {
        // Arrange
        StudentDTO studentDTO = generateStudentWithScores(Arrays.asList(
                new SubjectDTO("Matemáticas", 7.0),
                new SubjectDTO("Español", 8.0),
                new SubjectDTO("Ciencias", 9.0)
        ));

        // Act
        ResultActions result = this.mockMvc.perform(post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(studentDTO)));

        // Assert
        result.andExpect(status().isOk());
    }

    @Test
    void testRemoveStudent_ValidId() throws Exception {
        // Arrange
        Long studentId = 1L;

        // Act
        ResultActions result = this.mockMvc.perform(get("/student/removeStudent/" + studentId));

        // Assert
        result.andExpect(status().isOk());
    }
    private StudentDTO generateStudentWithScores(List<SubjectDTO> subjects) {
        return StudentDTO.builder()
                .id(1L)
                .studentName("Juan")
                .message("El alumno Juan ha obtenido un promedio de 8. Puedes mejorar.")
                .averageScore(8.0)
                .subjects(subjects)
                .build();
    }
}
