package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {
    @Mock
    IObtenerDiplomaService diplomaService;
    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    @DisplayName("Probando el promedio")
    public void testAnalyzeScores(){
        SubjectDTO subjectOne = new SubjectDTO("Taller",9.0);
        SubjectDTO subjectTwo = new SubjectDTO("Religion",7.0);
        StudentDTO studentDTO = new StudentDTO(2L,"Reverendo alegria","",0.0, List.of(subjectOne,subjectTwo));

        obtenerDiplomaController.analyzeScores(studentDTO.getId());

        verify(diplomaService,atLeastOnce()).analyzeScores(studentDTO.getId());
    }
}
