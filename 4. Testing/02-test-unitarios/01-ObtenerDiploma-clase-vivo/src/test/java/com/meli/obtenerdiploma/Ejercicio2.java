package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.exception.ObtenerDiplomaException;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.constraints.Null;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(value = MockitoExtension.class)
public class Ejercicio2 {
    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    private Long id = 0L;
    private Long id2 = 1L;
    private StudentDTO studentDTO;
    private StudentDTO studentDTO2;

    @BeforeEach
    void setUp() {
        studentDTO = new StudentDTO();
        studentDTO.setId(id);
        studentDTO.setStudentName("Juan");

        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática", 10.0));
        subjectDTOList.add(new SubjectDTO("Física", 9.0));

        studentDTO.setSubjects(subjectDTOList);

        studentDTO2 = new StudentDTO();
        studentDTO2.setId(id2);
        studentDTO2.setStudentName("José");

        List<SubjectDTO> subjectDTOList2 = new ArrayList<>();
        subjectDTOList2.add(new SubjectDTO("Matemática", 4.0));

        studentDTO2.setSubjects(subjectDTOList2);
    }

    @Test
    @DisplayName("Calcular promedio")
    void calulateAverage(){
        when(studentDAO.findById(id)).thenReturn(studentDTO);

        double expectedValue = 9.5;

        double obtained = obtenerDiplomaService.analyzeScores(studentDTO.getId()).getAverageScore();

        verify(studentDAO,atLeast(1)).findById(studentDTO.getId());
        assertEquals(expectedValue, obtained);
    }

    @Test
    @DisplayName("Mostrar mensaje basico del diploma")
    void showBasicDiplomaMessage(){
        when(studentDAO.findById(id)).thenReturn(studentDTO);

        double average = obtenerDiplomaService.analyzeScores(studentDTO.getId()).getAverageScore();

        String expectedMessage = "El alumno " + studentDTO.getStudentName() + " ha obtenido un promedio de "
                                + new DecimalFormat("#.##").format(average) + ". Felicitaciones!";

        String obtained = obtenerDiplomaService.analyzeScores(studentDTO.getId()).getMessage();

        assertEquals(expectedMessage, obtained);
    }

    @Test
    @DisplayName("Mostrar mensaje basico del diploma")
    void showHonorsDiplomaMessage(){
        when(studentDAO.findById(id2)).thenReturn(studentDTO2);

        double average = obtenerDiplomaService.analyzeScores(studentDTO2.getId()).getAverageScore();

        String expectedMessage = "El alumno " + studentDTO2.getStudentName() + " ha obtenido un promedio de "
                + new DecimalFormat("#.##").format(average) + ". Puedes mejorar.";

        String obtained = obtenerDiplomaService.analyzeScores(studentDTO2.getId()).getMessage();

        assertEquals(expectedMessage, obtained);
    }

    @Test
    @DisplayName("Datos de salida identicos a datos de entrada")
    void outPutSameAsInput(){
        when(studentDAO.findById(id)).thenReturn(studentDTO);

        StudentDTO result = obtenerDiplomaService.analyzeScores(id);

        assertSame(studentDTO, result);
    }

    @Test
    @DisplayName("Datos de estudiante null")
    void handleNullData(){
        when(studentDAO.findById(id)).thenReturn(null);

        assertThrows(NullPointerException.class, () -> obtenerDiplomaService.analyzeScores(id));
    }
}
