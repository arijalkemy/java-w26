package com.meli.obtenerdiploma;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(value = MockitoExtension.class)
public class ObtenerDiplomaServiceTests {

    //Creo mock de IStudentDAO
    @Mock
    private IStudentDAO studentDAO;

    //Inyecto ObtenerDiplomaService
    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    private final Long idUno = 0L;
    private StudentDTO studentDTOUno;
    private StudentDTO studentDTODos;

    @BeforeEach
    void setUp() {
        studentDTOUno = new StudentDTO();
        studentDTOUno.setStudentName("Uno");

        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática", 10.0));
        subjectDTOList.add(new SubjectDTO("Física", 9.0));

        studentDTOUno.setSubjects(subjectDTOList);

        studentDTODos = new StudentDTO();
        studentDTODos.setStudentName("Dos");

        List<SubjectDTO> subjectDTOListDos = new ArrayList<>();
        subjectDTOListDos.add(new SubjectDTO("Matemática", 2.0));

        studentDTODos.setSubjects(subjectDTOListDos);
    }

    @Test
    @DisplayName("Se calcula el promedio correctamente")
    public void calcularPromedio(){
        when(studentDAO.findById(idUno)).thenReturn(studentDTOUno);

        double expectedValue = 9.5;

        double obtained = obtenerDiplomaService.analyzeScores(0L).getAverageScore();

        verify(studentDAO, atLeast(1)).findById(0L);
        Assertions.assertEquals(expectedValue, obtained);
    }

    @Test
    public void mensajeParaAlumnoSegunPromedio(){
        when(studentDAO.findById(idUno)).thenReturn(studentDTOUno);
        Long idDos = 1L;
        when(studentDAO.findById(idDos)).thenReturn(studentDTODos);

        String expectedValueUno = "El alumno Uno ha obtenido un promedio de " + new DecimalFormat("#.##")
                .format(9.5) + ". Felicitaciones!";
        String expectedValueDos = "El alumno Dos ha obtenido un promedio de " + new DecimalFormat("#.##")
                .format(2) + ". Puedes mejorar.";

        String obtainedUno = obtenerDiplomaService.analyzeScores(idUno).getMessage();
        String obtainedDos = obtenerDiplomaService.analyzeScores(idDos).getMessage();

        Assertions.assertEquals(expectedValueUno, obtainedUno);
        Assertions.assertEquals(expectedValueDos, obtainedDos);
    }
}