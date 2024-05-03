package com.meli.obtenerdiploma.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO daoMock;

    @InjectMocks
    private ObtenerDiplomaService underTest;


    @Test
    void messageShouldBeTest() {
        StudentDTO input = buildDto();
        when(daoMock.findById(input.getId())).thenReturn(input);
        StudentDTO result = underTest.analyzeScores(input.getId());
        assertEquals(input.getMessage(), result.getMessage());
    }

    @Test
    void averageScoreShouldBeNineTest() {
        StudentDTO input = buildDto();
        when(daoMock.findById(input.getId())).thenReturn(input);
        StudentDTO result =  underTest.analyzeScores(input.getId());
        assertEquals(input.getAverageScore(), result.getAverageScore());
    }

    @Test
    void giveOverNineAvgScore_whenAnalyzeScore_resultFelicitaciones_test(){
        StudentDTO input = buildDto();
        input.getSubjects().add(new SubjectDTO("D", 10.0));
        when(daoMock.findById(input.getId())).thenReturn(input);
        StudentDTO result =  underTest.analyzeScores(input.getId());
        assertTrue(result.getMessage().contains("Felicitaciones!"));
    }


    @Test
    void giveLessNineAvgScore_whenAnalyzeScore_resultPuedesMejorar_test(){
        StudentDTO input = buildDto();
        when(daoMock.findById(input.getId())).thenReturn(input);
        StudentDTO result =  underTest.analyzeScores(input.getId());
        assertTrue(result.getMessage().contains("Puedes mejorar."));
    }

    

    private StudentDTO buildDto() {
        StudentDTO mock = new StudentDTO();
        SubjectDTO aSubject = new SubjectDTO("A", 9.0);
        SubjectDTO bSubject = new SubjectDTO("B", 8.0);
        SubjectDTO cSubject = new SubjectDTO("C", 10.0);
        String resultMessage = "El alumno Leo ha obtenido un promedio de 9.0. Puedes mejorar";

        mock.setAverageScore(9.0);
        mock.setId(1L);
        mock.setSubjects(new ArrayList<>(List.of(aSubject, bSubject, cSubject)));
        mock.setStudentName(resultMessage);
        mock.setMessage(resultMessage);
        return mock;
    }
        
}
