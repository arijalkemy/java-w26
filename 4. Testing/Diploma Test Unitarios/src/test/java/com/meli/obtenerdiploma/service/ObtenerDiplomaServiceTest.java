package com.meli.obtenerdiploma.service;


import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.util.StudentUseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;


    @DisplayName("Diploma para un estudiante con promedio perfecto")
    @Test
    void verifyAveragePerfect() {
        //Arrange
        StudentDTO studentDTO = StudentUseTest.StudentAverageTen();
        Mockito.when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);

        //Act
        obtenerDiplomaService.analyzeScores(studentDTO.getId());

        //Assert
        Mockito.verify(studentDAO,Mockito.atLeastOnce()).findById(studentDTO.getId());
        Assertions.assertEquals(10.0,studentDTO.getAverageScore());

    }

    @DisplayName("Mensage para un estudiante con promedio perfecto")
    @Test
    void verifyAveragePerfectMessage() {
        //Arrange
        StudentDTO studentDTO = StudentUseTest.StudentAverageTen();
        Mockito.when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);

        //Act
        obtenerDiplomaService.analyzeScores(studentDTO.getId());

        //Assert
        Mockito.verify(studentDAO,Mockito.atLeastOnce()).findById(studentDTO.getId());
        Assertions.assertEquals(studentDTO.getMessage(),"El alumno Aaron Hotchner ha obtenido un promedio de 10. Felicitaciones!");

    }

    @DisplayName("Mensage para un estudiante sin un promedio perfecto")
    @Test
    void verifyAverageNotPerfectMessage() {
        //Arrange
        StudentDTO studentDTO = StudentUseTest.StudentAverageLessTen();
        Mockito.when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);

        //Act
        obtenerDiplomaService.analyzeScores(studentDTO.getId());

        //Assert
        Mockito.verify(studentDAO,Mockito.atLeastOnce()).findById(studentDTO.getId());
        Assertions.assertEquals(studentDTO.getMessage(),"El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.");
    }
}
