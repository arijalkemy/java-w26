package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(value = MockitoExtension.class)
public class ObtenerDiplomaControllerTests {
    @Mock
    IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;
    private StudentDTO estudiant;
    private long id = 1L;

    @BeforeEach
    public void setUp() {
        estudiant = new StudentDTO();
        estudiant.setStudentName("Pepe");
        estudiant.setId(1L);

        List<SubjectDTO> materias = new ArrayList<>();
        materias.add(new SubjectDTO("Matematica", 9.0));
        materias.add(new SubjectDTO("Historia", 8.0));
        materias.add(new SubjectDTO("Fisica", 10.0));

        estudiant.setSubjects(materias);
    }

    @Test
    @DisplayName("Mostrar correctamente datos del diploma")
    public void obtenerDatosDeDiplomaTest(){
        when(obtenerDiplomaService.analyzeScores(id)).thenReturn(estudiant);

        double averageScore = estudiant.getSubjects().stream().mapToDouble(SubjectDTO::getScore)
                                                    .average().orElse(0.0);
        estudiant.setAverageScore(averageScore);

        StudentDTO obtenido = obtenerDiplomaController.analyzeScores(1L);

        Assertions.assertEquals("Pepe", obtenido.getStudentName());
        Assertions.assertEquals(9.0,obtenido.getAverageScore());
    }
}
