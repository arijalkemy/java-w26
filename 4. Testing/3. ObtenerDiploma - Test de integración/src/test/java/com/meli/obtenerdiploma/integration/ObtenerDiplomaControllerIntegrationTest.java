package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    StudentDTO stu;

    @BeforeEach
    public void setUp() {
        stu = new StudentDTO(
                1L,
                "Marco",
                "El alumno Marco ha obtenido un promedio de 6.00. Puedes mejorar.",
                6.0,
                List.of(
                        new SubjectDTO("Matematica", 8.0),
                        new SubjectDTO("Lengua", 6.0),
                        new SubjectDTO("Fisica", 4.0)
                )
        );

        TestUtilsGenerator.emptyUsersFile();
        TestUtilsGenerator.appendNewStudent(stu);
    }

    @Test
    public void analyzeScoresTest() throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String responseJson = writer.writeValueAsString(stu);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1L))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void analyzeScoresStudentNotFoundTest() throws Exception {
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 2L))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andReturn();

        Exception resolvedException = response.getResolvedException();

        Assertions.assertNotNull(resolvedException);
        Assertions.assertEquals(StudentNotFoundException.class, resolvedException.getClass());
    }

    @Test
    public void analyzeScoresStudentTest() throws Exception {
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1.1))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

        Exception resolvedException = response.getResolvedException();

        Assertions.assertNotNull(resolvedException);
        Assertions.assertEquals(MethodArgumentTypeMismatchException.class, resolvedException.getClass());
    }
}