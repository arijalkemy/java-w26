package com.meli.obtenerdiploma.service;


import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {


    @Mock
    StudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;


    @Test
    @DisplayName("Test de servicio exitoso analyzeScores")
    public void analyzeScoresTest(){
        // Arrange
        Long id = 1L;
        StudentDTO expectedStudentDTO = new StudentDTO(
                1L,
                "Anibal",
                "El alumno Anibal ha obtenido un promedio de 9,33. Felicitaciones.",
                9.33,
                List.of(
                        new SubjectDTO("Kahoot", 9.0),
                        new SubjectDTO("Musica", 9.0),
                        new SubjectDTO("POO", 10.0)
                )
        );
        // Act
        when(studentDAO.findById(id)).thenReturn(expectedStudentDTO);
        StudentDTO actualStudentDTO = obtenerDiplomaService.analyzeScores(id);

        // Assert
        Assertions.assertEquals(expectedStudentDTO, actualStudentDTO);
    }

   @Test
   @DisplayName("Test de servicio no exitoso analyzeScores")
   public void analyzeScoresFailedTest(){
        // Arrange
        Long id = 99L;
        // Assert
        when(studentDAO.findById(id)).thenThrow(new StudentNotFoundException(id));
        Assertions.assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaService.analyzeScores(id));
    }

    @Test
    public void analyzeScoresProperMessageAboveNine(){
        //Arrange
        Long id = 1L;
        StudentDTO expectedStudentDTO = new StudentDTO(
                1L,
                "Anibal",
                "El alumno Anibal ha obtenido un promedio de 9,33. Felicitaciones!",
                9.33,
                List.of(
                        new SubjectDTO("Kahoot", 9.0),
                        new SubjectDTO("Musica", 9.0),
                        new SubjectDTO("POO", 10.0)
                )
        );
        String expected = expectedStudentDTO.getMessage();
        //Act
        when(studentDAO.findById(id)).thenReturn(expectedStudentDTO);
        StudentDTO actual = obtenerDiplomaService.analyzeScores(id);

        //Assert
        Assertions.assertEquals(expected, obtenerDiplomaService.analyzeScores(id).getMessage());
    }

    @Test
    public void analyzeScoresProperMessageBelowNine(){
        //Arrange
        Long id = 1L;
        StudentDTO expectedStudentDTO = new StudentDTO(
                1L,
                "Anibal",
                "El alumno Anibal ha obtenido un promedio de 3. Puedes mejorar.",
                3.0,
                List.of(
                        new SubjectDTO("Kahoot", 3.0),
                        new SubjectDTO("Musica", 3.0),
                        new SubjectDTO("POO", 3.0)
                )
        );
        String expected = expectedStudentDTO.getMessage();
        //Act
        when(studentDAO.findById(id)).thenReturn(expectedStudentDTO);
        StudentDTO actual = obtenerDiplomaService.analyzeScores(id);

        //Assert
        Assertions.assertEquals(expected, obtenerDiplomaService.analyzeScores(id).getMessage());
    }


    @Test
    public void analyzeScoresProperAverageScore(){
        //Arrange
        Long id = 1L;
        StudentDTO expectedStudentDTO = new StudentDTO(
                1L,
                "Anibal",
                "El alumno Anibal ha obtenido un promedio de 3,33. Puedes mejorar.",
                3.3333333333333335,
                List.of(
                        new SubjectDTO("Kahoot", 3.0),
                        new SubjectDTO("Musica", 4.0),
                        new SubjectDTO("POO", 3.0)
                )
        );
        Double expectedAverage = expectedStudentDTO.getAverageScore();
        // Act
        when(studentDAO.findById(id)).thenReturn(expectedStudentDTO);

        //Assert
        Assertions.assertEquals(expectedAverage, obtenerDiplomaService.analyzeScores(id).getAverageScore());
    }


    
    
    








}
