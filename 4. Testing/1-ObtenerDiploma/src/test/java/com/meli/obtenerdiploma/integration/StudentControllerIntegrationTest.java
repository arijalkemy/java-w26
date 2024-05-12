package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectWriter writer;
    @Autowired
    private StudentDAO studentDAO;
    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    public void setUp() {
        this.writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer()
                .withDefaultPrettyPrinter();
    }

    @Test
    public void testRegisterStudent() throws Exception {
        //String studentJson = "{\"id\": 1, \"studentName\": \"John Doe\", \"subjects\": []}";
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Math", 9.5));
        subjects.add(new SubjectDTO("History", 8.0));

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("John Doe");
        studentDTO.setMessage(null);
        studentDTO.setAverageScore(null);
        studentDTO.setSubjects(subjects);

        String payloadJson = writer.writeValueAsString(studentDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .content(payloadJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().string(""));

    }

    @Test
    public void testGetStudent() throws Exception {
        Set<StudentDTO> studentDTOS= studentRepository.findAll();
        List<StudentDTO> studentList = new ArrayList<>(studentDTOS);
        StudentDTO studentDTO = studentList.get(0);

        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", studentDTO.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(studentDTO.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value(studentDTO.getStudentName()));
    }

    @Test
    public void testModifyStudent() throws Exception {
        Set<StudentDTO> studentDTOS= studentRepository.findAll();
        List<StudentDTO> studentList = new ArrayList<>(studentDTOS);
        StudentDTO studentDTO = studentList.get(0);

        String payloadJson = writer.writeValueAsString(studentDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .content(payloadJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testRemoveStudent() throws Exception {
        Set<StudentDTO> studentDTOS= studentRepository.findAll();
        List<StudentDTO> studentList = new ArrayList<>(studentDTOS);
        StudentDTO studentDTO = studentList.get(0);
        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", studentDTO.getId()))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testListStudents() throws Exception {
        Set<StudentDTO> studentDTOS= studentRepository.findAll();
        List<StudentDTO> studentList = new ArrayList<>(studentDTOS);
        mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(studentList.size()));
    }
}
