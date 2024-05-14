package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    private StudentDAO dao;

    @InjectMocks
    private ObtenerDiplomaService service;

    @Test
    public void analyzeDiplomaTest() {
        StudentDTO student = new StudentDTO(1L, "Edwin", "student test", 9.00, List.of(
                new SubjectDTO("Math", 10.0),
                new SubjectDTO("Spanish", 80.0)
        ));
        when(dao.findById(student.getId())).thenReturn(student);
        Double average = student.getSubjects().stream().mapToDouble(SubjectDTO::getScore).average().orElse(0.0);
        String greeting = "El alumno " + student.getStudentName() + " ha obtenido un promedio de " +
                new DecimalFormat("#.##").format(average) + ". Felicitaciones!";

        StudentDTO actual = service.analyzeScores(1L);

        Assertions.assertEquals(student.getId(), actual.getId());
        Assertions.assertEquals(student.getStudentName(), actual.getStudentName());
        Assertions.assertEquals(average, actual.getAverageScore());
        Assertions.assertEquals(greeting, actual.getMessage());
    }

    @Test
    public void analyzeDiplomaEmptyTest() {
        StudentDTO student = new StudentDTO(1L, "Edwin", "student test", 9.00, List.of());
        when(dao.findById(student.getId())).thenReturn(student);
        Double average = student.getSubjects().stream().mapToDouble(SubjectDTO::getScore).average().orElse(0.0);
        String greeting = "El alumno " + student.getStudentName() + " ha obtenido un promedio de " +
                new DecimalFormat("#.##").format(average) + ". Puedes mejorar.";

        StudentDTO actual = service.analyzeScores(1L);

        Assertions.assertEquals(average, actual.getAverageScore());
        Assertions.assertEquals(greeting, actual.getMessage());
    }

    @Test
    public void analyzeDiplomaNullTest() {
        StudentDTO student = new StudentDTO(1L, "Edwin", "student test", 9.00, null);
        when(dao.findById(student.getId())).thenReturn(student);
        Assertions.assertThrows(NullPointerException.class, () -> service.analyzeScores(1L));
    }
}
