package com.meli.obtenerdiploma.unit.service;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.util.StudentBuilder;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO daoStudentMock;

    @InjectMocks
    private ObtenerDiplomaService systemUnderTest;


    @Test
    @DisplayName("Test to verify average and final message")
    public void analyzeScoresTest() {

        //Arrange
        StudentDTO baseStudent = StudentBuilder.getStudentDTOGoodAverage();
        Double averageExpected = (9.0+9.0+10.0)/3.0; 
        Long studentId = baseStudent.getId();
        
        //Act
        when(daoStudentMock.findById(studentId)).thenReturn(baseStudent);
        StudentDTO result = systemUnderTest.analyzeScores(studentId);

        //Assertions

        Assertions.assertEquals(averageExpected, result.getAverageScore());
        Assertions.assertEquals("El alumno Antonio ha obtenido un promedio de 9,33. Felicitaciones!", result.getMessage()); 


        //Arrange

        baseStudent = StudentBuilder.getStudentTest(); //Podría considerarse que no es buena idea rehusar una variable
        averageExpected = (9.0 + 7.0 + 6.0) / 3.0;
        //Act
        when(daoStudentMock.findById(studentId)).thenReturn(baseStudent);
        result = systemUnderTest.analyzeScores(studentId);

        //Assertions

        Assertions.assertEquals(averageExpected, result.getAverageScore());
        Assertions.assertEquals("El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.", result.getMessage()); 

    }

}
