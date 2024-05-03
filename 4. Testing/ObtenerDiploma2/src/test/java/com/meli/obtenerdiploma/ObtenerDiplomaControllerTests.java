package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTests {
    @Mock
    private IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    private ObtenerDiplomaController obtenerDiplomaController;
    private StudentDTO studentDTO9;
    private StudentDTO studentDTOmenos;

    @BeforeEach
    void setUp() {
        studentDTO9 = new StudentDTO();
        studentDTO9.setStudentName("Juan");
        studentDTO9.setId(0L);

        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática", 10.0));
        subjectDTOList.add(new SubjectDTO("Física", 9.0));

        studentDTO9.setSubjects(subjectDTOList);

        studentDTOmenos = new StudentDTO();
        studentDTOmenos.setId(1L);
        studentDTOmenos.setStudentName("José");

        List<SubjectDTO> subjectDTOListMenos = new ArrayList<>();
        subjectDTOListMenos.add(new SubjectDTO("Matemática", 4.0));

        studentDTOmenos.setSubjects(subjectDTOListMenos);
    }

    @Test
    public void analyzeScoresCorrectlyGoodGrades(){
        StudentDTO expected = studentDTO9;
        expected.setMessage("El alumno Juan ha obtenido un promedio de " + new DecimalFormat("#.##")
                .format(9.5) + ". Felicitaciones!");
        expected.setAverageScore(9.5);

        when(obtenerDiplomaService.analyzeScores(0L)).thenReturn(expected);

        StudentDTO actual = obtenerDiplomaController.analyzeScores(0L);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void analyzeScoresCorrectlyBadGrades(){
        StudentDTO expected = studentDTO9;
        expected.setMessage("El alumno José ha obtenido un promedio de " + new DecimalFormat("#.##")
                .format(4) + ". Puedes mejorar.");
        expected.setAverageScore(4.0);

        when(obtenerDiplomaService.analyzeScores(1L)).thenReturn(expected);

        StudentDTO actual = obtenerDiplomaController.analyzeScores(1L);
        Assertions.assertEquals(expected, actual);
    }
}
