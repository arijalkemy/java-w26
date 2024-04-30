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
    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    private Long id = 0L;
    private Long id2 = 1L;
    private StudentDTO studentDTO9;
    private StudentDTO studentDTOmenos;

    @BeforeEach
    void setUp() {
        studentDTO9 = new StudentDTO();
        studentDTO9.setStudentName("Juan");

        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática", 10.0));
        subjectDTOList.add(new SubjectDTO("Física", 9.0));

        studentDTO9.setSubjects(subjectDTOList);

        studentDTOmenos = new StudentDTO();
        studentDTOmenos.setStudentName("José");

        List<SubjectDTO> subjectDTOListMenos = new ArrayList<>();
        subjectDTOListMenos.add(new SubjectDTO("Matemática", 4.0));

        studentDTOmenos.setSubjects(subjectDTOListMenos);
    }

    @Test
    @DisplayName("Promedio para alumno se calcula correctamente")
    public void calcularPromedioCorrectamente(){
        when(studentDAO.findById(id)).thenReturn(studentDTO9);

        double expectedValue = 9.5;

        double obtained = obtenerDiplomaService.analyzeScores(0L).getAverageScore();

        verify(studentDAO, atLeast(1)).findById(0L);
        Assertions.assertEquals(expectedValue, obtained);
    }

    @Test
    public void mensajeDeAlumnoMayorOIgualA9FelicitacionesMenorBu(){
        when(studentDAO.findById(id)).thenReturn(studentDTO9);
        when(studentDAO.findById(id2)).thenReturn(studentDTOmenos);

        String expectedValue9 = "El alumno Juan ha obtenido un promedio de " + new DecimalFormat("#.##")
                .format(9.5) + ". Felicitaciones!";
        String expectedValueMenos = "El alumno José ha obtenido un promedio de " + new DecimalFormat("#.##")
                .format(4) + ". Puedes mejorar.";

        String obtained9 = obtenerDiplomaService.analyzeScores(id).getMessage();
        String obtainedMenos = obtenerDiplomaService.analyzeScores(id2).getMessage();

        Assertions.assertEquals(expectedValue9, obtained9);
        Assertions.assertEquals(expectedValueMenos, obtainedMenos);
    }
}
