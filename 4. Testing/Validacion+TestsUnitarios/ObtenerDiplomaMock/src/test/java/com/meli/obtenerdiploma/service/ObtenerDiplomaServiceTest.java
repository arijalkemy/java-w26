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

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    private StudentDTO studentDTO;

    @BeforeEach
    public void setup(){
        this.studentDTO = new StudentDTO();
        this.studentDTO.setStudentName("Facundo");
        this.studentDTO.setMessage("");
        this.studentDTO.setId(3l);
        when(studentDAO.findById(3l)).thenReturn(this.studentDTO);
    }

    @Test
    @DisplayName("Cuando el promedio de notas es menor a 9")
    public void testAnalyzeScoresMin(){
        List<SubjectDTO> subjectDTOList= new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matematica", 3.0));
        subjectDTOList.add(new SubjectDTO("Fisica", 10.0));
        subjectDTOList.add(new SubjectDTO("Quimica", 8.0));
        this.studentDTO.setSubjects(subjectDTOList);

        StudentDTO studentDTO1= obtenerDiplomaService.analyzeScores(1l);
        assertEquals(7.0, studentDTO1.getAverageScore());
    }

    @Test
    @DisplayName("Cuando el promedio de notas es mayor a 9")
    public void testAnalyzeScoreMax(){
        List<SubjectDTO> subjectDTOList= new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matematica", 10.0));
        subjectDTOList.add(new SubjectDTO("Fisica", 10.0));
        subjectDTOList.add(new SubjectDTO("Quimica", 7.0));
        this.studentDTO.setSubjects(subjectDTOList);

        StudentDTO studentDTO1 = obtenerDiplomaService.analyzeScores(1l);
        assertEquals(9.0, studentDTO1.getAverageScore());
    }


}
