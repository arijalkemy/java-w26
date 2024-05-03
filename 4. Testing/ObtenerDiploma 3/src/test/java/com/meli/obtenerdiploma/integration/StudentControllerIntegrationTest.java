package com.meli.obtenerdiploma.integration;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    static ObjectMapper objectMapper = new ObjectMapper();
    static ObjectWriter objectWriter;

    @BeforeAll
    static void setup() {
        objectWriter = new ObjectMapper().configure(
                        SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        TestUtilsGenerator.emptyUsersFile();
    }

    @BeforeAll
    static void tearDown() throws IOException {
        TestUtilsGenerator.emptyUsersFile();
    }

    @Test
    void findByIdTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        File file = new File("./src/test/resources/users.json");

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Test");

        List<StudentDTO> studentDTOS = List.of(studentDTO);

        try {
            objectMapper.writeValue(file, studentDTOS);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        MvcResult mvcResult = mockMvc.perform(
                        get("/student/getStudent/1")
                                .contentType(MediaType.APPLICATION_JSON)
                ).andDo(print())
                .andReturn();

        StudentDTO studentResponse = objectMapper.readValue(
                mvcResult.getResponse().getContentAsString(),
                StudentDTO.class
        );

        Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
        Assertions.assertEquals(studentDTO, studentResponse);
    }

    @Test
    void findByIdTestNotFound() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                        get("/student/getStudent/100")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andReturn();


        Assertions.assertEquals(404, mvcResult.getResponse().getStatus());
    }

    @Test
    void registerStudentTest() throws Exception {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Test");
        studentDTO.setSubjects(List.of(new SubjectDTO("Test", 10.0), new SubjectDTO("Test2", 6.0)));

        MvcResult mvcResult = mockMvc.perform(
                        post("/student/registerStudent")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectWriter.writeValueAsString(studentDTO))
                                )
                .andExpect(status().isOk())
                .andReturn();


        MvcResult studentResponseMvc = mockMvc.perform(
                        get("/student/getStudent/1")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andReturn();

        StudentDTO studentResponse = objectMapper.readValue(
                studentResponseMvc.getResponse().getContentAsString(),
                StudentDTO.class
        );

        studentDTO.setId(1L);

        Assertions.assertEquals(studentDTO, studentResponse);
    }

    @Test
    @DisplayName("Register student with score greater than 10 in a subject should return bad request")
    void registerStudentTestWithInvalidScoreInASubject() throws Exception {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Test");
        studentDTO.setSubjects(List.of(new SubjectDTO("Test", 10.0), new SubjectDTO("Test2", 11.0)));

        MvcResult mvcResult = mockMvc.perform(
                        post("/student/registerStudent")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectWriter.writeValueAsString(studentDTO))
                )
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

        ErrorDTO errorResponse = objectMapper.readValue(
                mvcResult.getResponse().getContentAsString(),
                ErrorDTO.class
        );

        Assertions.assertEquals("MethodArgumentNotValidException", errorResponse.getName());
        Assertions.assertEquals("La nota maxima de la materia es de 10 pts.", errorResponse.getDescription());
    }

    @Test
    @DisplayName("Register student with score lower than 0 in a subject should return bad request")
    void registerStudentTestWithInvalidScoreInASubject2() throws Exception {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Test");
        studentDTO.setSubjects(List.of(new SubjectDTO("Test", 10.0), new SubjectDTO("Test2", -11.0)));

        MvcResult mvcResult = mockMvc.perform(
                        post("/student/registerStudent")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectWriter.writeValueAsString(studentDTO))
                )
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

        ErrorDTO errorResponse = objectMapper.readValue(
                mvcResult.getResponse().getContentAsString(),
                ErrorDTO.class
        );

        Assertions.assertEquals("MethodArgumentNotValidException", errorResponse.getName());
        Assertions.assertEquals("La nota minima de la materia es de 0 pts.", errorResponse.getDescription());
    }

//    @Test
//    @DisplayName("Register student with an empty name in a subject")
//    void registerStudentTestWithInvalidScoreInASubject3() throws Exception {
//        StudentDTO studentDTO = new StudentDTO();
//        studentDTO.setId(1L);
//        studentDTO.setStudentName("Test");
//        studentDTO.setSubjects(List.of(new SubjectDTO("", 10.0), new SubjectDTO("Test2", 5.0)));
//
//        MvcResult mvcResult = mockMvc.perform(
//                        post("/student/registerStudent")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(objectWriter.writeValueAsString(studentDTO))
//                )
//                .andDo(print())
//                .andExpect(status().isBadRequest())
//                .andReturn();
//
//        ErrorDTO errorResponse = objectMapper.readValue(
//                mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8),
//                ErrorDTO.class
//        );
//
//        Assertions.assertEquals("MethodArgumentNotValidException", errorResponse.getName());
//        Assertions.assertEquals("El nombre de la materia no puede estar vacío.", errorResponse.getDescription());
//    }
}

