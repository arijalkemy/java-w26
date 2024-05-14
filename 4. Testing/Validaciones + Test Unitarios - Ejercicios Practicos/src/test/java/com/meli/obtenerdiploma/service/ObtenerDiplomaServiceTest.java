package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    StudentDTO student;

    @BeforeEach
    public void setUp() {
        student = new StudentDTO();
        student.setId(1L);
        student.setStudentName("Juan");
        student.setSubjects(List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        ));
        student.setMessage("El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.");
        student.setAverageScore(7.3);
    }

    @Test
    @DisplayName("Obtener estudiante con su promedio y un mensaje.")
    public void analyzeScoresTest() {
        when(studentDAO.findById(1L)).thenReturn(student);

        StudentDTO studentDTO = obtenerDiplomaService.analyzeScores(1L);
        Assertions.assertEquals(student, studentDTO);
    }

    @Test
    @DisplayName("El id del estudiante no existe.")
    public void analyzeScoresNotStudentFoundTest() {
        when(studentDAO.findById(1L)).thenReturn(null);

        Assertions.assertThrows(NullPointerException.class, () -> obtenerDiplomaService.analyzeScores(1L));
    }
}
