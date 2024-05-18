package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashSet;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentContollerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    StudentDTO stu;
    ObjectWriter writer;

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

        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        TestUtilsGenerator.emptyUsersFile();
        TestUtilsGenerator.appendNewStudent(stu);
    }

    @Test
    public void registerNewStudentTest() throws Exception {
        stu.setMessage(null);
        stu.setAverageScore(null);

        String payloadJson = writer.writeValueAsString(stu);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void getStudentTest() throws Exception {
        String responseJson = writer.writeValueAsString(stu);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 1L))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void modifyStudentTest() throws Exception {
        String payloadJson = writer.writeValueAsString(stu);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void deleteStudentTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 1L))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void getAllStudentsTest() throws Exception {
        HashSet<StudentDTO> students = new HashSet<>(){{ add(stu); }};
        String responseJson = writer.writeValueAsString(students);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void testRegisterInValidStudent() throws Exception {
        ErrorDTO errorDTO = new ErrorDTO("MethodArgumentNotValidException", "El nombre del estudiante no puede estar vacÃ\u00ADo.");
        String responseJson = writer.writeValueAsString(errorDTO);

        stu.setStudentName(null);
        String invalidStudentJson = writer.writeValueAsString(stu);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidStudentJson))
                .andExpect(status().isBadRequest())
                .andReturn();

        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void testRegisterStudentNotReadable() throws Exception {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setName("HttpMessageNotReadableException");

        String invalidStudentJson = "";

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidStudentJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(errorDTO.getName()))
                .andReturn();
    }
}