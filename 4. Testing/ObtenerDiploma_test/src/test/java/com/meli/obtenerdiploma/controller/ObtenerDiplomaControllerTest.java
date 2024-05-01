package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.utils.StudentsUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {
    @Mock
    IObtenerDiplomaService service;
    @InjectMocks
    ObtenerDiplomaController diplomaController;
    Set<StudentDTO> studentList;

    @BeforeEach
    void setup() {
        studentList = StudentsUtils.getMockStudents();
        StudentDTO aStudent = studentList.iterator().next();
        Mockito.when(service.analyzeScores(1L)).thenReturn(aStudent);
    }

    @Test
    @DisplayName("Test to read a user")
    void readOkService() {
        // Given - Arrange
        StudentDTO expectedStudent = studentList.iterator().next();

        // When - Act
        StudentDTO someStudent = diplomaController.analyzeScores(1L);

        // Then - Assert
        Assertions.assertEquals(expectedStudent, someStudent);
    }
}
