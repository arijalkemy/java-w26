package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void analizeScoreShouldCalculateAverageBelowNine() {
        StudentDTO studentDTO = new StudentDTO(1L, "Monica", "genial", 50D,
                List.of(new SubjectDTO("Matematicas", 8D),
                        new SubjectDTO("biologia", 5D),
                        new SubjectDTO("politica", 6.5D)));

        when(studentDAO.findById(1L)).thenReturn(studentDTO);
        StudentDTO response = obtenerDiplomaService.analyzeScores(1L);

        String expectedMessage = "El alumno Monica ha obtenido un promedio de 6,5. Puedes mejorar.";
        Assertions.assertEquals(6.5D, response.getAverageScore());
        Assertions.assertEquals(expectedMessage, response.getMessage());

    }

    @Test
    void analizeScoreShouldThrowNullPointerException() {
        StudentDTO studentDTO = new StudentDTO(1L, "Monica", "genial", 50D,
                null);

        when(studentDAO.findById(1L)).thenReturn(studentDTO);

        Assertions.assertThrows(NullPointerException.class,
                () -> obtenerDiplomaService.analyzeScores(1L));

    }

    @Test

    void analizeScoreShouldCalculateAverageUperNine(){
        StudentDTO studentDTO = new StudentDTO(2L, "Cristina", "Felicitaciones", 50D,
                List.of(new SubjectDTO("Matematicas", 9.5D),
                        new SubjectDTO("biologia", 9.5D),
                        new SubjectDTO("politica", 9.5D)));

        when(studentDAO.findById(2L)).thenReturn(studentDTO);
        StudentDTO response = obtenerDiplomaService.analyzeScores(2L);
        String expectedMessage = "El alumno Cristina ha obtenido un promedio de 9,5. Felicitaciones!";
        Assertions.assertEquals(expectedMessage, response.getMessage());

    }


}

