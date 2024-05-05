package com.meli.obtenerdiploma.service.happyPath;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OptenerDiplomaServiceHappyPathTest {

    @Mock
    StudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @BeforeEach
    public void setup(){
        StudentDTO student1 = new StudentDTO(
                0L,
                "Jose",
                "",
                0.0,
                Arrays.asList(
                        new SubjectDTO(
                                "Fisica",
                                10.0
                        ),
                        new SubjectDTO(
                                "Graficacion",
                                9.0
                        ),
                        new SubjectDTO(
                                "Circuitos",
                                6.0
                        )
                )
        );

        StudentDTO student2 = new StudentDTO(
                0L,
                "Abel",
                "",
                0.0,
                Arrays.asList(
                        new SubjectDTO(
                                "Matematicas",
                                8.0
                        ),
                        new SubjectDTO(
                                "Calculo",
                                9.0
                        ),
                        new SubjectDTO(
                                "IA",
                                6.0
                        )
                )
        );

        studentDAO.save(student1);
        studentDAO.save(student2);
    }

    @Test
    @DisplayName("it should return the same StudentDTO in input/output")
    public void studentDTOInputAndOutput(){
        // arrange
        StudentDTO studentInput = new StudentDTO(
                1L,
                "Jose",
                "",
                0.0,
                new ArrayList<SubjectDTO>(Arrays.asList(
                        new SubjectDTO(
                                "Fisica",
                                10.0
                        ),
                        new SubjectDTO(
                                "Graficacion",
                                9.0
                        ),
                        new SubjectDTO(
                                "Circuitos",
                                6.0
                        )
                )) {}
        );

        // act
        when(studentDAO.findById(1L)).thenReturn(studentInput);
        StudentDTO studentOutput  = obtenerDiplomaService.analyzeScores(studentInput.getId());

        // assert
        assertEquals(studentInput, studentOutput);
    }

    @Test
    @DisplayName("it should return a correct AnalyzeScore of the user with Id 1")
    public void analyzeScoreTest(){
        // arrange
        StudentDTO studentInput = new StudentDTO(
                1L,
                "Jose",
                "",
                0.0,
                new ArrayList<SubjectDTO>(Arrays.asList(
                        new SubjectDTO(
                                "Fisica",
                                10.0
                        ),
                        new SubjectDTO(
                                "Graficacion",
                                9.0
                        ),
                        new SubjectDTO(
                                "Circuitos",
                                6.0
                        )
                )) {}
        );

        // act
        when(studentDAO.findById(1L)).thenReturn(studentInput);
        StudentDTO studentOutput  = obtenerDiplomaService.analyzeScores(studentInput.getId());
        double averageScore = studentInput.getSubjects().stream().mapToDouble(x -> x.getScore()).average().orElse(0.0);

        // assert
        assertEquals(studentInput.getAverageScore(), averageScore);
    }

    @Test
    @DisplayName("it should return message equals to 'El alumno {{studentName}} ha obtenido un promedio de {{averageScore}}. Puedes mejorar.'")
    public void messageTest(){
        // arrange
        String message = "El alumno Jose ha obtenido un promedio de 8.33. Puedes mejorar.";
        StudentDTO studentInput = new StudentDTO(
                1L,
                "Jose",
                "",
                0.0,
                new ArrayList<SubjectDTO>(Arrays.asList(
                        new SubjectDTO(
                                "Fisica",
                                10.0
                        ),
                        new SubjectDTO(
                                "Graficacion",
                                9.0
                        ),
                        new SubjectDTO(
                                "Circuitos",
                                6.0
                        )
                )) {}
        );

        // act
        when(studentDAO.findById(studentInput.getId())).thenReturn(studentInput);
        StudentDTO studentOutput = obtenerDiplomaService.analyzeScores(studentInput.getId());

        // assert
        assertEquals(studentOutput.getMessage(), message);
    }

    @Test
    @DisplayName("it should return message equals to 'El alumno {{studentName}} ha obtenido un promedio de {{averageScore}}. Felicitaciones'")
    public void messageWithHonorsTest(){
        // arrange
        String message = "El alumno Jose ha obtenido un promedio de 8.33. Puedes mejorar.";
        StudentDTO studentInput = new StudentDTO(
                1L,
                "Jose",
                "",
                0.0,
                new ArrayList<SubjectDTO>(Arrays.asList(
                        new SubjectDTO(
                                "Fisica",
                                10.0
                        ),
                        new SubjectDTO(
                                "Graficacion",
                                10.0
                        ),
                        new SubjectDTO(
                                "Circuitos",
                                10.0
                        )
                )) {}
        );

        // act
        when(studentDAO.findById(studentInput.getId())).thenReturn(studentInput);
        StudentDTO studentOutput = obtenerDiplomaService.analyzeScores(studentInput.getId());

        // arrange
        System.out.println(studentOutput.getMessage());
    }
}
