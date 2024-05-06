package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.Arrays;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ObtenerDiplomaIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    public void setUp(){
        TestUtilsGenerator.writeUsersFile();
    }

    @Test
    public void AnalizeScoresTest() throws Exception {
        StudentDTO studentDTO1 = new StudentDTO();
        studentDTO1.setId(1L);
        studentDTO1.setStudentName("Juan");
        studentDTO1.setAverageScore(7.333333333333333);
        studentDTO1.setSubjects(Arrays.asList(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física",7.0),
                new SubjectDTO("Química",6.0)));
        studentDTO1.setMessage("El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String json = writer.writeValueAsString(studentDTO1);

        MvcResult mvcResult = (MvcResult) this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/analyzeScores/{studentId}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(writer.writeValueAsString(studentDTO1)))
                .andReturn();
    }

}
