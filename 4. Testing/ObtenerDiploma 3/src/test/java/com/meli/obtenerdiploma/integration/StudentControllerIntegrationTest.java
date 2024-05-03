package com.meli.obtenerdiploma.integration;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
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
        objectWriter = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();


        TestUtilsGenerator.emptyUsersFile();
    }

    @BeforeEach
    void tearDown() throws IOException {
        TestUtilsGenerator.emptyUsersFile();
    }

    @Test
    @DisplayName("Find student by id should return student")
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

        MvcResult mvcResult = mockMvc.perform(get("/student/getStudent/1").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn();

        StudentDTO studentResponse = objectMapper.readValue(
                mvcResult.getResponse().getContentAsString(),
                StudentDTO.class
        );

        Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
        Assertions.assertEquals(studentDTO, studentResponse);
    }

    @Test
    @DisplayName("Find student by id should return not found")
    void findByIdTestNotFound() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/student/getStudent/100").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn();


        Assertions.assertEquals(404, mvcResult.getResponse().getStatus());
    }

    @Test
    @DisplayName("Modify student")
    void modifyStudentTest() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Test");

        mockMvc.perform(post("/student/registerStudent").contentType(MediaType.APPLICATION_JSON)
                                .content(objectWriter.writeValueAsString(studentDTO))).andReturn();


        studentDTO.setId(1L);
        studentDTO.setStudentName("Test2");

        mockMvc.perform(post("/student/modifyStudent").contentType(MediaType.APPLICATION_JSON)
                                .content(objectWriter.writeValueAsString(studentDTO))).andReturn();

        MvcResult mvcResult = mockMvc.perform(
                        get("/student/getStudent/1")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andReturn();

        StudentDTO studentResponse = objectMapper.readValue(
                mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8),
                StudentDTO.class
        );

        Assertions.assertEquals(studentDTO, studentResponse);
    }

    @Test
    @DisplayName("Remove student by id")
    void removeStudentTest() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Test");

        mockMvc.perform(post("/student/registerStudent").contentType(MediaType.APPLICATION_JSON)
                                .content(objectWriter.writeValueAsString(studentDTO))).andReturn();

        mockMvc.perform(get("/student/removeStudent/1").contentType(MediaType.APPLICATION_JSON)).andReturn();

        MvcResult mvcResult = mockMvc.perform(get("/student/getStudent/1").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn();

        Assertions.assertEquals(404, mvcResult.getResponse().getStatus());
    }

    @Test
    @DisplayName("List students")
    void listStudentsTest() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Test");
        StudentDTO studentDTO2 = TestUtilsGenerator.getStudentWith3Subjects("Test2");

        mockMvc.perform(post("/student/registerStudent").contentType(MediaType.APPLICATION_JSON)
                                .content(objectWriter.writeValueAsString(studentDTO))).andReturn();

        mockMvc.perform(post("/student/registerStudent").contentType(MediaType.APPLICATION_JSON)
                                .content(objectWriter.writeValueAsString(studentDTO))).andReturn();

        MvcResult mvcResult = mockMvc.perform(get("/student/listStudents").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn();

        List<StudentDTO> studentResponse = objectMapper.readValue(
                mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8),
                List.class
        );

        Assertions.assertEquals(2, studentResponse.size());

    }


    @Test
    @DisplayName("Register student should return ok")
    void registerStudentTest() throws Exception {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Test");
        studentDTO.setSubjects(List.of(new SubjectDTO("Test", 10.0), new SubjectDTO("Test2", 6.0)));

        MvcResult mvcResult = mockMvc.perform(post("/student/registerStudent").contentType(MediaType.APPLICATION_JSON)
                                                      .content(objectWriter.writeValueAsString(studentDTO))).andExpect(
                status().isOk()).andReturn();


        MvcResult studentResponseMvc
                = mockMvc.perform(get("/student/getStudent/1").contentType(MediaType.APPLICATION_JSON))
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

        MvcResult mvcResult = mockMvc.perform(post("/student/registerStudent").contentType(MediaType.APPLICATION_JSON)
                                                      .content(objectWriter.writeValueAsString(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

        ErrorDTO errorResponse = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), ErrorDTO.class);

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

        MvcResult mvcResult = mockMvc.perform(post("/student/registerStudent").contentType(MediaType.APPLICATION_JSON)
                                                      .content(objectWriter.writeValueAsString(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

        ErrorDTO errorResponse = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), ErrorDTO.class);

        Assertions.assertEquals("MethodArgumentNotValidException", errorResponse.getName());
        Assertions.assertEquals("La nota minima de la materia es de 0 pts.", errorResponse.getDescription());
    }

    @Test
    @DisplayName("Register student with an empty name in a subject")
    void registerStudentTestWithInvalidScoreInASubject3() throws Exception {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Test");
        studentDTO.setSubjects(List.of(new SubjectDTO("", 10.0), new SubjectDTO("Test2", 5.0)));

        MvcResult mvcResult = mockMvc.perform(post("/student/registerStudent").contentType(MediaType.APPLICATION_JSON)
                                                      .content(objectWriter.writeValueAsString(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

        ErrorDTO errorResponse = objectMapper.readValue(
                mvcResult.getResponse()
                        .getContentAsString(StandardCharsets.UTF_8),
                ErrorDTO.class
        );

        Assertions.assertEquals("MethodArgumentNotValidException", errorResponse.getName());
        Assertions.assertTrue(errorResponse.getDescription().contains("El nombre de la materia no puede estar vacío."));
    }

    @Test
    @DisplayName("Register student with a subject that start with a lowercase letter")
    void registerStudentTestWithInvalidScoreInASubject4() throws Exception {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Test");
        studentDTO.setSubjects(List.of(new SubjectDTO("test", 10.0), new SubjectDTO("Test2", 5.0)));

        MvcResult mvcResult = mockMvc.perform(post("/student/registerStudent").contentType(MediaType.APPLICATION_JSON)
                                                      .content(objectWriter.writeValueAsString(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

        ErrorDTO errorResponse = objectMapper.readValue(
                mvcResult.getResponse()
                        .getContentAsString(StandardCharsets.UTF_8),
                ErrorDTO.class
        );

        Assertions.assertEquals("MethodArgumentNotValidException", errorResponse.getName());
        Assertions.assertTrue(errorResponse.getDescription()
                                      .contains("El nombre de la materia debe comenzar con mayúscula."));
    }

    @Test
    @DisplayName("Register student with a subject that has more than 30 characters in the name")
    void registerStudentTestWithInvalidScoreInASubject5() throws Exception {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Test");
        studentDTO.setSubjects(List.of(
                new SubjectDTO("TestTestTestTestTestTestTestTestTestTest", 10.0),
                new SubjectDTO("Test2", 5.0)
        ));

        MvcResult mvcResult = mockMvc.perform(post("/student/registerStudent").contentType(MediaType.APPLICATION_JSON)
                                                      .content(objectWriter.writeValueAsString(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

        ErrorDTO errorResponse = objectMapper.readValue(
                mvcResult.getResponse()
                        .getContentAsString(StandardCharsets.UTF_8),
                ErrorDTO.class
        );

        Assertions.assertEquals("MethodArgumentNotValidException", errorResponse.getName());
        Assertions.assertTrue(errorResponse.getDescription()
                                      .contains(
                                              "La longitud del nombre de la materia no puede superar los 30 caracteres."));
    }

    @Test
    @DisplayName("Register a student that has a name with more than 50 characters")
    void registerStudentTestWithInvalidScoreInASubject6() throws Exception {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName(
                "testttestttestttestttestttestttestttestttestttestttestttestttestttestttestttestttestttestttestt");
        studentDTO.setSubjects(List.of(new SubjectDTO("Test", 10.0), new SubjectDTO("Test2", 5.0)));
        MvcResult mvcResult = mockMvc.perform(post("/student/registerStudent").contentType(MediaType.APPLICATION_JSON)
                                                      .content(objectWriter.writeValueAsString(studentDTO))).andExpect(
                status().isBadRequest()).andReturn();

        ErrorDTO errorResponse = objectMapper.readValue(
                mvcResult.getResponse()
                        .getContentAsString(StandardCharsets.UTF_8),
                ErrorDTO.class
        );

        Assertions.assertEquals("MethodArgumentNotValidException", errorResponse.getName());
        Assertions.assertTrue(errorResponse.getDescription()
                                      .contains("La longitud del nombre del estudiante no puede superar los" +
                                                        " 50 caracteres."));
    }

    @Test
    @DisplayName("Register a student with a name that start with a lowercase letter")
    void registerStudentTestWithInvalidScoreInASubject7() throws Exception {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("test");
        studentDTO.setSubjects(List.of(new SubjectDTO("Test", 10.0), new SubjectDTO("Test2", 5.0)));
        MvcResult mvcResult = mockMvc.perform(post("/student/registerStudent").contentType(MediaType.APPLICATION_JSON)
                                                      .content(objectWriter.writeValueAsString(studentDTO))).andExpect(
                status().isBadRequest()).andReturn();

        ErrorDTO errorResponse = objectMapper.readValue(
                mvcResult.getResponse()
                        .getContentAsString(StandardCharsets.UTF_8),
                ErrorDTO.class
        );

        Assertions.assertEquals("MethodArgumentNotValidException", errorResponse.getName());
        Assertions.assertTrue(errorResponse.getDescription()
                                      .contains("El nombre del estudiante debe comenzar con mayúscula."));
    }

    @Test
    @DisplayName("Register a student with an empty subject list")
    void registerStudentTestWithInvalidScoreInASubject8() throws Exception {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Test");
        studentDTO.setSubjects(List.of());
        MvcResult mvcResult = mockMvc.perform(post("/student/registerStudent").contentType(MediaType.APPLICATION_JSON)
                                                      .content(objectWriter.writeValueAsString(studentDTO))).andExpect(
                status().isBadRequest()).andReturn();

        ErrorDTO errorResponse = objectMapper.readValue(
                mvcResult.getResponse()
                        .getContentAsString(StandardCharsets.UTF_8),
                ErrorDTO.class
        );

        Assertions.assertEquals("MethodArgumentNotValidException", errorResponse.getName());
        Assertions.assertTrue(errorResponse.getDescription().contains("La lista de materias no puede estar vacía."));
    }


}