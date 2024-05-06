package spring.obtenerdiploma.controller;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import spring.obtenerdiploma.model.StudentDTO;
import spring.obtenerdiploma.service.IObtenerDiplomaService;
import utils.TestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    public void ObtenerDiploma(){
        //Arrange
        StudentDTO studentDTO = TestUtils.createStudentDTOWithTwoSubjects();

        //Act
        this.obtenerDiplomaController.analyzeScores(studentDTO.getId());

        //Assert
        verify(obtenerDiplomaService,atLeastOnce()).analyzeScores(studentDTO.getId());
    }

}
