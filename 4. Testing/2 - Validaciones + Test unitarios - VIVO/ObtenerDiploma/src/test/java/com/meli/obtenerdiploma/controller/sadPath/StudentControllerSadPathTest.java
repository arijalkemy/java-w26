package com.meli.obtenerdiploma.controller.sadPath;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = StudentController.class)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class StudentControllerSadPathTest {
    private static final String BASE_PATH = "/student";

    @MockBean
    IStudentService studentService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("it should return a bad request becase studentName is empty in register")
    public void registerStudentWithEmptyStudentName() throws Exception{
        // arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("");
        studentDTO.setSubjects(new ArrayList<>(List.of(new SubjectDTO("Mat", 10.0))));

        // act
        ResultActions result = mockMvc.perform(
                post(BASE_PATH+"/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(studentDTO))
        );

        // assert
        result.andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value("El nombre del estudiante no puede estar vacío."))
                .andDo(print());
        verify(studentService, never()).create(any(StudentDTO.class));
    }

    @Test
    @DisplayName("it should return a bad request becase array of Subject is empty in register")
    public void registerStudentWithEmptySubjects() throws Exception{
        // arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Juan Perez");
        studentDTO.setSubjects(Collections.emptyList());
        // act
        ResultActions result = mockMvc.perform(
                post(BASE_PATH+"/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(studentDTO))
        );

        // assert
        result.andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value("La lista de materias no puede estar vacía."))
                .andDo(print());
        verify(studentService, never()).create(any(StudentDTO.class));
    }

    @Test
    @DisplayName("it should return a bad request because subjectName is not uppercase in register")
    public void registerStudentWithNonCorrectSubjectName() throws Exception{
        // arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Juan Perez");
        studentDTO.setSubjects(new ArrayList<>(List.of(new SubjectDTO("matematicas", 10.0))));

        // act
        ResultActions result = mockMvc.perform(post(BASE_PATH+"/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(studentDTO))
        );

        // assert
        result.andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value("El nombre de la materia debe comenzar con mayúscula."));
        verify(studentService, never()).create(any(StudentDTO.class));
    }

    @Test
    @DisplayName("it should return a bad request because subjectScore is not zero or positive in register")
    public void registerStudentWithNonCorrectSubjectScore() throws Exception{
        // arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Juan Perez");
        studentDTO.setSubjects(new ArrayList<>(List.of(new SubjectDTO("Matematicas", -10.0))));

        // act
        ResultActions result = mockMvc.perform(post(BASE_PATH+"/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(studentDTO))
        );

        // assert
        result.andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value("La nota mínima de la materia es de 0 pts."));
        verify(studentService, never()).create(any(StudentDTO.class));
    }

    @Test
    @DisplayName("it should return a 404 becase a non-existing student in get")
    public void getStudentWithNonExistingId() throws Exception{
        // arrange
        Long studentId = 999L;

        // act
        when(studentService.read(anyLong())).thenThrow(new StudentNotFoundException(studentId));
        ResultActions result = mockMvc.perform(
                get(BASE_PATH+"/getStudent/{id}", studentId)
                .contentType(MediaType.APPLICATION_JSON)
        );

        // assert
        result.andExpect(status().isNotFound())
                .andExpect(jsonPath("$.description").value("El alumno con Id 999 no se encuetra registrado."));
        verify(studentService).read(anyLong());
    }

    @Test
    @DisplayName("it should return a bad request becase studentName is empty in update")
    public void updateStudentWithEmptyStudentName() throws Exception{
        // arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("");
        studentDTO.setSubjects(new ArrayList<>(List.of(new SubjectDTO("Fisica", 10.0))));

        // act
        ResultActions result = mockMvc.perform(
                post(BASE_PATH+"/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(studentDTO))
        );

        // assert
        result.andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value("El nombre del estudiante no puede estar vacío."))
                .andDo(print());
        verify(studentService, never()).update(any(StudentDTO.class));
    }

    @Test
    @DisplayName("it should return a bad request becase array of Subject is empty in update")
    public void updateStudentWithEmptySubjects() throws Exception{
        // arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Juan Perez");
        studentDTO.setSubjects(Collections.emptyList());
        // act
        ResultActions result = mockMvc.perform(
                post(BASE_PATH+"/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(studentDTO))
        );

        // assert
        result.andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value("La lista de materias no puede estar vacía."))
                .andDo(print());
        verify(studentService, never()).update(any(StudentDTO.class));
    }

    @Test
    @DisplayName("it should return a 404 becase a non-existing student in delete")
    public void deleteStudentWithNonExistingId() throws Exception{
        // arrange
        Long studentId = 999L;

        // act
        doThrow(new StudentNotFoundException(studentId)).when(studentService).delete(anyLong());
        ResultActions result = mockMvc.perform(
                get(BASE_PATH+"/removeStudent/{id}", studentId)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        // assert
        result.andExpect(status().isNotFound())
                .andExpect(jsonPath("$.description").value("El alumno con Id 999 no se encuetra registrado."));
        verify(studentService).delete(anyLong());
    }

    @Test
    @DisplayName("it should return a empty list of students")
    public void listStudentsWithEmptyList() throws Exception{
        // arrange
        Set<StudentDTO> students = new HashSet<>();

        // act
        when(studentService.getAll()).thenReturn(students);
        ResultActions results = mockMvc.perform(
                get(BASE_PATH+"/listStudents")
                .contentType(MediaType.APPLICATION_JSON)
        );

        // arrange
        results.andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());
        verify(studentService).getAll();
    }

    public StudentDTO createDTO(){
        return new StudentDTO(
                1L,
                "Jose",
                "",
                0.0,
                new ArrayList<SubjectDTO>(Arrays.asList(
                        new SubjectDTO(
                                "Fisica",
                                10.0
                        ),
                        new SubjectDTO(
                                "Graficacion",
                                9.0
                        ),
                        new SubjectDTO(
                                "Circuitos",
                                6.0
                        )
                ))
        );
    }

    public double calculateScore(List<SubjectDTO> subjects){
        return subjects.stream().mapToDouble(x -> x.getScore()).average().orElse(0.0);
    }

}
