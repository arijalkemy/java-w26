package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(value = MockitoExtension.class)
public class ObtenerDiplomaServiceTests {
    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Promedio para alumno perfecto es 10.0")
    public void calcularPromedioCorrectamente(){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Juan");

        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática", 10.0));
        subjectDTOList.add(new SubjectDTO("Física", 10.0));
        subjectDTOList.add(new SubjectDTO("Química", 10.0));

        studentDTO.setSubjects(subjectDTOList);

        when(studentDAO.findById(0L)).thenReturn(studentDTO);

        double expectedValue = 10.0;

        double obtained = obtenerDiplomaService.analyzeScores(0L).getAverageScore();

        verify(studentDAO, atLeast(1)).findById(0L);
        Assertions.assertEquals(expectedValue, obtained);
    }
    @Test
    @DisplayName("Promedio Negativo")
    public void calculateAverageNegative() {
        SubjectDTO subject1 = new SubjectDTO("Matemática", -4.0);
        SubjectDTO subject2 = new SubjectDTO("Lengua", -2.0);
        StudentDTO student = new StudentDTO(0L, "Excelent", "", 0.0, List.of(subject1, subject2));

        double expected = -3.0;
        when(studentDAO.findById(0L)).thenReturn(student);

        StudentDTO actual = obtenerDiplomaService.analyzeScores(0L);
        Assertions.assertEquals(expected, actual.getAverageScore());
    }
    @Test
    @DisplayName("Leyenda del diploma")
    public void diplomaLegendOK(){
        SubjectDTO subjectOne = new SubjectDTO("Fisica",8.0);
        SubjectDTO subjectTwo = new SubjectDTO("Quimica",6.0);
        StudentDTO student = new StudentDTO(0L,"Decent","",0.0,List.of(subjectOne,subjectTwo));

        String expected = "El alumno " + "Decent" + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(7.0)
                + ". Puedes mejorar.";

        when(studentDAO.findById(0L)).thenReturn(student);

        StudentDTO actual = obtenerDiplomaService.analyzeScores(0L);
        Assertions.assertEquals(expected,actual.getMessage());
    }
    @Test
    @DisplayName("Diploma con honores")
    public void honorDiplomaLegend(){
        SubjectDTO subjectOne = new SubjectDTO("Fisica",9.0);
        SubjectDTO subjectTwo = new SubjectDTO("Ingles",10.0);
        StudentDTO student = new StudentDTO(0L,"Decent","",0.0,List.of(subjectOne,subjectTwo));

        String expected = "El alumno " + "Decent" + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(9.5)
                + ". Felicitaciones!";

        when(studentDAO.findById(0L)).thenReturn(student);

        StudentDTO actual = obtenerDiplomaService.analyzeScores(0L);
        Assertions.assertEquals(expected,actual.getMessage());
    }

}
