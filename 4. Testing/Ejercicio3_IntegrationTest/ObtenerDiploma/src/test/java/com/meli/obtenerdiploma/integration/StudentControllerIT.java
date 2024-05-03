package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
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
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class StudentControllerIT {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;
    private static ObjectMapper mapper;

    @BeforeEach
    @AfterEach
    void cleanData() {
        TestUtilsGenerator.usersFile();
    }

    @BeforeAll
    static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        mapper = new ObjectMapper();
    }

    @DisplayName("Integration Test - Registrar estudiante nuevo")
    @Test
    public void registerStudentTest() throws Exception {
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Cristopher");
        ResultActions response = mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(student))
        );

        response.andDo(print())
                .andExpect(status().isOk());
    }

    @DisplayName("Integration Test - Registrar estudiante con datos no validos")
    @Test
    public void registerStudentTestBadRequest() throws Exception {
        StudentDTO student = TestUtilsGenerator.getStudentWithInvalidData(3L);
        ResultActions response = mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(student))
        );

        response.andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(
                                result.getResolvedException() instanceof MethodArgumentNotValidException
                        )
                );
    }

    @DisplayName("Integration Test - Obtener estudiante por id con caso exitoso")
    @Test
    public void getStudentTest() throws Exception {
        StudentDTO studentExistent = TestUtilsGenerator.getStudentExistent();
        String studentExpected = writer.writeValueAsString(studentExistent);
        ResultActions response = mockMvc.perform(get("/student/getStudent/{id}", studentExistent.getId()));
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(result -> assertEquals(
                        studentExpected, result.getResponse().getContentAsString(StandardCharsets.UTF_8)
                ));
    }

    @DisplayName("Integration Test - Obtener estudiante por id con estudiante no encontrado")
    @Test
    public void getStudentNotFoundTest() throws Exception {
        Long id = 3L;
        ErrorDTO errorExpected = new ErrorDTO(
                "StudentNotFoundException",
                "El alumno con Id 3 no se encuetra registrado."
        );
        ResultActions response = mockMvc.perform(get("/student/getStudent/{id}", id));
        response.andExpect(status().isNotFound())
                .andDo(print())
                .andExpect(result -> assertEquals(
                                writer.writeValueAsString(errorExpected),
                                result.getResponse().getContentAsString(StandardCharsets.UTF_8)
                        )
                )
                .andExpect(result -> assertTrue(
                                result.getResolvedException() instanceof StudentNotFoundException
                        )
                );
    }

    @DisplayName("Integration Test - Modificar estudiante con caso exitoso")
    @Test
    void modifyStudentTest() throws Exception {
        StudentDTO studentModify = TestUtilsGenerator.getStudentWithId(1L);
        String studentExpected = writer.writeValueAsString(studentModify);
        ResultActions response = mockMvc.perform(post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(studentModify))
        );
        response.andDo(print())
                .andExpect(status().isOk());
    }

    @DisplayName("Integration Test - Modificar estudiante con datos invaliddos")
    @Test
    void modifyStudentWithInvalidDataTest() throws Exception {
        StudentDTO studentModify = TestUtilsGenerator.getStudentWithInvalidData(1L);
        studentModify.setStudentName("");
        studentModify.setSubjects(List.of());
        ResultActions response = mockMvc.perform(post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(studentModify))
        );
        response.andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(
                                result.getResolvedException() instanceof MethodArgumentNotValidException
                        )
                );
    }

    @DisplayName("Integration Test - Eliminar estudiante con caso exitoso")
    @Test
    void removeStudentTest() throws Exception {
        ResultActions response = mockMvc.perform(get("/student/removeStudent/{id}", 1L));
        response.andDo(print())
                .andExpect(status().isOk());
    }

    @DisplayName("Integration Test - Listar estudiantes")
    @Test
    void listStudentsTest() throws Exception {
        SubjectDTO subject1 = new SubjectDTO("Matemática", 10.0);
        SubjectDTO subject2 = new SubjectDTO("Física", 8.0);
        SubjectDTO subject3 = new SubjectDTO("Química", 4.0);
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);
        StudentDTO stu = new StudentDTO();
        stu.setId(2L);
        stu.setStudentName("Pedro");
        stu.setSubjects(subjects);
        stu.setMessage(null);
        stu.setAverageScore(null);
        Set<StudentDTO> students = new HashSet<>();
        students.add(TestUtilsGenerator.getStudentExistent());
        students.add(stu);
        String studentsExpected = writer.writeValueAsString(students);

        mockMvc.perform(get("/student/listStudents"))
                .andDo(print())
                .andExpect(result -> assertEquals(
                                studentsExpected, result.getResponse().getContentAsString(StandardCharsets.UTF_8)
                        )
                );
    }


}
