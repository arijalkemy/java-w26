package com.meli.obtenerdiploma.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

class ObtenerDiplomaServiceTest {

    public static  ObtenerDiplomaService underTest;

    @BeforeAll
    public static void init() {
        underTest = new ObtenerDiplomaService();
    }

    @Test
    void messageShouldBeTest() {
        StudentDTO input = buildDto();
        StudentDTO result = underTest.analyzeScores(input);
        assertEquals(input.getMessage(), result.getMessage());
    }

    @Test
    void averageScoreShouldBeNineTest() {
        StudentDTO input = buildDto();
        StudentDTO result = underTest.analyzeScores(input);
        assertEquals(input.getAverageScore(), result.getAverageScore());
    }

    @Test
    void giveOverNineAvgScore_whenAnalyzeScore_resultFelicitaciones_test() {
        StudentDTO input = buildDto();
        input.getSubjects().add(new SubjectDTO("D", 10.0));
        StudentDTO result = underTest.analyzeScores(input);
        assertTrue(result.getMessage().contains("Felicitaciones!"));
    }

    @Test
    void giveLessNineAvgScore_whenAnalyzeScore_resultPuedesMejorar_test() {
        StudentDTO input = buildDto();
        StudentDTO result = underTest.analyzeScores(input);
        assertTrue(result.getMessage().contains("Puedes mejorar."));
    }

    private StudentDTO buildDto() {
        StudentDTO mock = new StudentDTO();
        SubjectDTO aSubject = new SubjectDTO("A", 9.0);
        SubjectDTO bSubject = new SubjectDTO("B", 8.0);
        SubjectDTO cSubject = new SubjectDTO("C", 10.0);
        String resultMessage = "El alumno Leo ha obtenido un promedio de 9.0. Puedes mejorar";

        mock.setAverageScore(9.0);
        mock.setSubjects(new ArrayList<>(List.of(aSubject, bSubject, cSubject)));
        mock.setStudentName(resultMessage);
        mock.setMessage(resultMessage);
        return mock;
    }

}
