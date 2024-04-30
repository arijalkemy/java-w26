package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        TestUtilsGenerator.emptyUsersFile();
    }

    @Test
    void testRegisterStudentSuccessResponse() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Juan");

        ObjectWriter objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = objectWriter.writeValueAsString(studentDTO);

        MvcResult mvcResult = mockMvc
                .perform(
                        MockMvcRequestBuilders.post("/student/registerStudent")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payloadJson)
                ).andDo(print()).andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void testRegisterStudentWithEmptyName() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects(null);

        ObjectWriter objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = objectWriter.writeValueAsString(studentDTO);

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/student/registerStudent")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payloadJson)
                ).andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value("El nombre del estudiante no puede estar vacío."));
    }

    @Test
    void testRegisterStudentWithLowerCaseName() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("javier");

        ObjectWriter objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = objectWriter.writeValueAsString(studentDTO);

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/student/registerStudent")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payloadJson)
                ).andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value("El nombre del estudiante debe comenzar con mayúscula."));
    }

    @Test
    void testRegisterStudentWithLongName() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Aosfiosnfoiwdnsfoinwmefoimwofimweofmwoeknfokwdmfnowkmdfnowekfmnokwdmfokwenmfokwe");

        ObjectWriter objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = objectWriter.writeValueAsString(studentDTO);

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/student/registerStudent")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payloadJson)
                ).andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value("La longitud del nombre del estudiante no puede superar los 50 caracteres."));
    }

    @Test
    void testRegisterStudentWithoutSubjects() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Juan");
        studentDTO.setSubjects(new ArrayList<>());

        ObjectWriter objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = objectWriter.writeValueAsString(studentDTO);

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/student/registerStudent")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payloadJson)
                ).andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value("La lista de materias no puede estar vacía."));
    }

    @Test
    void testRegisterStudentWithInvalidSubjectName() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Juan");
        studentDTO.getSubjects().get(0).setName("matematica");

        ObjectWriter objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = objectWriter.writeValueAsString(studentDTO);

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/student/registerStudent")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payloadJson)
                ).andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value("El nombre de la materia debe comenzar con mayúscula."));
    }

    @Test
    void testRegisterStudentWithEmptySubjectName() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Juan");
        studentDTO.getSubjects().get(0).setName(null);

        ObjectWriter objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = objectWriter.writeValueAsString(studentDTO);

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/student/registerStudent")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payloadJson)
                ).andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value("El nombre de la materia no puede estar vacío."));
    }

    @Test
    void testRegisterStudentWithLongSubjectName() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Juan");
        studentDTO.getSubjects().get(0).setName("Asdasdasdasdasdasdasdasdasdasdd");

        ObjectWriter objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = objectWriter.writeValueAsString(studentDTO);

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/student/registerStudent")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payloadJson)
                ).andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value("La longitud del nombre de la materia no puede superar los 30 caracteres."));
    }

    @Test
    void testRegisterStudentWithNullSubjectScore() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Juan");
        studentDTO.getSubjects().get(0).setScore(null);

        ObjectWriter objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = objectWriter.writeValueAsString(studentDTO);

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/student/registerStudent")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payloadJson)
                ).andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value("La nota de la materia no puede estar vacía."));
    }

    @Test
    void testRegisterStudentWithNegativeSubjectScore() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Juan");
        studentDTO.getSubjects().get(0).setScore(-2.0);

        ObjectWriter objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = objectWriter.writeValueAsString(studentDTO);

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/student/registerStudent")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payloadJson)
                ).andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value("La nota mínima de la materia es de 0 pts."));
    }

    @Test
    void testRegisterStudentWithMaxSubjectScore() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Juan");
        studentDTO.getSubjects().get(0).setScore(11.0);

        ObjectWriter objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = objectWriter.writeValueAsString(studentDTO);

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/student/registerStudent")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payloadJson)
                ).andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value("La nota máxima de la materia es de 10 pts."));
    }
}
