package com.meli.obtenerdiploma.serviceTest;


import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DecimalFormat;
import java.util.List;

@SpringBootTest
public class ObtenerDiplomaServiceTest {


    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    StudentDTO student = new StudentDTO();

    @BeforeEach
    public void setUp(){
        // Subject List
        List<SubjectDTO> subjectsPruebas = List.of(
                new SubjectDTO("Matematicas", 10.0),
                new SubjectDTO("Fisica", 8.0));

        // Create student

        student.setStudentName("Juan");
        student.setSubjects(subjectsPruebas);
        student.setId(1L);
    }

    @Test
    public void calcularPromedio(){
        // Assert
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(this.student.getId());
        studentDTO.setStudentName(this.student.getStudentName());
        studentDTO.setSubjects(this.student.getSubjects());
        studentDTO.setAverageScore(9.0);
        studentDTO.setMessage("El alumno " + studentDTO.getStudentName() + " ha obtenido un promedio de " +
                                    new DecimalFormat("#.##").format(studentDTO.getAverageScore()) +
                                    ((studentDTO.getAverageScore() > 9) ? ". Felicitaciones!" : ". Puedes mejorar."));

        // Act
        Mockito.when(studentDAO.findById(1L)).thenReturn(this.student);
        StudentDTO resultado = this.obtenerDiplomaService.analyzeScores(1L);

        // Arrange
        Assertions.assertEquals(studentDTO, resultado);
    }

    @Test
    public void calcularPromedioAlumnoNoExiste(){
        Mockito.when(studentDAO.findById(0L)).thenThrow(StudentNotFoundException.class);

        Assertions.assertThrows(StudentNotFoundException.class, () -> this.obtenerDiplomaService.analyzeScores(0L));
    }
}
