package com.meli.obtenerdiploma.units.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DecimalFormat;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Analiza el score del usuario con un subject, debería dar un mensaje de felicitaciones")
    public void analizarScoreFelicitacionesTest() {
        StudentDTO studentDTO = TestUtils.createPersonalizedStudentDTO(1L, "Pepito", "Mensaje",
                0.0, List.of(new SubjectDTO("Matematicas", 10.0)));

        StudentDTO expected = TestUtils.createPersonalizedStudentDTO(1L, "Pepito", "El alumno " +
                        studentDTO.getStudentName() + " ha obtenido un promedio de " + new DecimalFormat("#.##")
                        .format(10.0)+ ". Felicitaciones!",
                10.0, List.of(new SubjectDTO("Matematicas", 10.0)));

        when(studentDAO.findById(1L)).thenReturn(studentDTO);

        StudentDTO actual = obtenerDiplomaService.analyzeScores(studentDTO.getId());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Analiza el score del usuario con un subject, debería dar un mensaje de que puede mejorar")
    public void analizarScorePuedeMejorarTest() {
        StudentDTO studentDTO = TestUtils.createPersonalizedStudentDTO(1L, "Pepito", "Mensaje",
                0.0, List.of(new SubjectDTO("Matematicas", 7.0)));

        StudentDTO expected = TestUtils.createPersonalizedStudentDTO(1L, "Pepito", "El alumno " +
                        studentDTO.getStudentName() + " ha obtenido un promedio de " + new DecimalFormat("#.##")
                        .format(7.0)+ ". Puedes mejorar.",
                7.0, List.of(new SubjectDTO("Matematicas", 7.0)));

        when(studentDAO.findById(1L)).thenReturn(studentDTO);

        StudentDTO actual = obtenerDiplomaService.analyzeScores(studentDTO.getId());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Analiza el score del usuario con más de un subject, debería dar un mensaje de felicitaciones")
    public void analizarScoreFelicitacionesMultiplesSubjectsTest() {
        StudentDTO studentDTO = TestUtils.createPersonalizedStudentDTO(1L, "Pepito", "Mensaje",
                0.0, List.of(new SubjectDTO("Matematicas", 10.0),
                        new SubjectDTO("Biologia", 11.0),
                        new SubjectDTO("Sociales", 10.0)));

        StudentDTO expected = TestUtils.createPersonalizedStudentDTO(1L, "Pepito", "El alumno " +
                        studentDTO.getStudentName() + " ha obtenido un promedio de " + new DecimalFormat("#.##")
                        .format(10.33)+ ". Felicitaciones!",
                10.333333333333334, List.of(new SubjectDTO("Matematicas", 10.0),
                        new SubjectDTO("Biologia", 11.0),
                        new SubjectDTO("Sociales", 10.0)));

        when(studentDAO.findById(1L)).thenReturn(studentDTO);

        StudentDTO actual = obtenerDiplomaService.analyzeScores(studentDTO.getId());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Analiza el score del usuario con más de un subject, debería dar un mensaje de que puede mejorar")
    public void analizarScorePuedeMejorarMultiplesSubjectsTest() {
        StudentDTO studentDTO = TestUtils.createPersonalizedStudentDTO(1L, "Pepito", "Mensaje",
                0.0, List.of(new SubjectDTO("Matematicas", 7.0),
                        new SubjectDTO("Biologia", 3.0),
                        new SubjectDTO("Sociales", 4.0)));

        StudentDTO expected = TestUtils.createPersonalizedStudentDTO(1L, "Pepito", "El alumno " +
                        studentDTO.getStudentName() + " ha obtenido un promedio de " + new DecimalFormat("#.##")
                        .format(4.67)+ ". Puedes mejorar.",
                4.666666666666667, List.of(new SubjectDTO("Matematicas", 7.0),
                        new SubjectDTO("Biologia", 3.0),
                        new SubjectDTO("Sociales", 4.0)));

        when(studentDAO.findById(1L)).thenReturn(studentDTO);

        StudentDTO actual = obtenerDiplomaService.analyzeScores(studentDTO.getId());

        Assertions.assertEquals(expected, actual);
    }
}
