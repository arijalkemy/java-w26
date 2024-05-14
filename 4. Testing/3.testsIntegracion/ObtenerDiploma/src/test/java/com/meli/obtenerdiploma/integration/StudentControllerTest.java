package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    StudentDAO  studentDAO;

    private static ObjectWriter objectWriter;

    @Autowired
    private ObjectMapper objectMapper;



    private StudentDTO studentDTO;
    private SubjectDTO maths;
    private SubjectDTO english;
    private SubjectDTO french;

    @BeforeEach
    void setUp() {
        maths = new SubjectDTO("Maths", 8.0);
        english = new SubjectDTO("English", 8.0);
        french = new SubjectDTO("French", 8.0);

        List<SubjectDTO> subjects = new ArrayList<>();

        subjects.add(english);
        subjects.add(french);
        subjects.add(maths);

        studentDTO = new StudentDTO(1L,"Pedro","message", 8.0, subjects);
        studentDAO.save(studentDTO);

        objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    @DisplayName("Register Student Test")
    void testRegisterStudent() throws Exception {
        //Act
        ResultActions results = mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectWriter.writeValueAsString(studentDTO)))
                .andDo(print())
                //ASSERT
                .andExpect(status().isOk()
                );
    }

    @Test
    @DisplayName("Get Student Test")
    void testGetStudent() throws Exception {

        ResultActions results = mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/1"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());

        //Asserts
        String resultString = results.andReturn().getResponse().getContentAsString();
        String expectedString = objectMapper.writeValueAsString(studentDTO);

        Assertions.assertEquals(expectedString, resultString);
    }

    @Test
    @DisplayName("Get Student Test When ID Does Not Exist")
    void testGetStudentWhenIdDoesNotExist() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 22))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));
    }

    @Test
    @DisplayName("Remove Student Test")
    void testRemoveStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("List Students Test")
    void testListStudents() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }
}
