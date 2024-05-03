package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.IOException;
import java.util.List;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    static ObjectWriter objectWriter;

    @BeforeAll
    static void setup() {
        objectWriter = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
    }

    @BeforeEach
    void tearDown() throws IOException {
        TestUtilsGenerator.emptyUsersFile();
    }


    @Test
    @DisplayName("Test analyzeScores with average lower than 9 - Success")
    void testAnalyzeScoresSuccess() throws Exception {

        StudentDTO studentInputDTO = new StudentDTO();
        studentInputDTO.setId(1L);
        studentInputDTO.setStudentName("Test");
        List<SubjectDTO> subjectDTOList = List.of(
                new SubjectDTO("Math", 10D), new SubjectDTO("Science", 6D)
        );

        studentInputDTO.setSubjects(subjectDTOList);

        mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.valueOf("application/json"))
                .content(objectWriter.writeValueAsString(studentInputDTO)))
                .andExpect(status().isOk())
                .andReturn();

        MvcResult mvcResult =  mockMvc.perform(get("/analyzeScores/{studentId}", 1))
                .andExpect(status().isOk())
                .andReturn();

        String response = mvcResult.getResponse().getContentAsString();

        StudentDTO studentResponseDTO = studentInputDTO;

        studentResponseDTO.setAverageScore(8D);
        studentResponseDTO.setMessage(
                "El alumno Test ha obtenido un promedio de 8,00. Puedes mejorar."
        );

        StudentDTO resultDto = new ObjectMapper().readValue(response, StudentDTO.class);

        Assertions.assertEquals(studentResponseDTO, resultDto);
    }

    @Test
    @DisplayName("Test analyzeScores with average greater than 9 - Success")
    void testAnalyzeScoresSuccess2() throws Exception {
        StudentDTO studentInputDTO = new StudentDTO();
        studentInputDTO.setId(1L);
        studentInputDTO.setStudentName("Test");
        List<SubjectDTO> subjectDTOList = List.of(
                new SubjectDTO("Math", 10D), new SubjectDTO("Science", 10D)
        );

        studentInputDTO.setSubjects(subjectDTOList);

        mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.valueOf("application/json"))
                .content(objectWriter.writeValueAsString(studentInputDTO)))
                .andExpect(status().isOk())
                .andReturn();

        MvcResult mvcResult =  mockMvc.perform(get("/analyzeScores/{studentId}", 1))
                .andExpect(status().isOk())
                .andReturn();

        String response = mvcResult.getResponse().getContentAsString();

        StudentDTO studentResponseDTO = studentInputDTO;

        studentResponseDTO.setAverageScore(10D);
        studentResponseDTO.setMessage(
                "El alumno Test ha obtenido un promedio de 10,00. Felicitaciones!"
        );

        StudentDTO resultDto = new ObjectMapper().readValue(response, StudentDTO.class);

        Assertions.assertEquals(studentResponseDTO, resultDto);
    }

    @Test
    @DisplayName("Test analyzeScores with an unknow student - Error")
    void testAnalyzeScoresError() throws Exception {
        mockMvc.perform(get("/analyzeScores/{studentId}", 1))
                .andExpect(status().isNotFound())
                .andReturn();
    }
}
