package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc

public class StudentIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    private static ObjectWriter writer;
    public static final String STUDENT_URI = "/student";

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
    public void postRegisterStudentTest() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Marcela");
        String json = writer.writeValueAsString(studentDTO);
        mockMvc.perform(MockMvcRequestBuilders.post(STUDENT_URI + "/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void postRegisterStudentWithoutNameTest() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects(null);
        String json = writer.writeValueAsString(studentDTO);
        mockMvc.perform(MockMvcRequestBuilders.post(STUDENT_URI + "/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.description")
                        .value("El nombre del estudiante no puede estar vacio."));
    }

    @Test
    public void postRegisterStudentNameNotCapitalizedTest() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("agustina");
        String json = writer.writeValueAsString(studentDTO);
        mockMvc.perform(MockMvcRequestBuilders.post(STUDENT_URI + "/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.description")
                        .value("El nombre del estudiante debe comenzar con mayúscula."));
    }

    @Test
    public void postRegisterStudentNameMaxLengthTest() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Florencia".repeat(50));
        String json = writer.writeValueAsString(studentDTO);
        mockMvc.perform(MockMvcRequestBuilders.post(STUDENT_URI + "/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.description")
                        .value("La longitud del nombre del estudiante no puede superar los 50 caracteres."));
    }

    @Test
    public void postRegisterStudentWithEmptySubjectsTest() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Florencia");
        studentDTO.setSubjects(null);
        String json = writer.writeValueAsString(studentDTO);
        mockMvc.perform(MockMvcRequestBuilders.post(STUDENT_URI + "/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.description")
                        .value("La lista de materias no puede estar vacía."));
    }

    @Test
    public void postRegisterStudentWithExistingId() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWithId(1L);
        String json = writer.writeValueAsString(studentDTO);
        MvcResult result=  mockMvc.perform(MockMvcRequestBuilders.get(STUDENT_URI + "/getStudent/{id}",studentDTO.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        result.getResponse().setCharacterEncoding("UTF-8");
        Assertions.assertEquals(json, result.getResponse().getContentAsString());

    }


}
