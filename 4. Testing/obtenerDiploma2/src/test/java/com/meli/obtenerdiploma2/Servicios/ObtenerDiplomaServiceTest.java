package com.meli.obtenerdiploma2.Servicios;

import com.meli.obtenerdiploma2.model.StudentDTO;
import com.meli.obtenerdiploma2.model.SubjectDTO;
import com.meli.obtenerdiploma2.repository.IStudentDAO;
import com.meli.obtenerdiploma2.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    public StudentDTO studentWithHighScores;
    public StudentDTO studentWithLowScores;
    public StudentDTO studentWithNullScores;
    @Mock
    IStudentDAO student;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @BeforeEach
    public void setup(){

    }

    @Test
    @DisplayName("Test caso ideal de scores")
    void AverageScoresTest(){
        List<SubjectDTO> subject = List.of(
                new SubjectDTO("Matematicas", 4.0),
                new SubjectDTO("Quimica", 4.2));
        StudentDTO s1 = new StudentDTO();
        s1.setId((long)1);
        s1.setStudentName("Juanito");
        s1.setSubjects(subject);
        when(student.findById((long)1)).thenReturn(s1);
        StudentDTO s2 = obtenerDiplomaService.analyzeScores((long)1);
        Assertions.assertEquals(4.1, s2.getAverageScore() );
    }

    @Test
    @DisplayName("Test de estudiante con scores null")
    void nullScoresTest(){
        StudentDTO s1 = new StudentDTO();
        s1.setId((long)1);
        s1.setStudentName("Juanito");
        s1.setSubjects(null);
        when(student.findById((long)1)).thenReturn(s1);
        Assertions.assertThrows(NullPointerException.class, () -> obtenerDiplomaService.analyzeScores((long)1));
    }

    @Test
    @DisplayName("Test de estudiante con promedio inferior a 9")
    void getBadMessageTest(){
        List<SubjectDTO> subject = List.of(
                new SubjectDTO("Matematicas", 4.0),
                new SubjectDTO("Quimica", 4.2));
        StudentDTO s1 = new StudentDTO();
        s1.setId((long)1);
        s1.setStudentName("Juanito");
        s1.setSubjects(subject);
        when(student.findById((long)1)).thenReturn(s1);
        StudentDTO s2 = obtenerDiplomaService.analyzeScores((long)1);
        Assertions.assertEquals("El alumno Juanito ha obtenido un promedio de 4,1. Puedes mejorar.", s2.getMessage() );
    }

    @Test
    @DisplayName("Test de estudiante con promedio superior a 9")
    void getGoodMessageTest(){
        List<SubjectDTO> subject = List.of(
                new SubjectDTO("Matematicas", 10.0),
                new SubjectDTO("Quimica", 9.2));
        StudentDTO s1 = new StudentDTO();
        s1.setId((long)1);
        s1.setStudentName("Juanito");
        s1.setSubjects(subject);
        when(student.findById((long)1)).thenReturn(s1);
        StudentDTO s2 = obtenerDiplomaService.analyzeScores((long)1);
        Assertions.assertEquals("El alumno Juanito ha obtenido un promedio de 9,6. Felicitaciones!", s2.getMessage() );
    }
}
