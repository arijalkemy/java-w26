package service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO studentDAOMock;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Con notas 8 y 10 el promedio da 9")
    public void calculateAverageOK() {
        //Arrange
        StudentDTO studentInput = buildStudentDTO();
        Double expected = studentInput.getAverageScore();
        when(studentDAOMock.findById(studentInput.getId())).thenReturn(studentInput);
        //Act
        StudentDTO studentDTOOutput = obtenerDiplomaService.analyzeScores(studentInput.getId());
        //Assert
        Assertions.assertEquals(expected, studentDTOOutput.getAverageScore());
    }

    @Test
    @DisplayName("Con notas 8 y 10 el mensaje es 'Puede mejorar'")
    public void getGreetingMessageOK() {
        //Arrange
        StudentDTO studentInput = buildStudentDTO();
        when(studentDAOMock.findById(studentInput.getId())).thenReturn(studentInput);
        //Act
        StudentDTO studentDTOOutput = obtenerDiplomaService.analyzeScores(studentInput.getId());
        //Assert
        Assertions.assertTrue(studentDTOOutput.getMessage().contains("Puedes mejorar"));
    }


    @Test
    @DisplayName("Con notas 8, 10 y 9 el mensaje es 'Felicitaciones'")
    public void getGrettingHonorMessageOK() {
        //Arrange
        StudentDTO studentInput = buildStudentDTO();
        studentInput.getSubjects().add(new SubjectDTO("Quimica", 10.0));
        when(studentDAOMock.findById(studentInput.getId())).thenReturn(studentInput);
        //Act
        StudentDTO studentDTOOutput = obtenerDiplomaService.analyzeScores(studentInput.getId());
        //Assert
        Assertions.assertTrue(studentDTOOutput.getMessage().contains("Felicitaciones"));
    }

    @Test
    @DisplayName("Mensaje de diploma correcto")
    public void getGrettingMessageOK() {
        //Arrange
        StudentDTO studentInput = buildStudentDTO();
        String expectedMessage = "El alumno Marcos ha obtenido un promedio de 9. Puedes mejorar.";
        when(studentDAOMock.findById(studentInput.getId())).thenReturn(studentInput);
        //Act
        StudentDTO studentDTOOutput = obtenerDiplomaService.analyzeScores(studentInput.getId());
        //Assert
        Assertions.assertEquals(expectedMessage, studentDTOOutput.getMessage());
    }


    //Metodo para crear un StudentDTO
    private StudentDTO buildStudentDTO() {
        SubjectDTO subjectDTO1 = new SubjectDTO("Matematica", 8d);
        SubjectDTO subjectDTO2 = new SubjectDTO("Fisica", 10d);
        StudentDTO student = new StudentDTO(1l, "Marcos", "", 9.00,
                new ArrayList<>(List.of(subjectDTO1, subjectDTO2)));
        return student;
    }
}
