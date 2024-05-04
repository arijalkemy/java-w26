package com.meli.obtenerdiploma.integration;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class StudentControllerIntegrationTests {
    @Autowired
    private MockMvc mockMvc;

    private StudentDTO stu;
    private ObjectWriter writer;
    private String payloadJSON;

    @BeforeEach
    public void setUp() throws JsonProcessingException {
        stu = new StudentDTO(
                9999L,
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
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

       payloadJSON = writer.writeValueAsString(stu);
    }

    @Test
    public void testRegisterStudent() throws Exception{

        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Assertions.assertEquals(200, response.getResponse().getStatus());
    }

    @Test
    public void testRegisterInValidStudent() throws Exception {
        StudentDTO invalidStudent = new StudentDTO();
        invalidStudent.setStudentName("");
        String invalidStudentJson = new ObjectMapper().writeValueAsString(invalidStudent);

        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidStudentJson))
                        .andReturn();

        Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), response.getResponse().getStatus());

        ErrorDTO errorResponse = new ObjectMapper().readValue(response.getResponse().getContentAsString(), ErrorDTO.class);
        Assertions.assertEquals("MethodArgumentNotValidException", errorResponse.getName());
    }

    @Test
    public void testRegisterStudentNotRedeable() throws Exception {
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content("invalidJson"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
        ErrorDTO errorResponse = new ObjectMapper().readValue(response.getResponse().getContentAsString(), ErrorDTO.class);
        Assertions.assertEquals("HttpMessageNotReadableException", errorResponse.getName());
    }


    @Test
    public void testGetStudent() throws Exception {
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 9999L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        String json = writer.writeValueAsString(stu);
        Assertions.assertEquals(json, response.getResponse().getContentAsString());
    }

    @Test
    public void testGetStudentBadRequest() throws Exception {
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", "9999L"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
        Assertions.assertEquals(MethodArgumentTypeMismatchException.class, response.getResolvedException().getClass());
    }

    @Test
    public void testGetStudentNotFound() throws Exception {
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 9934L))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andReturn();
        Assertions.assertEquals(StudentNotFoundException.class, response.getResolvedException().getClass());
    }

    @Test
    public void testModifyStudent() throws Exception {
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        Assertions.assertEquals(200, response.getResponse().getStatus());
    }

    @Test
    public void testRemoveStudent() throws Exception {
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 9999L))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        Assertions.assertEquals(200, response.getResponse().getStatus());
    }

    @Test
    public void testListStudents() throws Exception {
        Set<StudentDTO> students = new HashSet<>();
        students.add(stu);
        String studentsJSON = writer.writeValueAsString(students);

        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        Assertions.assertEquals(studentsJSON, response.getResponse().getContentAsString());
    }
}
