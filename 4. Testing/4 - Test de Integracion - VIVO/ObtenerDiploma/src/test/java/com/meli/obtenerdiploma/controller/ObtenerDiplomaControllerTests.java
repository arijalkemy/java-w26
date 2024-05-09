package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ObtenerDiplomaController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTests {
    @MockBean
    IObtenerDiplomaService service;

    @Autowired
    MockMvc mockMvc;

    @InjectMocks
    ObtenerDiplomaController controller;

    @Test
    @DisplayName("it should return the analyzed score")
    public void obtenerDiploma() throws Exception{
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Marco");

        // act
        when(service.analyzeScores(anyLong())).thenReturn(stu);
        ResultActions result = mockMvc.perform(
                get("/analyzeScores/{studentId}", anyLong())
                .contentType(MediaType.APPLICATION_JSON)
        );

        // assert
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.studentName").value(stu.getStudentName()));
        verify(service).analyzeScores(anyLong());
    }

    @Test
    @DisplayName("it should return a exception")
    public void obtenerDiplomaException() throws Exception{
        StudentDTO stu = TestUtilsGenerator.getStudentWithId(-99L);
//        when(service.analyzeScores(stu.getId())).thenThrow(StudentNotFoundException.class);
//        assertThrows(
//               StudentNotFoundException.class,
//               () -> service.analyzeScores(stu.getId()));
        when(service.analyzeScores(anyLong())).thenReturn(stu);
        ResultActions result = mockMvc.perform(
                get("/analyzeScores/{studentId}", -99)
                .contentType(MediaType.APPLICATION_JSON)
        );

        result.andDo(print());
    }

    @Test
    @DisplayName("it should return 404 when student not found")
    public void obtenerDiploma_StudentNotFound() throws Exception {
        // Arrange
        when(service.analyzeScores(anyLong())).thenThrow(StudentNotFoundException.class);

        // Act
        ResultActions result = mockMvc.perform(get("/analyzeScores/{studentId}", 1L)
                .contentType(MediaType.APPLICATION_JSON));

        // Assert
        result.andExpect(status().isNotFound()).andDo(print());
    }

}
