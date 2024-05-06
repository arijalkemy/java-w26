package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegration {
    private StudentDTO studentDTO;
    static ObjectWriter writer;

    @MockBean
    private StudentService studentService;
    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    public static void setUpWritter(){
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
    }
    @BeforeEach
    public void setup(){
        studentDTO = new StudentDTO();
        studentDTO.setId(3L);
        studentDTO.setStudentName("Emiliano");
        studentDTO.setSubjects(new ArrayList<>());
        studentDTO.getSubjects().add(new SubjectDTO("Matematicas", 10.0));
        studentDTO.getSubjects().add(new SubjectDTO("Fisica", 8.0));
        studentDTO.getSubjects().add(new SubjectDTO("Quimica", 9.0));

        studentService.create(studentDTO);
    }

    @Test
    public void registerStudentTest() throws Exception {
        String payload = writer.writeValueAsString(studentDTO);
        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getStudentOkTest() throws Exception {

        when(studentService.read(3L)).thenReturn(studentDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 3L))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Emiliano"));
    }

    @Test
    public void modifyStudentOkTest() throws Exception{
        String payload = writer.writeValueAsString(studentDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload))
                .andDo(print())
                .andExpect(status().isOk());
        verify(studentService, times(1)).update(studentDTO);
    }

    @Test
    public void removeStudentOkTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 3L))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void listStudentsOkTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));

        verify(studentService,times(1)).getAll();
    }
}
