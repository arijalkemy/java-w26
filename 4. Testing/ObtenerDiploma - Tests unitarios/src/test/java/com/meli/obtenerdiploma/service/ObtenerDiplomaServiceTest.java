package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.utils.StudentGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.DependsOn;

import java.text.DecimalFormat;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService service;



    private StudentDTO student;


    @BeforeEach
    void setup(){
        student = StudentGenerator.generateStudent();
    }

    @Test
    @DisplayName("Test Calculo de Promedio")
    public void analyzeScoresTest(){
        //        Arrange
        Double expectedScore = student.getAverageScore();

        //        Act
        when(studentDAO.findById(student.getId())).thenReturn(student);

        //       Assert
        Assertions.assertEquals(expectedScore,
                service.analyzeScores(student.getId()).getAverageScore());
    }

    @Test
    @DisplayName("Test Calculo de Promedio No encontrado")
    public void analyzeScoresTestNotFound(){
        //        Act
        when(studentDAO.findById(100L)).thenThrow(StudentNotFoundException.class);

        //       Assert
        Assertions.assertThrows(
                StudentNotFoundException.class,
                () -> service.analyzeScores(100L));
    }

    @Test
    @DisplayName("Test Datos de Salida idénticos a datos de Entrada.")
    public void analyzeScoresTestSame(){
        //        Arrange
        Double expectedScore = student.getAverageScore();

        //        Act
        when(studentDAO.findById(anyLong())).thenReturn(student);
        StudentDTO studentResponse = service.analyzeScores(student.getId());


        //       Assert
       assertThat(studentResponse.getStudentName()).isEqualTo(student.getStudentName());
       assertThat(studentResponse.getSubjects()).isEqualTo(student.getSubjects());
       assertThat(studentResponse.getId()).isEqualTo(student.getId());

    }

    @Test
    @DisplayName("Test Diploma Con honores")
    public void DiplomaConHonoresTest(){
        //Arrange
        student = StudentGenerator.generateStudentConHonores();
        when(studentDAO.findById(student.getId())).thenReturn(student);

        String message = "El alumno " + student.getStudentName() + " ha obtenido un promedio de " +
                new DecimalFormat("#.##").format(student.getAverageScore()) + ". Felicitaciones!";

        //        Act & Assert
        StudentDTO studentResponse = service.analyzeScores(student.getId());
        Assertions.assertEquals(message, studentResponse.getMessage());

    }

    @Test
    @DisplayName("Test Diploma Sin honores")
    public void DiplomaSinHonoresTest(){
        //Arrange
        when(studentDAO.findById(student.getId())).thenReturn(student);

        String message = "El alumno " + student.getStudentName() + " ha obtenido un promedio de " +
                new DecimalFormat("#.##").format(student.getAverageScore()) + ". Puedes mejorar.";

        //        Act & Assert
        StudentDTO studentResponse = service.analyzeScores(student.getId());
        Assertions.assertEquals(message, studentResponse.getMessage());

    }

}