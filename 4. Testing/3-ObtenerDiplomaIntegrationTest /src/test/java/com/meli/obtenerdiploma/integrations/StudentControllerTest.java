package com.meli.obtenerdiploma.integrations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Mock
    IStudentService service;

    @InjectMocks
    StudentController controller;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void getStudentTest() throws Exception {
        long id = 2;
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{studentId}", id))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id" )
                        .value(id))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName" )
                        .value("Juan")).andReturn();
    }

    @Test
    public void getStudentInvalidIDTest() throws Exception {
        long id = 50;
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{studentId}", id))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description" )
                        .value("El alumno con Id " + id + " no se encuetra registrado.")).andReturn();
    }

    @Test
    public void registerStudentTest() throws Exception {

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(50L);
        studentDTO.setStudentName("Juan");

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matemática", 9.0));
        subjects.add(new SubjectDTO("Física", 7.0));
        subjects.add(new SubjectDTO("Química", 6.0));
        studentDTO.setSubjects(subjects);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String payload = writer.writeValueAsString(studentDTO);
        String response = writer.writeValueAsString(studentDTO);

        MvcResult mvcResponse = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/")
                        .contentType(MediaType.APPLICATION_JSON).content(payload))
                .andExpect(status().isOk())
                .andReturn();

    }

    @Test
    void registerStudentNameNullReturnsBadRequest() throws Exception {
        StudentDTO stu = TestUtilsGenerator.getStudentWithId(1L);
        stu.setStudentName("");

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String payload = writer.writeValueAsString(stu);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                        .andExpect(MockMvcResultMatchers.status().isBadRequest());

    }
    @Test
    void registerStudentSend1ToPayloadReturnsBadRequest() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("1"))
                        .andExpect(MockMvcResultMatchers.status().isBadRequest());

    }
}
