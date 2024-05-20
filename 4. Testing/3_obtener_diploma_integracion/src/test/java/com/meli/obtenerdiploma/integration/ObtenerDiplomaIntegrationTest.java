package com.meli.obtenerdiploma.integration;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaIntegrationTest {

    @Autowired
    private MockMvc mockMvc;


    private static ObjectWriter WRITER;
    private static final String ANALYZE_SCORES_URI = "/analyzeScores/{studentId}/";
    

    @BeforeAll
    public static void init() {
        WRITER = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @BeforeEach
    public void context() {

        TestUtilsGenerator.emptyUsersFile();
        TestUtilsGenerator.appendNewStudent(TestUtilsGenerator.getStudentWithId(1L));
        TestUtilsGenerator.appendNewStudent(TestUtilsGenerator.getStudentWithId(2L));
        TestUtilsGenerator.appendNewStudent(TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Over 9"));

    }

    @AfterAll
    public static void close(){
        TestUtilsGenerator.emptyUsersFile();
    }

    @Test
    void giveNotExistingId_whenAnalyzeScores_thenNotFound() throws Exception {
        int notExisting = Integer.MAX_VALUE;
        mockMvc.perform(MockMvcRequestBuilders.get(ANALYZE_SCORES_URI, notExisting)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());

    }

    @Test
    void giveScoreOverNine_whenAnalyzeScroes_thenOkMesaggeFelicitaciones() throws Exception{
        StudentDTO expected = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Over 9");

        mockMvc.perform(MockMvcRequestBuilders.get(ANALYZE_SCORES_URI, expected.getId())
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("El alumno Over 9 ha obtenido un promedio de 9.00. Felicitaciones!"));
    }

    @Test
    void giveScoreUnderNine_whenAnalyzeScroes_thenOkMesaggeFelicitaciones() throws Exception{
        StudentDTO expected = TestUtilsGenerator.getStudentWithId(1l);

        mockMvc.perform(MockMvcRequestBuilders.get(ANALYZE_SCORES_URI, expected.getId())
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("El alumno Student 1 ha obtenido un promedio de 6.00. Puedes mejorar."));
    }

}
