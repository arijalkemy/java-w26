package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void analyzeScoresOkTest() {
        // Arrange
        Long id = 1L;
        List<SubjectDTO> subjects = new ArrayList<>(){{
            add(new SubjectDTO(
                "Matemática",
                9.0
            ));
            add(new SubjectDTO(
                "Química",
                6.0
            ));
        }};

        StudentDTO student = new StudentDTO();
        student.setId(id);
        student.setStudentName("Pepito");
        student.setSubjects(subjects);

        StudentDTO expectedResult = new StudentDTO(
            id,
            "Pepito",
            "El alumno Pepito ha obtenido un promedio de 7,5. Puedes mejorar.",
            7.5,
            subjects
        );

        when(studentDAO.findById(student.getId())).thenReturn(student); // Definir el comportamiento del mock

        // Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(id); // (ejecutar el método a testear)

        // Assert
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void analyzeScoresStudentNotFoundExceptionTest() {
        // Arrange
        Long id = 1L;
        when(studentDAO.findById(id)).thenThrow(StudentNotFoundException.class); // Definir el comportamiento del mock

        // Act & Assert
        Assertions.assertThrows(
            StudentNotFoundException.class,
            () -> obtenerDiplomaService.analyzeScores(id));
    }

    @Test
    void calculateAverageProperlyTest() {
        // Arrange
        Long id = 1L;
        List<SubjectDTO> subjects = new ArrayList<>(){{
            add(new SubjectDTO(
                "Matemática",
                9.0
            ));
            add(new SubjectDTO(
                "Química",
                6.0
            ));
        }};

        StudentDTO student = new StudentDTO();
        student.setId(id);
        student.setStudentName("Pepito");
        student.setSubjects(subjects);

        Double expectedResult = 7.5;

        when(studentDAO.findById(student.getId())).thenReturn(student); // Definir el comportamiento del mock

        // Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(id); // (ejecutar el método a testear)

        // Assert
        Assertions.assertEquals(expectedResult, result.getAverageScore());
    }

    @Test
    void getGreetingMessageBelow9Test() {
        // Arrange
        Long id = 1L;
        List<SubjectDTO> subjects = new ArrayList<>(){{
            add(new SubjectDTO(
                "Matemática",
                9.0
            ));
            add(new SubjectDTO(
                "Química",
                6.0
            ));
        }};

        StudentDTO student = new StudentDTO();
        student.setId(id);
        student.setStudentName("Pepito");
        student.setSubjects(subjects);

        String expectedResult = "El alumno Pepito ha obtenido un promedio de 7,5. Puedes mejorar.";

        when(studentDAO.findById(student.getId())).thenReturn(student); // Definir el comportamiento del mock

        // Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(id); // (ejecutar el método a testear)

        // Assert
        Assertions.assertEquals(expectedResult, result.getMessage());
    }

    @Test
    void getGreetingMessageAbove9Test() {
        // Arrange
        Long id = 1L;
        List<SubjectDTO> subjects = new ArrayList<>(){{
            add(new SubjectDTO(
                "Matemática",
                9.0
            ));
            add(new SubjectDTO(
                "Química",
                10.0
            ));
        }};

        StudentDTO student = new StudentDTO();
        student.setId(id);
        student.setStudentName("Pepito");
        student.setSubjects(subjects);

        String expectedResult = "El alumno Pepito ha obtenido un promedio de 9,5. Felicitaciones!";

        when(studentDAO.findById(student.getId())).thenReturn(student); // Definir el comportamiento del mock

        // Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(id); // (ejecutar el método a testear)

        // Assert
        Assertions.assertEquals(expectedResult, result.getMessage());
    }

    @Test
    void requestStudentNameMatchesResponseStudentNameTest() {
        // Arrange
        Long id = 1L;
        List<SubjectDTO> subjects = new ArrayList<>(){{
            add(new SubjectDTO(
                "Matemática",
                9.0
            ));
            add(new SubjectDTO(
                "Química",
                10.0
            ));
        }};

        StudentDTO student = new StudentDTO();
        student.setId(id);
        student.setStudentName("Pepito");
        student.setSubjects(subjects);

        String expectedResult = "Pepito";

        when(studentDAO.findById(student.getId())).thenReturn(student); // Definir el comportamiento del mock

        // Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(id); // (ejecutar el método a testear)

        // Assert
        Assertions.assertEquals(expectedResult, result.getStudentName());
    }

    @Test
    void requestStudentSubjectListMatchesResponseStudentSubjectListTest() {
        // Arrange
        Long id = 1L;
        List<SubjectDTO> subjects = new ArrayList<>(){{
            add(new SubjectDTO(
                "Matemática",
                9.0
            ));
            add(new SubjectDTO(
                "Química",
                10.0
            ));
        }};

        StudentDTO student = new StudentDTO();
        student.setId(id);
        student.setStudentName("Pepito");
        student.setSubjects(subjects);

        List<SubjectDTO> expectedResult = subjects;

        when(studentDAO.findById(student.getId())).thenReturn(student); // Definir el comportamiento del mock

        // Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(id); // (ejecutar el método a testear)

        // Assert
        Assertions.assertEquals(expectedResult, result.getSubjects());
    }
}
