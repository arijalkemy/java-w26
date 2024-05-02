package com.testing.obtenerdiploma_integracion.integracion.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.testing.obtenerdiploma_integracion.model.StudentDTO;
import com.testing.obtenerdiploma_integracion.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    private static ObjectMapper writer;

    @Autowired
    MockMvc mockMvc;

    public StudentControllerTest() {
        StudentControllerTest.writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false);
    }

    // Student Creation tests ---------------------
    @Test
    void registerCorrectStudentTest() throws Exception {

        StudentDTO studentDTO =
                new StudentDTO(3L, "Juan", null, null, List.of(
                        new SubjectDTO("Matematicas", 9.0),
                        new SubjectDTO("Fisica", 6.0),
                        new SubjectDTO("ASDASDASD", 7.0)
                ));

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(studentDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""))
                .andReturn();
    }

    @Test
    void registerIncorrectStudentTest() throws Exception {

        StudentDTO studentDTO =
                new StudentDTO(3L, null, null, null, List.of(
                        new SubjectDTO("Matematicas", 9.0),
                        new SubjectDTO("Fisica", 6.0),
                        new SubjectDTO("ASDASDASD", 7.0)
                ));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(studentDTO)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("name").value("MethodArgumentNotValidException"))
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    void registerIncorrectStudentSubjectsTest() throws Exception {

        StudentDTO studentDTO =
                new StudentDTO(3L, "Juan", null, null, List.of(
                        new SubjectDTO("Matematicas", null),
                        new SubjectDTO("Fisica", 6.0),
                        new SubjectDTO("ASDASDASD", 7.0)
                ));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(studentDTO)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("name").value("MethodArgumentNotValidException"))
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    void registerIncorrectStudentSubjectsEmptyTest() throws Exception {

        StudentDTO studentDTO =
                new StudentDTO(3L, "Juan", null, null, List.of());


        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(studentDTO)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("name").value("MethodArgumentNotValidException"))
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    void registerIncorrectRequestStudent() throws Exception {

        StudentDTO studentDTO =
                new StudentDTO(3L, "Juan", null, null, List.of());


        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(studentDTO).substring(0,10)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("name").value("HttpMessageNotReadableException"))
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    // --------------------------------------------

    // Get student tests ---------------------
    @Test
    void getCorrectStudent() throws Exception {

        StudentDTO studentDTO =
                new StudentDTO(1L, "Juan", null, null, List.of(
                        new SubjectDTO("Matematicas", 9.0),
                        new SubjectDTO("Fisica", 6.0),
                        new SubjectDTO("ASDASDASD", 7.0)
                ));

        String studentDTOJson = writer.writeValueAsString(studentDTO);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",1L))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        System.out.println(studentDTOJson);
        System.out.println(result.getResponse().getContentAsString());
        Assertions.assertEquals(studentDTOJson, result.getResponse().getContentAsString());
    }

    @Test
    void getIncorrectStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",10L))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andReturn();
    }

    @Test
    void getStudentsList() throws Exception {

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());

    }


}
