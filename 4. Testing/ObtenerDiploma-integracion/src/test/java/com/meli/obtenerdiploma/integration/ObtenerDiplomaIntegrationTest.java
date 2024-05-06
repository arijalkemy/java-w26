package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    private static ObjectWriter writer;
    private static final String ANALYZE_SCORES = "/analyzeScores/{studentId}";

    @BeforeAll
    public static void init() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @BeforeEach
    public void setUp() {
        TestUtilsGenerator.emptyUsersFile();
        TestUtilsGenerator.appendNewStudent(TestUtilsGenerator.getStudentWithId(1L));
        TestUtilsGenerator.appendNewStudent(TestUtilsGenerator.getStudentWithId(2L));
        TestUtilsGenerator.appendNewStudent(TestUtilsGenerator.getStudentWithId(3L));
        TestUtilsGenerator.appendNewStudent(
                TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("over 9"));
    }

    @Test
    public void NotExistingId() throws Exception {
        int id = Integer.MAX_VALUE;
        mockMvc.perform(MockMvcRequestBuilders.get(ANALYZE_SCORES, id)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void scoreOver9MessageCongratulations() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("over 9");

        double d = 9.00;
        mockMvc.perform(MockMvcRequestBuilders.get(ANALYZE_SCORES, studentDTO.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value(
                        "El alumno over 9 ha obtenido un promedio de 9,00. Felicitaciones!"));
    }


}
