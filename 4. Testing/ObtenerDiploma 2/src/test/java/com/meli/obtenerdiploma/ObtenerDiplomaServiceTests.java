package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTests {

    private StudentDTO studentWithoutHonors;
    private StudentDTO studentWithHonors;

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @BeforeEach
    public void setup() {
        List<SubjectDTO> subjectList = List.of(new SubjectDTO("Math", 8.0), new SubjectDTO("History", 8.0));
        List<SubjectDTO> subjectHonorList = List.of(new SubjectDTO("Math", 10.0), new SubjectDTO("History", 9.0));
        this.studentWithoutHonors = new StudentDTO(1L, "Juan", "", null, subjectList);
        this.studentWithHonors = new StudentDTO(2L, "Carlos", "", null, subjectHonorList);
    }

    @Test
    @DisplayName("Estudiante con dos 8 debería tener promedio 8.")
    public void averageScoreTest() {
        when(studentDAO.findById(1L)).thenReturn(studentWithoutHonors);
        obtenerDiplomaService.analyzeScores(1L);
        Assertions.assertEquals(8.0, studentWithoutHonors.getAverageScore());
    }

    @Test
    @DisplayName("Mensaje de estudiante con 9 y 10 debería ser con honores.")
    public void diplomaMessageTestWithHonors() {
        when(studentDAO.findById(2L)).thenReturn(studentWithHonors);
        obtenerDiplomaService.analyzeScores(2L);
        Assertions.assertEquals("El alumno Carlos ha obtenido un promedio de 9.5. Felicitaciones!", studentWithHonors.getMessage());
    }

    @Test
    @DisplayName("Mensaje de estudiante con 8 y 8 debería ser sin honores.")
    public void diplomaMessageTestWithoutHonors() {
        when(studentDAO.findById(1L)).thenReturn(studentWithoutHonors);
        obtenerDiplomaService.analyzeScores(1L);
        Assertions.assertEquals("El alumno Juan ha obtenido un promedio de 8. Puedes mejorar.", studentWithoutHonors.getMessage());
    }
}
