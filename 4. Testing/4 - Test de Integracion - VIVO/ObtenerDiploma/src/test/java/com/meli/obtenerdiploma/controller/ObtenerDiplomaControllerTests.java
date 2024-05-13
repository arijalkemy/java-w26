package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.ObtenerDiplomaException;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTests {
    @MockBean
    IObtenerDiplomaService service;

    @Autowired
    MockMvc mockMvc;

    @InjectMocks
    ObtenerDiplomaController controller;


    @Test
    public void obtenerDiploma() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        controller.analyzeScores(stu.getId());

        // assert
        verify(service, atLeastOnce()).analyzeScores(stu.getId());
    }

    @Test
    @DisplayName("it should return a exception")
    public void obtenerDiplomaException() throws Exception{
        StudentDTO stu = TestUtilsGenerator.getStudentWithId(-99L);
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
        ResultActions result = mockMvc.perform(
                get("/analyzeScores/{studentId}", 1L)
                .contentType(MediaType.APPLICATION_JSON));

        // Assert
        result.andExpect(status().isNotFound()).andDo(print());
    }

    @Test
    @DisplayName("it should return a 404 when id student is under 0")
    public void obtenerDiplomaError() throws Exception{
        // Arrange
        when(service.analyzeScores(-99L)).thenThrow(ObtenerDiplomaException.class);

        // Act
        ResultActions result = mockMvc.perform(
                get("/analyzeScores/{studentId}", -99L)
                        .contentType(MediaType.APPLICATION_JSON));

        // Assert
        result.andExpect(status().isBadRequest()).andDo(print());
    }



}
