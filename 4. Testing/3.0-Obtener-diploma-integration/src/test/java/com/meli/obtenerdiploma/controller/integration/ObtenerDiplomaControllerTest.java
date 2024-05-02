package com.meli.obtenerdiploma.controller.integration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;

import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class ObtenerDiplomaControllerTest {

    static List<StudentDTO> students = new ArrayList<>();
    ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

    private String getGreetingMessage(String studentName, Double average) {
        return "El alumno " + studentName + " ha obtenido un promedio de " + ((average == null) ? "null" : new DecimalFormat("#0.00").format(average))
                + ((average == null) ? "" : ((average >= 9) ? ". Felicitaciones!" : ". Puedes mejorar."));
    }

    private Double calculateAverage(List<SubjectDTO> scores) {
        return scores.stream()
                .reduce(0D, (partialSum, score)  -> partialSum + score.getScore(), Double::sum)
                / scores.size();
    }

    @Autowired
    MockMvc mockMVC;

    @BeforeAll
    static void readStudents() {
        ObjectMapper mapper = new ObjectMapper();
        Properties properties = new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            String SCOPE = properties.getProperty("api.scope");

            File file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/users.json");

            students = mapper.readValue(file, new TypeReference<List<StudentDTO>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Test()
    @DisplayName("Analizar las calificaciones de los estudiantes exitosamente")
    void analyzeScoresSuccess() throws Exception {
        Long studentId =  2L;
        StudentDTO studentToAnalyzeScores = students.stream().filter(s -> s.getId().equals(studentId)).findFirst().orElse(null);

        studentToAnalyzeScores.setAverageScore(calculateAverage(studentToAnalyzeScores.getSubjects()));
        studentToAnalyzeScores.setMessage(getGreetingMessage(studentToAnalyzeScores.getStudentName(), studentToAnalyzeScores.getAverageScore()));

        StudentDTO expectedResponse = new StudentDTO(
                studentToAnalyzeScores.getId(),
                studentToAnalyzeScores.getStudentName(),
                studentToAnalyzeScores.getMessage(),
                studentToAnalyzeScores.getAverageScore(),
                studentToAnalyzeScores.getSubjects()
        );

        String expectedJSON = writer.writeValueAsString(expectedResponse);

        MvcResult response = mockMVC.perform(
                MockMvcRequestBuilders.get("/analyzeScores/{studentId}", "2"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        Assertions.assertEquals(
                expectedJSON, response.getResponse().getContentAsString(StandardCharsets.UTF_8),
                "Esperamos recibir la información del promedio del estudiante");
    }

    @Test
    @DisplayName("Analizar las calificaciones de los estudiantes falla")
    void analyzeScoresFailed() throws Exception {
        MvcResult response = mockMVC.perform(
                MockMvcRequestBuilders.get("/analyzeScores/{studentId}", "3"))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }
}

