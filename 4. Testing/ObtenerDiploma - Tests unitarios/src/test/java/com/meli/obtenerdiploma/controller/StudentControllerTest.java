package com.meli.obtenerdiploma.controller;


import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.utils.StudentGenerator;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IStudentService service;

    static ObjectWriter objectWriter;

    static StudentDTO student;

    @BeforeEach
    void setUp() {
        objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        student = StudentGenerator.generateStudent();
    }

    @Test
    @DisplayName("registerStudent Test 200")
    void testRegisteStudent() throws Exception {
//        Arrange
        student.setId(5L);
        String studentString = objectWriter.writeValueAsString(student);
//        Act & Assert
        mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentString)
                )
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("registerStudent Test sin payload 400")
    void testRegisteStudent404() throws Exception {

//        Act & Assert
        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("registerStudent Test sin nombre 400")
    void testRegisteStudent404Nombre() throws Exception {
//        Arrange
        student.setId(5L);
        student.setStudentName("");
        String studentString = objectWriter.writeValueAsString(student);
//        Act & Assert
        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("getStudent Test 200")
    void getStudentTest() throws Exception{
//        Arrange
        when(service.read(student.getId())).thenReturn(student);
        String studentString = objectWriter.writeValueAsString(student);

//        Act & Assert
        mockMvc.perform(get("/student/getStudent/{id}", student.getId())
                .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(
                        content().json(studentString)
                    );

    }

    @Test
    @DisplayName("getStudent Test 404")
    void getStudentTest404() throws Exception{
//        Arrange
        when(service.read(student.getId())).thenThrow(StudentNotFoundException.class);

//        Act & Assert
        mockMvc.perform(get("/student/getStudent/{id}", student.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

    }

    @Test
    @DisplayName("modifyStudent Test 200")
    void modifyStudentTest() throws Exception {
//    Arrange
        student.setMessage("Mensaje");
        String studentString = objectWriter.writeValueAsString(student);
//        Act & Assert

        mockMvc.perform(post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentString))
                    .andDo(print())
                    .andExpect(status().isOk());

        verify(service).update(any(StudentDTO.class));
    }

    @Test
    @DisplayName("modifyStudent Test no payload 404")
    void modifyStudentTest404() throws Exception {
//        Act & Assert

        mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }


    @Test
    @DisplayName("modifyStudent Test Bad Student Name 404")
    void modifyStudentTest404BadName() throws Exception {
//      Ararnge
        student.setStudentName("nombreEnMinusculas");
        //        Act & Assert
        mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectWriter.writeValueAsString(student))
                )
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("removeStudent Test 200")
    void removeStudentTest() throws Exception {
//        Arrange
        student.setId(1L);

//        Act & Assert
        mockMvc.perform(get("/student/removeStudent/{id}", student.getId())
                .contentType(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk());

        verify(service).delete(student.getId());

    }

    @Test @Disabled
    @DisplayName("removeStudent Test 404")
    void removeStudentTest404() throws Exception {
//        Arrange
        student.setId(99L);

//        Act & Assert
        mockMvc.perform(get("/student/removeStudent/{id}", student.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());

        verify(service).delete(student.getId());
    }

}