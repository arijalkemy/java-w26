package meli.bootcamp.obtenerdiplomacrud.service;

import meli.bootcamp.obtenerdiplomacrud.model.StudentDTO;
import meli.bootcamp.obtenerdiplomacrud.model.SubjectDTO;
import meli.bootcamp.obtenerdiplomacrud.repository.IStudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class IObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @BeforeEach
    void setUp() {
        when(studentDAO.findById(1L)).thenReturn(new StudentDTO(1L, "Juan", null, null, List.of(
                new SubjectDTO("Matemática", 9D),
                new SubjectDTO("Física", 7D),
                new SubjectDTO("Química", 6D)
        )));

        when(studentDAO.findById(2L)).thenReturn(new StudentDTO(2L, "Pedro", null, null, List.of(
                new SubjectDTO("Matemática", 9D),
                new SubjectDTO("Física", 10D),
                new SubjectDTO("Química", 10D)
        )));
    }

    @Test
    @DisplayName("StudentDTO average score")
    void analyzeScoresAverageScore() {
        StudentDTO obtained = obtenerDiplomaService.analyzeScores(1L);

        assertEquals((double) (9 + 7 + 6) /3, obtained.getAverageScore());
    }

    @Test
    @DisplayName("StudentDTO with the regular message")
    void analyzeScoresRegularMessageAndScore() {

        StudentDTO obtained = obtenerDiplomaService.analyzeScores(1L);

        assertEquals("El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.", obtained.getMessage());
    }

    @Test
    @DisplayName("StudentDTO with the congratulations message")
    void analyzeScoresCongratulationsMessage() {
        StudentDTO obtained = obtenerDiplomaService.analyzeScores(2L);

        assertEquals("El alumno Pedro ha obtenido un promedio de 9,67. Felicitaciones!", obtained.getMessage());
    }


}