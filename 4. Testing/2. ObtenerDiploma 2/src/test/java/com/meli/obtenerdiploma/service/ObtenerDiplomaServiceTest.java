package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void testAnalyzeScores() {
        // Configurar el comportamiento del objeto simulado
        when(studentDAO.findById(anyLong())).thenReturn(new StudentDTO(1L, "John Doe",
                "El alumno John Doe ha obtenido un promedio de 9. Puedes mejorar.", 9.0,
                Arrays.asList(
                new SubjectDTO("Matemáticas", 10.0),
                new SubjectDTO("Física", 8.0),
                new SubjectDTO("Química", 9.0)
        )));

        // Realizar la prueba
        StudentDTO student = obtenerDiplomaService.analyzeScores(1L);

        // Verificar los resultados
        assertEquals(9.0, student.getAverageScore());
        assertEquals("El alumno John Doe ha obtenido un promedio de 9. Puedes mejorar.", student.getMessage());
    }

    // Caso de prueba para verificar el cálculo del promedio
    @Test
    public void testCalculateAverage() {
        when(studentDAO.findById(anyLong())).thenReturn(new StudentDTO(1L, "John Doe", null, null,
                Arrays.asList(
                        new SubjectDTO("Matemáticas", 10.0),
                        new SubjectDTO("Física", 8.0),
                        new SubjectDTO("Química", 9.0)
                )));

        StudentDTO student = obtenerDiplomaService.analyzeScores(1L);

        assertEquals(9.0, student.getAverageScore());
    }

    // Caso de prueba para verificar el mensaje del diploma
    @Test
    public void testDiplomaMessage() {
        when(studentDAO.findById(anyLong())).thenReturn(new StudentDTO(1L, "John Doe", null, null,
                Arrays.asList(
                        new SubjectDTO("Matemáticas", 10.0),
                        new SubjectDTO("Física", 8.0),
                        new SubjectDTO("Química", 9.0)
                )));

        StudentDTO student = obtenerDiplomaService.analyzeScores(1L);

        assertEquals("El alumno John Doe ha obtenido un promedio de 9. Puedes mejorar.", student.getMessage());
    }

    // Caso de prueba para verificar el mensaje del diploma con honores
    @Test
    public void testDiplomaWithHonorsMessage() {
        when(studentDAO.findById(anyLong())).thenReturn(new StudentDTO(1L, "John Doe", null, null,
                Arrays.asList(
                        new SubjectDTO("Matemáticas", 10.0),
                        new SubjectDTO("Física", 10.0),
                        new SubjectDTO("Química", 10.0)
                )));

        StudentDTO student = obtenerDiplomaService.analyzeScores(1L);

        assertEquals("El alumno John Doe ha obtenido un promedio de 10. Felicitaciones!", student.getMessage());
    }
}
