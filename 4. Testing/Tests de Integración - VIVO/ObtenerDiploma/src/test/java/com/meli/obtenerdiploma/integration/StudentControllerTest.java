package com.meli.obtenerdiploma.integration;



import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.FileNotFoundException;
import java.nio.charset.Charset;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.KeeperState;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;

import lombok.extern.java.Log;

@Log
@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    
    @BeforeEach
    private void setUp() throws FileNotFoundException {
        KeeperState.copySnapShoot("users.json");
    }

    @AfterEach
    private void tearDown() {
        KeeperState.redoSnapShoot();
    }
    
    /**
     * Register student
     * 1. All Valid OK
     * 2. Not Body OK
     * 3. Student Exist OK
     * 4. Fail in @Valid
     * @throws Exception 
     */

    
    @Test
    @DisplayName("Test to register Student when Body is Valid")
    public void rightRegisterStudentTest() throws Exception {
        //Arrange
        StudentDTO     newStudentDTO = TestUtilsGenerator.getNewStudent();
        String         content       = new ObjectMapper().writeValueAsString(newStudentDTO);
        RequestBuilder request       = MockMvcRequestBuilders.post("/student/registerStudent")
                                       .contentType(MediaType.APPLICATION_JSON)
                                       .content(content);

        //Act
        ResultActions response = mockMvc.perform(request);
        response.andDo(MockMvcResultHandlers.print());
        //Assertions
        response.andExpect(MockMvcResultMatchers.status().isOk());
        Assertions.assertTrue(response.andReturn().getResponse().getContentAsString().isEmpty());
    }

    @Test
    @DisplayName("Test to register Student already exists")
    public void registerAlreadyExistsStudentTest() throws Exception {
        //Arrange
        StudentDTO     newStudentDTO = TestUtilsGenerator.getFirstStudent();
        String         content       = new ObjectMapper().writeValueAsString(newStudentDTO);
        log.info("Contenido: " + content);
        RequestBuilder request       = MockMvcRequestBuilders.post("/student/registerStudent")
                                       .contentType(MediaType.APPLICATION_JSON)
                                       .content(content);

        //Act
        ResultActions response = mockMvc.perform(request);
        response.andDo(MockMvcResultHandlers.print());
        //Assertions
        response.andExpect(MockMvcResultMatchers.status().isBadRequest());
    }


    @Test
    @DisplayName("Test to register Student without send a body")
    public void badRequestRegisterStudentTest() throws Exception {
        
        //Arrange
        RequestBuilder request = MockMvcRequestBuilders.post("/student/registerStudent")
                                 .contentType(MediaType.APPLICATION_JSON);

        //Act
        ResultActions response = mockMvc.perform(request);
        response.andDo(MockMvcResultHandlers.print());

        //Assertions
        response.andExpect(MockMvcResultMatchers.status().isBadRequest());
        response.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("HttpMessageNotReadableException"));
    }


    @Test
    @DisplayName("Test to register Student with a body not valid")
    public void badRequestByNotValidBodyTest() throws Exception {
        StudentDTO student = TestUtilsGenerator.getNewStudent();
        student.setStudentName(null);
        String content = new ObjectMapper().writeValueAsString(student);
        //Arrange
        RequestBuilder request = MockMvcRequestBuilders.post("/student/registerStudent")
                                 .contentType(MediaType.APPLICATION_JSON)
                                 .content(content);

        //Act
        ResultActions response = mockMvc.perform(request);
        response.andDo(MockMvcResultHandlers.print());

        //Assertions
        response.andExpect(MockMvcResultMatchers.status().isBadRequest());
        response.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    @DisplayName("Test to get all Students registered")
    public void getAllStudentTest() throws Exception {
        //Arrange

        RequestBuilder request = MockMvcRequestBuilders.get("/student/listStudents").accept(MediaType.APPLICATION_JSON);

        //Act

        ResultActions response = mockMvc.perform(request);
        response.andDo(print());
        //Assertions

        response.andExpect(status().isOk());
        Assertions.assertFalse(response.andReturn().getResponse().getContentAsString(Charset.forName("utf-8")).isEmpty());
    }

    @Test
    @DisplayName("Test to get Student by ID long")
    public void getByIdTest() throws Exception {
        //Util
        ObjectMapper objectMapper = new ObjectMapper();

        //Arrange
        Long idStudent = 1L;
        StudentDTO studentExpected = TestUtilsGenerator.getFirstStudentNotCalculated();

        RequestBuilder request = MockMvcRequestBuilders.get("/student/getStudent/{idStudent}", idStudent).accept(MediaType.APPLICATION_JSON);
        
        //Act
        ResultActions response = mockMvc.perform(request);

        response.andDo(print());

        //Assertions
        response.andExpect(status().isOk());


        String studentResponseStr = response.andReturn().getResponse().getContentAsString(Charset.forName("utf-8"));
        StudentDTO studentResponse =  objectMapper.readValue(studentResponseStr, StudentDTO.class);
        Assertions.assertEquals(studentExpected, studentResponse);
    }

    
    @Test
    @DisplayName("Test to remove existent Student")
    public void removeStudentTest() throws Exception {
        //Arrange
        Long idStudent = 2L;
        RequestBuilder request = MockMvcRequestBuilders.delete("/student/removeStudent/{idStudent}", idStudent).accept(MediaType.APPLICATION_JSON);
        
        //Act
        ResultActions response = mockMvc.perform(request);
        response.andDo(print());

        //Assertion
        response.andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test to modify a exitent student")
    public void modifyExistentStudent() throws Exception {
        //Arrange
        StudentDTO studentToModify = TestUtilsGenerator.getFirstStudent();
        studentToModify.setStudentName("Pepe I");
        String content = new ObjectMapper().writeValueAsString(studentToModify);
        
        RequestBuilder request = MockMvcRequestBuilders.put("/student/modifyStudent")
                                 .contentType(MediaType.APPLICATION_JSON)
                                 .content(content);

        //Act
        ResultActions response = mockMvc.perform(request);
        response.andDo(print());

        //Assertions
        response.andExpect(status().isOk());

    }
    
}
