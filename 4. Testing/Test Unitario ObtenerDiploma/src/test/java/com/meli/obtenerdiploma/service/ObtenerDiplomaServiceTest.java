package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {
    @Mock
    private IStudentDAO repository;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;


    @Test
    @DisplayName("Verifica si se crea el usuario con el mensaje y el average correcto")
    void verifyIfObtenerDiplomaServiceBuscaElUsuario() {
        //ARRANGE
        StudentDTO student = createSampleStudent();
        Double expectedAverage = 7.85;
        String expectedMessage = "El alumno Juan Pérez ha obtenido un promedio de 7,85. Puedes mejorar.";
        //ACT
        when(repository.findById(1L)).thenReturn(student);
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);
        String resultMessage = result.getMessage();
        Double resultAverage = result.getAverageScore();
        
       
        //ASSERT
        verify(repository,atLeastOnce()).findById(1L);
        assertEquals(expectedAverage, resultAverage);
        assertEquals(expectedMessage, resultMessage);
    }


    private StudentDTO createSampleStudent(){
        SubjectDTO subject1 = new SubjectDTO("Matemáticas", 8.5);
        SubjectDTO subject2 = new SubjectDTO("Historia", 7.2);
        StudentDTO student = new StudentDTO(1L, "Juan Pérez", "¡Felicidades por tus logros!", 7.85, Arrays.asList(subject1, subject2));
        return student;
    }
}