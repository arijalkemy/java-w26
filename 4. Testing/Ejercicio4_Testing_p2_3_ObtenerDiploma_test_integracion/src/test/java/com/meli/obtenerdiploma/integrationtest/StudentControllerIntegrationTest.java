package com.meli.obtenerdiploma.integrationtest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Registrar estudiante con datos erroneos")
    public void notregisterStudent() throws Exception {
        StudentDTO studentDTO = new StudentDTO();

        ObjectWriter ow = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String jsonStudentDTO = ow.writeValueAsString(studentDTO);

        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.post("/student/registerStudent")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(jsonStudentDTO))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }

    @Test
    @DisplayName("Registrar estudiante con datos correctos")
    public void registerStudent() throws Exception {
        //Arrange: define los datos de entrada y salida necesarios para la validacion
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática", 9.0));
        subjectDTOList.add(new SubjectDTO("Física", 7.0));
        subjectDTOList.add(new SubjectDTO("Química", 6.0));
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Juan");
        studentDTO.setSubjects(subjectDTOList);
        //Act: llamado del codigo necesario para validación

        ObjectWriter ow = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String jsonStudentDTO = ow.writeValueAsString(studentDTO);

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/student/registerStudent")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(jsonStudentDTO))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Obtener un estudiante con id = 10")
    public void getStudent() throws Exception {
        //Arrange: define los datos de entrada y salida necesarios para la validacion
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Andres");

        ObjectWriter ow = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,true)
                .writer();

        mockMvc.perform(
                        MockMvcRequestBuilders.get("/student/getStudent/{id}", 4L)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value(studentDTO.getStudentName()));
    }

    @Test
    @DisplayName("Obtener un estudiante con un id = 10000 no asociado")
    public void getnotStudent() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/student/getStudent/{id}", 10000L)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Actualizar un estudiante con datos correctos")
    public void modifyStudent() throws Exception {
        //Arrange: define los datos de entrada y salida necesarios para la validacion
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática", 9.0));
        subjectDTOList.add(new SubjectDTO("Física", 7.0));
        subjectDTOList.add(new SubjectDTO("Química", 6.0));
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Juan");
            studentDTO.setId(1L);
        studentDTO.setSubjects(subjectDTOList);
        //Act: llamado del codigo necesario para validación

        ObjectWriter ow = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String jsonStudentDTO = ow.writeValueAsString(studentDTO);

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/student/modifyStudent")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(jsonStudentDTO))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Eliminar un estudiante con id no registrado")
    public void removenotStudent() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/student/removeStudent/{id}", 1L)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("Eliminar un estudiante con id registrado")
    public void removeStudent() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/student/removeStudent/{id}", 52L)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }
}
