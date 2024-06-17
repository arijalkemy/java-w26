package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    StudentDTO studentDTOrepository;
    StudentDTO studentDTOReturn;

    @BeforeEach
    void init(){
        studentDTOrepository= new StudentDTO(1L,"Juan Perez",""
                ,0D ,
                List.of( new SubjectDTO("Matemáticas", 8.5),
                        new SubjectDTO("Historia", 9.0),
                        new SubjectDTO("Ciencias", 7.5)
                ));
        studentDTOReturn= new StudentDTO(1L,"Juan Perez",
                "El alumno Juan Perez ha obtenido un promedio de 8.33. Puedes mejorar."
                ,8.33 ,
                List.of( new SubjectDTO("Matemáticas", 8.5),
                        new SubjectDTO("Historia", 9.0),
                        new SubjectDTO("Ciencias", 7.5)
                ));
    }

    @Test
    public void analyzeScoresTestHappyPath(){
        //Arrange
        Long studentId=1L;

        //Act
        Mockito.when(studentDAO.findById(studentId))
                .thenReturn(this.studentDTOrepository);

        StudentDTO studentResult=obtenerDiplomaService.analyzeScores(studentId);

        //Assert
        Assertions.assertEquals(studentResult,studentDTOReturn);
    }

}
