package com.meli.obtenerdiploma.integration;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ObtenerDiplomaIntegrationTests {
    @Autowired
    MockMvc mockMvc;

    private StudentDTO studentDTO;
    private ObjectWriter writer;

    @BeforeEach
    public void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        TestUtilsGenerator.emptyUsersFile();
    }

    @Test
    public void testObtenerDiplomaDisaprovedWithValidId() throws Exception {
        studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        TestUtilsGenerator.appendNewStudent(studentDTO);
        studentDTO.setMessage("El alumno Marco ha obtenido un promedio de 6.00. Puedes mejorar.");
        studentDTO.setAverageScore(6.0);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", studentDTO.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().json(writer.writeValueAsString(studentDTO)));
    }

    @Test
    public void testObtenerDiplomaAprovedWithValidId() throws Exception {
        studentDTO = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Jorge");
        TestUtilsGenerator.appendNewStudent(studentDTO);
        studentDTO.setMessage("El alumno Jorge ha obtenido un promedio de 9.00. Felicitaciones!");
        studentDTO.setAverageScore(9.0);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", studentDTO.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().json(writer.writeValueAsString(studentDTO)));
    }

    @Test
    public void testObtenerDiplomaWithInvalidId() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("StudentNotFoundException"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El alumno con Id 1 no se encuetra registrado."));
    }
}
