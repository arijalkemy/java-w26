package com.meli.obtenerdiploma;

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

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(value = MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    private long id = 1L;
    private long id2 = 2L;
    private StudentDTO alumnoPromedioAltoDTO;
    private StudentDTO alumnoPromedioBajoDTO;

    @BeforeEach
    public void setUp(){
        alumnoPromedioAltoDTO = new StudentDTO();
        alumnoPromedioAltoDTO.setStudentName("Juan");

        List<SubjectDTO> materiasAlumnoAlto = new ArrayList<>();
        materiasAlumnoAlto.add(new SubjectDTO("Química",10.0));
        materiasAlumnoAlto.add(new SubjectDTO("Física", 10.0));
        alumnoPromedioAltoDTO.setSubjects(materiasAlumnoAlto);

        alumnoPromedioBajoDTO = new StudentDTO();
        alumnoPromedioBajoDTO.setStudentName("Pepe");

        List<SubjectDTO> materiasAlumnoBajo = new ArrayList<>();
        materiasAlumnoBajo.add(new SubjectDTO("Química",5.5));
        materiasAlumnoBajo.add(new SubjectDTO("Física", 6.0));
        alumnoPromedioBajoDTO.setSubjects(materiasAlumnoBajo);
    }

    @Test
    @DisplayName("Calcular promedio de alumno correctamente")
    public void calcularPromedioCorrectoTest(){
        when(studentDAO.findById(id)).thenReturn(alumnoPromedioAltoDTO);

        double esperado = 10.0;
        double obtenido = obtenerDiplomaService.analyzeScores(1L).getAverageScore();

        verify(studentDAO, atLeast(1)).findById(1L);

        Assertions.assertEquals(esperado,obtenido);
    }

    @Test
    @DisplayName("Mensaje nota mayor a 9, o menor a 9.")
    public void mensajeNotaAltaONotaBajaTest(){
        when(studentDAO.findById(id)).thenReturn(alumnoPromedioAltoDTO);
        when(studentDAO.findById(id2)).thenReturn(alumnoPromedioBajoDTO);

        String esperadoAlto = "El alumno Juan ha obtenido un promedio de " + new DecimalFormat("#.##").format(10.0)
                + ". Felicitaciones!";
        String esperadoBajo = "El alumno Pepe ha obtenido un promedio de " + new DecimalFormat("#.##").format(5.75)
                + ". Puedes mejorar.";

        String obtenidoAlto = obtenerDiplomaService.analyzeScores(id).getMessage();
        String obtenidoBajo = obtenerDiplomaService.analyzeScores(id2).getMessage();

        Assertions.assertEquals(esperadoAlto,obtenidoAlto);
        Assertions.assertEquals(esperadoBajo,obtenidoBajo);
    }

    @Test
    @DisplayName("Id de estudiante nulo.")
    public void idEstudianteNuloTest(){
        when(studentDAO.findById(null)).thenThrow(new StudentNotFoundException(null));

        Throwable exception = assertThrows(StudentNotFoundException.class,
                                ()-> {obtenerDiplomaService.analyzeScores(null);  });

        Assertions.assertEquals(null, exception.getMessage());
    }

}
