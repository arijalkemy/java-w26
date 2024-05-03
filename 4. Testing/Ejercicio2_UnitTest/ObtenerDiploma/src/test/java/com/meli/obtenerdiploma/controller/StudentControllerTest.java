package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.utils.StudentGeneratorTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IStudentService studentService;

    private static ObjectWriter writer;
    private static ObjectMapper mapper;

    @BeforeAll
    public static void setup() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        mapper = new ObjectMapper();
    }

    @DisplayName("Test - Registrar Estudiante - OK")
    @Test
    void registerStudent() throws Exception {
        // Arrange
        StudentDTO student = StudentGeneratorTest.getStudentForTest();

        // Act
        ResultActions response = mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(student))
        );

        // Assert
        response.andDo(print())
                .andExpect(status().isOk());
        verify(studentService).create(any(StudentDTO.class));
    }

    @DisplayName("Test - Registrar Estudiante con datos invalidos")
    @Test
    void invalidRegisterStudent() throws Exception {
        // Arrange
        StudentDTO student = StudentGeneratorTest.getStudentForTest();
        student.setStudentName("");
        student.setSubjects(List.of());

        // Act
        ResultActions response = mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(student))
        );

        // Assert
        response.andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(
                                result.getResolvedException() instanceof MethodArgumentNotValidException
                        )
                );
    }

    @DisplayName("Test - Obtener estudiante por Id de manera exitosa")
    @Test
    void getStudent() throws Exception {
        // Arrange
        StudentDTO student = StudentGeneratorTest.getStudentForTest();
        Long id = 3L;
        when(studentService.read(id)).thenReturn(student);
        String studentExpected = writer.writeValueAsString(student);
        // Act
        ResultActions response = mockMvc.perform(get("/student/getStudent/{id}", id));

        // Assert
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(result -> assertEquals(
                        studentExpected, result.getResponse().getContentAsString(StandardCharsets.UTF_8)
                ));
    }

    @DisplayName("Test - Obtener estudiante por Id no encontrado")
    @Test
    void getStudentNotFound() throws Exception {
        // Arrange
        Long id = 999L;
        when(studentService.read(id)).thenThrow(StudentNotFoundException.class);

        // Act
        ResultActions response = mockMvc.perform(get("/student/getStudent/{id}", id));

        // Assert
        response.andExpect(status().isNotFound())
                .andDo(print());
    }

    @DisplayName("Test - Modificar estudiante caso exitoso")
    @Test
    void modifyStudent() throws Exception {
        // Arrange
        StudentDTO student = StudentGeneratorTest.getStudentForTest();

        // Act
        ResultActions response = mockMvc.perform(post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(student))
        );

        // Assert
        response.andDo(print())
                .andExpect(status().isOk());

        verify(studentService).update(any(StudentDTO.class));
    }

    @DisplayName("Test - Modificar estudiante caso fallido, datos invalidos")
    @Test
    void modifyStudentWithInvalidData() throws Exception {
        // Arrange
        StudentDTO student = StudentGeneratorTest.getStudentForTest();
        student.setStudentName("nombreConPrimeraLetraMinúscula");
        student.setSubjects(List.of());

        // Act
        ResultActions response = mockMvc.perform(post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(student))
        );

        // Assert
        response.andDo(print())
                .andExpect(result -> assertTrue(
                        result.getResolvedException() instanceof MethodArgumentNotValidException)
                );
    }

    @DisplayName("Test - Eliminar estudiante con caso exitoso")
    @Test
    void removeStudent() throws Exception {
        // Arrange
        Long id = 3L;

        // Act
        ResultActions response = mockMvc.perform(get("/student/removeStudent/{id}", id));

        // Assert
        response.andDo(print())
                .andExpect(status().isOk());
    }

    @DisplayName("Test - listar estudiantes")
    @Test
    void listStudents() throws Exception {
        // Arrange
        Set<StudentDTO> students = StudentGeneratorTest.getStudentsListForTest();
        when(studentService.getAll()).thenReturn(students);
        String studentsExpected = mapper.writeValueAsString(students);

        // Act
        ResultActions response = mockMvc.perform(get("/student/listStudents"));

        // Assert
        response.andDo(print())
                .andExpect(status().isOk())
                .andExpect(result -> assertEquals(
                        studentsExpected, result.getResponse().getContentAsString(StandardCharsets.UTF_8))
                );
    }
}