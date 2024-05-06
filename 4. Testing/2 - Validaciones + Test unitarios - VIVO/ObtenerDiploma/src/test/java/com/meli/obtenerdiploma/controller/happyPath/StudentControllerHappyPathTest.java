package com.meli.obtenerdiploma.controller.happyPath;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.controller.StudentController;
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

import javax.xml.transform.Result;
import java.util.*;
import java.util.concurrent.ExecutionException;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = StudentController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class StudentControllerHappyPathTest {
    private final static String BASE_PATH = "/student";

    @MockBean
    IStudentService studentService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("it should return a student by the id")
    public void getStudentByIdTest() throws Exception{
        // arrange
        StudentDTO studentExpected =  createDTO();
        studentExpected.setId(1L);

        // act
        when(studentService.read(anyLong())).thenReturn(studentExpected);
        ResultActions result = mockMvc.perform(
                get(BASE_PATH + "/getStudent/{id}", studentExpected.getId())
                .contentType(MediaType.APPLICATION_JSON)
        );

        // assert
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(studentExpected.getId()))
                .andExpect(jsonPath("$.studentName").value(studentExpected.getStudentName()))
                .andExpect(jsonPath("$.message").value(studentExpected.getMessage()))
                .andExpect(jsonPath("$.averageScore").value(studentExpected.getAverageScore()))
                .andExpect(jsonPath("$.subjects").isArray());
        verify(studentService).read(anyLong());
    }

    @Test
    @DisplayName("it should register a student")
    public void registerStudentTest() throws Exception{
        StudentDTO expectedStudent = this.createDTO();
        expectedStudent.setId(1L);

        ResultActions result = mockMvc.perform(
                post(BASE_PATH+"/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(expectedStudent))
        );

        result.andExpect(status().isOk())
                .andExpect(jsonPath("$").doesNotExist());
        verify(studentService).create(any(StudentDTO.class));
    }

    @Test
    @DisplayName("it should modify the data of a Student")
    public void updateStudentTest() throws Exception{
        // arrange
        StudentDTO studentUpdated = this.createDTO();
        studentUpdated.setStudentName("Juan Jose Perez");
        studentUpdated.setSubjects(new ArrayList<>(List.of(new SubjectDTO("Calculo Integral", 6.0))));

        // act
        ResultActions result = mockMvc.perform(
                post(BASE_PATH+"/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(studentUpdated))
        );

        // asserts
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$").doesNotExist());
        verify(studentService).update(any(StudentDTO.class));
    }

    @Test
    @DisplayName("it should remove the data of a Student")
    public void removeStudentTest() throws Exception{
        // arranger
        Long studentId = 1L;

        // act
        ResultActions result = mockMvc.perform(
                get(BASE_PATH+"/removeStudent/{id}", anyLong())
                .contentType(MediaType.APPLICATION_JSON)
        );

        // assert
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$").doesNotExist());
        verify(studentService).delete(anyLong());
    }

    @Test
    @DisplayName("it should return a list of students")
    public void listStudentsTest() throws Exception{
        // arrange
        StudentDTO student1 = this.createDTO();
        StudentDTO student2 = this.createDTO();

        student2.setId(2L);
        student2.setStudentName("Jose Garcia");
        Set<StudentDTO> students = new HashSet<>();
        students.add(student1);
        students.add(student2);

        // act
        when(studentService.getAll()).thenReturn(students);
        ResultActions result = mockMvc.perform(
                get(BASE_PATH+"/listStudents")
                .contentType(MediaType.APPLICATION_JSON)
        );

        // assert
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(students.size()))
                .andExpect(jsonPath("$[0].id").value(student2.getId()))
                .andExpect(jsonPath("$[0].studentName").value(student2.getStudentName()))
                .andExpect(jsonPath("$[1].id").value(student1.getId()))
                .andExpect(jsonPath("$[1].studentName").value(student1.getStudentName()));

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
