package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTests {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService service;

    @Test
    public void testAnalyzeScoresNoStudentFound() {
        when(studentDAO.findById(87L)).thenThrow(new StudentNotFoundException(87L));

        assertThrows(StudentNotFoundException.class, () -> {
            service.analyzeScores(87L);
        });
    }


    @Test
    public void testAnalyzeScoresEmptySubjectsList() {
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        student.setStudentName("John Doe");
        student.setSubjects(new ArrayList<>());

        when(studentDAO.findById(1L)).thenReturn(student);

        StudentDTO analyzedStudent = service.analyzeScores(1L);

        assertEquals("El alumno John Doe ha obtenido un promedio de NaN. Puedes mejorar.", analyzedStudent.getMessage());
    }

    @Test
    public void testAnalyzeScoresCalculateAverage() {
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        student.setStudentName("John Doe");
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Math", 90.0));
        subjects.add(new SubjectDTO("Science", 80.0));
        student.setSubjects(subjects);

        when(studentDAO.findById(1L)).thenReturn(student);

        StudentDTO analyzedStudent = service.analyzeScores(1L);

        assertEquals("El alumno John Doe ha obtenido un promedio de 85,00. Felicitaciones!", analyzedStudent.getMessage());
    }


}