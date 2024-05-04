package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTests {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService diplomaService;

    @Test
    @DisplayName("Calcula el promedio de la nota de un estudiante exitosamente")
    public void averageScoreWellCalculated(){
        //arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        when(studentDAO.findById(student.getId())).thenReturn(student);
        //act
        diplomaService.analyzeScores(student.getId());
        //assert
        verify(studentDAO,atLeastOnce()).findById(student.getId());
        assertEquals(6.0,student.getAverageScore());
    }
    @Test
    @DisplayName("Puntuación media por encima de 9, Mensaje de respuesta bien escrito")
    public void averageScoreOver9MessageWellWritten() {
        // arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Marco");
        when(studentDAO.findById(student.getId())).thenReturn(student);

        // act
        diplomaService.analyzeScores(student.getId());

        // assert
        verify(studentDAO, atLeastOnce()).findById(student.getId());
        assertEquals("El alumno Marco ha obtenido un promedio de 9,00. Felicitaciones!", student.getMessage());
    }

    @Test
    @DisplayName("Puntuación media Por debajo de 9 Mensaje de respuesta bien escrito")
    public void averageScoreBelow9MessageWellWritten() {
        // arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        when(studentDAO.findById(student.getId())).thenReturn(student);

        // act
        diplomaService.analyzeScores(student.getId());

        // assert
        verify(studentDAO, atLeastOnce()).findById(student.getId());
        assertEquals("El alumno Marco ha obtenido un promedio de 6,00. Puedes mejorar.", student.getMessage());
    }

    @Test
    @DisplayName("Nombre del alumno Coincide con la respuesta Nombre del alumno")
    public void RequestStudentNameMatchesResponseStudentName() {
        // arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        when(studentDAO.findById(student.getId())).thenReturn(student);

        // act
        diplomaService.analyzeScores(student.getId());

        // assert
        verify(studentDAO, atLeastOnce()).findById(student.getId());
        assertEquals("Marco", student.getStudentName());
    }

    @Test
    @DisplayName("lista de materias de la solicitud coincide con la lista de materias de la respuesta")
    public void RequestStudentSubjectListMatchesResponseSubjectList() {
        // arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        List<SubjectDTO> initalList = new ArrayList<>();
        student.getSubjects().stream().forEach(s -> initalList.add(s));

        when(studentDAO.findById(student.getId())).thenReturn(student);

        // act
        diplomaService.analyzeScores(student.getId());

        // assert
        verify(studentDAO, atLeastOnce()).findById(student.getId());
        assertTrue(CollectionUtils.isEqualCollection(initalList, student.getSubjects()));
    }
}
