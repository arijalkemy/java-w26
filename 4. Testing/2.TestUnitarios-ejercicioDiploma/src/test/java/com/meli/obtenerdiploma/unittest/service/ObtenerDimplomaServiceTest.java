package com.meli.obtenerdiploma.unittest.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@DisplayName("Tests para ObtenerDiplomaService")
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ObtenerDimplomaServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService diplomaService;

    private StudentDTO mockStudent;

    @BeforeEach
    public void setUp() {
        mockStudent = new StudentDTO();
        mockStudent.setId(1L);
        mockStudent.setStudentName("Juan");
    }

    @Nested
    @DisplayName("Tests para calculateAverage")
    class CalculateAverageTests {

        @Test
        @DisplayName("Calcular promedio con notas de 5.0")
        void calculateAverageTest() {
            List<SubjectDTO> subjects = new ArrayList<>();
            Double averageExpected = 5.0;
            SubjectDTO matematicas = new SubjectDTO("matematicas", 5.0);
            SubjectDTO biologia = new SubjectDTO("biologia", 5.0);
            SubjectDTO espanol = new SubjectDTO("español", 5.0);
            subjects.add(matematicas);
            subjects.add(biologia);
            subjects.add(espanol);
            mockStudent.setSubjects(subjects);

            when(studentDAO.findById(1L)).thenReturn(mockStudent);

            StudentDTO studentDTO = diplomaService.analyzeScores(1L);
            verify(studentDAO, atLeast(1)).findById(1L);
            assertThat(averageExpected).isEqualTo(studentDTO.getAverageScore());
        }

        @Test
        @DisplayName("Test para cuando se pasa un id Nulo")
        public void testAnalyzeScores_NullStudentId() {
            Long studentId = null;
            assertThrows(NullPointerException.class, () -> diplomaService.analyzeScores(studentId));
        }

        @Test
        public void testAnalyzeScores_EmptySubjectsList() {
            mockStudent.setSubjects(new ArrayList<>()); // Lista de asignaturas vacía

            when(studentDAO.findById(mockStudent.getId())).thenReturn(mockStudent);

            StudentDTO result = diplomaService.analyzeScores(mockStudent.getId());

            assertEquals("El alumno Juan ha obtenido un promedio de NaN. Puedes mejorar.", result.getMessage());
        }


        @Test
        @DisplayName("Calcular promedio mayor que 9.0")
        void calculateAverageGreaterThan9Test() {
            List<SubjectDTO> subjects = new ArrayList<>();
            Double averageExpected = 9.5;
            SubjectDTO matematicas = new SubjectDTO("matematicas", 9.5);
            SubjectDTO biologia = new SubjectDTO("biologia", 9.5);
            SubjectDTO espanol = new SubjectDTO("español", 9.5);
            subjects.add(matematicas);
            subjects.add(biologia);
            subjects.add(espanol);
            mockStudent.setSubjects(subjects);

            when(studentDAO.findById(1L)).thenReturn(mockStudent);

            StudentDTO studentDTO = diplomaService.analyzeScores(1L);
            verify(studentDAO, atLeast(1)).findById(1L);
            assertThat(averageExpected).isEqualTo(studentDTO.getAverageScore());
        }
    }

    @Nested
    @DisplayName("Tests para getGreetingMessage")
    class GetGreetingMessageTests {

        @Test
        @DisplayName("Obtener mensaje de felicitación")
        void getGreetingMessageTest() {
            List<SubjectDTO> subjects = new ArrayList<>();
            SubjectDTO matematicas = new SubjectDTO("matematicas", 9.5);
            SubjectDTO biologia = new SubjectDTO("biologia", 9.5);
            SubjectDTO espanol = new SubjectDTO("español", 9.5);
            subjects.add(matematicas);
            subjects.add(biologia);
            subjects.add(espanol);
            mockStudent.setSubjects(subjects);
            mockStudent.setAverageScore(9.5);
            String messageExpected = "El alumno " + mockStudent.getStudentName() + " ha obtenido un promedio de "
                    + new DecimalFormat("#.##")
                    .format(mockStudent.getAverageScore())
                    + ". Felicitaciones!";

            when(studentDAO.findById(1L)).thenReturn(mockStudent);

            StudentDTO studentDTO = diplomaService.analyzeScores(1L);
            verify(studentDAO, atLeast(1)).findById(1L);
            assertThat(messageExpected).isEqualTo(studentDTO.getMessage());
        }
    }
}
