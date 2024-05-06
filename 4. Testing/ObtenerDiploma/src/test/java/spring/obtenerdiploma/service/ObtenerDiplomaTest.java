package spring.obtenerdiploma.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import spring.obtenerdiploma.model.StudentDTO;
import spring.obtenerdiploma.model.SubjectDTO;
import spring.obtenerdiploma.repository.IStudentDAO;
import spring.obtenerdiploma.repository.StudentDAO;
import utils.TestUtils;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void analyzeScoreStudent() {
        //Arrange
        StudentDTO studentDTO = TestUtils.createStudentDTOWithTwoSubjects();

        when(this.studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);

        //Act
        this.obtenerDiplomaService.analyzeScores(studentDTO.getId());

        //Assert
        verify(studentDAO,atLeastOnce()).findById(studentDTO.getId());
        Assertions.assertEquals(studentDTO.getAverageScore(), 9);

    }


}
