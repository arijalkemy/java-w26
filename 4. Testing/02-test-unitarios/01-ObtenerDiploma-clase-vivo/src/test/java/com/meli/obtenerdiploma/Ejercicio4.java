package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class Ejercicio4 {

    @Mock
    private IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    private ObtenerDiplomaController obtenerDiplomaController;

    private Long studentId;
    private StudentDTO student;

    @BeforeEach
    void setUp(){
        studentId = 1L;
        student = new StudentDTO();
        student.setId(studentId);
        student.setStudentName("John Doe");
        student.setAverageScore(9.5);
        student.setMessage("El alumno John Doe ha obtenido un promedio de 9.5. Felicitaciones!");
    }

    @Test
    @DisplayName("Analizar notas")
    void analyzeScores(){
        when(obtenerDiplomaService.analyzeScores(studentId)).thenReturn(student);

        StudentDTO actualStudent = obtenerDiplomaController.analyzeScores(studentId);

        assertEquals(student, actualStudent);
        verify(obtenerDiplomaService, times(1)).analyzeScores(studentId);
    }

    @Test
    @DisplayName("Analizar notas de alumno no existente")
    void analyzeScores_StudentNotFound(){
        when(obtenerDiplomaService.analyzeScores(studentId)).thenThrow(new StudentNotFoundException(studentId));

        assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaController.analyzeScores(studentId));
        verify(obtenerDiplomaService, times(1)).analyzeScores(studentId);
    }

    @Test
    @DisplayName("Analizar notas alumno con bajo promedio")
    void analyzeScores_LowAverage(){
        Long studentId = 1L;
        StudentDTO expectedStudent = new StudentDTO();
        expectedStudent.setId(studentId);
        expectedStudent.setStudentName("John Doe");
        expectedStudent.setAverageScore(8.0);
        expectedStudent.setMessage("El alumno John Doe ha obtenido un promedio de 8.0. Puedes mejorar.");

        when(obtenerDiplomaService.analyzeScores(studentId)).thenReturn(expectedStudent);

        StudentDTO actualStudent = obtenerDiplomaController.analyzeScores(studentId);

        assertEquals(expectedStudent, actualStudent);
        verify(obtenerDiplomaService, times(1)).analyzeScores(studentId);
    }
}
