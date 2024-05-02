package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {
    @Mock
    private IStudentDAO studentDAO;
    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;
    private StudentDTO studentWithHonorsDTO;
    private StudentDTO studentWithoutHonorsDTO;

    @BeforeEach
    public void setup() {
        this.studentWithoutHonorsDTO = new StudentDTO(
                1L,
                "EstudianteRegular",
                "",
                0.0,
                List.of(
                        new SubjectDTO("Matematica", 8.0),
                        new SubjectDTO("Lengua", 8.0)
                ));
        this.studentWithHonorsDTO = new StudentDTO(
                2L,
                "EstudianteConHonores",
                "",
                0.0,
                List.of(
                        new SubjectDTO("Matematica", 10.0),
                        new SubjectDTO("Lengua", 9.0)
                ));

    }

    @Test
    @DisplayName("Devuelve promedio")
    void analyzeScores() {
        when(studentDAO.findById(2L)).thenReturn(studentWithHonorsDTO);
        StudentDTO computedStudent = obtenerDiplomaService.analyzeScores(2L);
        verify(studentDAO, atLeast(1)).findById(2L);
        assertEquals(9.5, computedStudent.getAverageScore());
    }

    @Test
    @DisplayName("Devuelve mensaje de alumno regular que puede mejorar")
    void analyzeMessageWithoutHonors() {
        when(studentDAO.findById(1L)).thenReturn(studentWithoutHonorsDTO);
        StudentDTO computedStudent = obtenerDiplomaService.analyzeScores(1L);
        verify(studentDAO, atLeast(1)).findById(1L);
        assertEquals(
                "El alumno EstudianteRegular ha obtenido un promedio de 8. Puedes mejorar.",
                computedStudent.getMessage()
        );
    }

    @Test
    @DisplayName("Devuelve alumno con honores y felicitaciones")
    void analyzeMessageWithHonors() {
        when(studentDAO.findById(2L)).thenReturn(studentWithHonorsDTO);
        StudentDTO computedStudent = obtenerDiplomaService.analyzeScores(2L);
        verify(studentDAO, atLeast(1)).findById(2L);
        assertEquals(
                "El alumno EstudianteConHonores ha obtenido un promedio de 9,5. Felicitaciones!",
                computedStudent.getMessage()
        );
    }
}