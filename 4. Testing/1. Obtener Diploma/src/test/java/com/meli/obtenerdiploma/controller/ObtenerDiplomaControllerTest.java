package com.meli.obtenerdiploma.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {
  @Mock
  ObtenerDiplomaService obtenerDiplomaService;

  @InjectMocks
  ObtenerDiplomaController obtenerDiplomaController;

  StudentDTO student = new StudentDTO();

  @BeforeEach
  void setUp() {
    student.setId(1L);
    student.setStudentName("John Doe");
    student.setAverageScore(9.5);
    student.setMessage("Congratulations, John Doe! You have an average score of 9.5");
  }

  @Test
  void analyzeScoresReturnsStudentWithValidId() {
    when(obtenerDiplomaService.analyzeScores(1L)).thenReturn(student);
    StudentDTO result = obtenerDiplomaController.analyzeScores(1L);
    assertEquals(student, result);
  }

  @Test
  void analyzeScoresReturnsNullWithInvalidId() {
    when(obtenerDiplomaService.analyzeScores(anyLong())).thenReturn(null);
    StudentDTO result = obtenerDiplomaController.analyzeScores(2L);
    assertNull(result);
  }
}
