package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {
    @Mock
    ObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController controller;

    @Test
    public void AnalyzeScoresOk(){
        long studentId=1L;

        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Ingles",4.0));
        subjectDTOList.add(new SubjectDTO("Lengua",0.0));

        StudentDTO studentExptected = StudentDTO.builder()
                .id(1L)
                .averageScore(2.0)
                .subjects(subjectDTOList)
                .build();
        when(service.analyzeScores(studentId)).thenReturn(studentExptected);
        StudentDTO studentObtained = controller.analyzeScores(studentId);

        Assertions.assertEquals(studentExptected, studentObtained);
    }

}
