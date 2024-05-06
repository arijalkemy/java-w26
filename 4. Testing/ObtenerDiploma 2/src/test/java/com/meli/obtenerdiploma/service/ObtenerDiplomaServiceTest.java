package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    IStudentDAO iStudentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    private StudentDTO studentDTO;

    @BeforeEach
    void setupTest(){
        studentDTO = new StudentDTO();
        studentDTO.setStudentName("Juan");
        studentDTO.setId(1L);
    }

    @Test
    void testAnalyzeScores(){
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Matematicas", 9.0),
                new SubjectDTO("Física", 9.0),
                new SubjectDTO("Logica", 9.0)
        );
        studentDTO.setSubjects(subjects);
        when(iStudentDAO.findById(1L)).thenReturn(studentDTO);

        obtenerDiplomaService.analyzeScores(1L);
        assertEquals(9, studentDTO.getAverageScore());
    }

    @Test
    void testAnalyzeScoresWithIdInvalid(){
        when(iStudentDAO.findById(2L)).thenThrow(StudentNotFoundException.class);
        assertThrows(StudentNotFoundException.class, () -> {
            obtenerDiplomaService.analyzeScores(2L);
        });
    }

    @Test
    void testAnalyzeMessageDisapproved(){
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Matematicas", 3.0),
                new SubjectDTO("Física", 6.0),
                new SubjectDTO("Logica", 4.0)
        );
        studentDTO.setSubjects(subjects);
        when(iStudentDAO.findById(1L)).thenReturn(studentDTO);

        obtenerDiplomaService.analyzeScores(1L);
        assertEquals("El alumno " + studentDTO.getStudentName() + " ha obtenido un promedio de 4.33. Puedes mejorar.", studentDTO.getMessage());
    }

    @Test
    void testAnalyzeMessageApproved(){
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Matematicas", 9.0),
                new SubjectDTO("Física", 9.75),
                new SubjectDTO("Logica", 9.5)
        );
        studentDTO.setSubjects(subjects);
        when(iStudentDAO.findById(1L)).thenReturn(studentDTO);

        obtenerDiplomaService.analyzeScores(1L);
        assertEquals("El alumno " + studentDTO.getStudentName() + " ha obtenido un promedio de 9.42. Felicitaciones!", studentDTO.getMessage());
    }
}
