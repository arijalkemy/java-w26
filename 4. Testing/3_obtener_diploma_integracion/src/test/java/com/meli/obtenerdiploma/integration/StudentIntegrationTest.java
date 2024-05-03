package com.meli.obtenerdiploma.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentIntegrationTest {

    private static ObjectWriter WRITER;

    @Autowired
    private MockMvc mockMvc;

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

    @Test
    void postStudent_test() throws Exception {
        StudentDTO dto = TestUtilsGenerator.getStudentWith3Subjects("Leo");

        String json = WRITER.writeValueAsString(dto);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void postStudentWhitoutName_test() throws Exception {
        StudentDTO dto = TestUtilsGenerator.getStudentWith3Subjects(null);
        String json = WRITER.writeValueAsString(dto);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.description").value("El nombre del estudiante no puede estar vacío."));

    }

    @Test
    void postStudentWhithNameNoCapitalzie_test() throws Exception {
        StudentDTO dto = TestUtilsGenerator.getStudentWith3Subjects("leo");
        String json = WRITER.writeValueAsString(dto);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.description").value("El nombre del estudiante debe comenzar con mayúscula."));

    }

    @Test
    void postStudentWhithNameUp50Chars() throws Exception {
        StudentDTO dto = TestUtilsGenerator.getStudentWith3Subjects("Leo".repeat(50));
        String json = WRITER.writeValueAsString(dto);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.description")
                        .value("La longitud del nombre del estudiante no puede superar los 50 caracteres."));

    }

    @Test
    void postStudentWithoutSubjects_test() throws Exception {
        StudentDTO dto = TestUtilsGenerator.getStudentWith3Subjects("Leo");
        dto.setSubjects(null);
        String json = WRITER.writeValueAsString(dto);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.description").value("La lista de materias no puede estar vacía."));

    }

    @Test
    void giveExistingId_whenGetStudent_resultStudentDto() throws Exception {
        StudentDTO expected = TestUtilsGenerator.getStudentWithId(1L);
        String expectedJson = WRITER.writeValueAsString(expected);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", expected.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        result.getResponse()
                .setCharacterEncoding("UTF-8");

        assertEquals(expectedJson, result.getResponse().getContentAsString());
    }

    @Test
    void giveNotExistingId_whenGetStudent_resultNotFound() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", -10L)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.description").value("El alumno con Id -10 no se encuetra registrado."));
    }

    @Test
    void giveStudent_whenUpdate_resultOk_test() throws Exception {

        StudentDTO dto = TestUtilsGenerator.getStudentWith3Subjects("Leo");

        String json = WRITER.writeValueAsString(dto);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(status().isOk());

    }

}
