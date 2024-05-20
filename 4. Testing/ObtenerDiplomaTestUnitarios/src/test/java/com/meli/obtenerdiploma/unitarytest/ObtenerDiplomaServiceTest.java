package com.meli.obtenerdiploma.unitarytest;

import com.meli.obtenerdiploma.exception.ObtenerDiplomaException;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    private IStudentDAO studentDao;

    @InjectMocks
    private ObtenerDiplomaService service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);


    }

    @Test
    void analyzeScoresTest() {
        //Configurando el comportamiento del mock
        StudentDTO studentDTO = new StudentDTO(123L, "Manuel", "", 0.0, Arrays.asList(
                new SubjectDTO("Matematicas", 10.0),
                new SubjectDTO("Fisica", 10.0),
                new SubjectDTO("Quimica", 10.0)
        ));

        when(studentDao.findById(123L)).thenReturn(studentDTO);

        //Ejecutando el método a probar
        StudentDTO result = service.analyzeScores(123L);

        assertEquals("El alumno Manuel ha obtenido un promedio de 10. Felicitaciones!", result.getMessage());
        assertEquals(10.0, result.getAverageScore());
    }
    @Test
    void analyzeScoresThrowsExceptionTest() {

        // Configurando el comportamiento del mock
        when(studentDao.findById(11L)).thenThrow(new ObtenerDiplomaException("El alumno con Id " + 11L + " no se encuetra registrado.", HttpStatus.BAD_REQUEST));

        // Ejecutando el método a probar y esperando que se lance una excepción
        ObtenerDiplomaException exception = assertThrows(ObtenerDiplomaException.class, () -> service.analyzeScores(11L));
        // Verificando que el mensaje de la excepción es el esperado
        assertEquals("El alumno con Id 11 no se encuetra registrado.", exception.getError().getDescription());
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatus());
    }

    @Test
    void analyzeScoresImproveTest() {
        //Configurando el comportamiento del mock
        StudentDTO studentDTO = new StudentDTO(123L, "Manuel", "", 0.0, Arrays.asList(
                new SubjectDTO("Matematicas", 8.0),
                new SubjectDTO("Fisica", 8.0),
                new SubjectDTO("Quimica", 8.0)
        ));

        when(studentDao.findById(123L)).thenReturn(studentDTO);

        //Ejecutando el método a probar
        StudentDTO result = service.analyzeScores(123L);

        assertEquals("El alumno Manuel ha obtenido un promedio de 8. Puedes mejorar.", result.getMessage());
        assertEquals(8.0, result.getAverageScore());
    }

    @Test
    void calculateAverageTest() {
        //Configurando el comportamiento del mock
        List<SubjectDTO> scores = Arrays.asList(
                new SubjectDTO("Matematicas", 10.0),
                new SubjectDTO("Fisica", 10.0),
                new SubjectDTO("Quimica", 10.0));

        //Ejecutando el método a probar
        Double result = service.calculateAverage(scores);
        assertEquals(10.0, result);
    }

    @Test
    void getGreetingMessageTest() {
        //Configurando el comportamiento del mock
        String studentName = "Manuel";
        Double average = 10.0;

        //Ejecutando el método a probar
        String result = service.getGreetingMessage(studentName, average);
        assertEquals("El alumno Manuel ha obtenido un promedio de 10. Felicitaciones!", result);
    }

    //Test para casos nulos, vacios e invalidos
    @Test
    void analyzeScoresTestOtrosCasos() {
        //CasoNulo
        assertThrows(IllegalArgumentException.class, () -> service.analyzeScores(null));
        //CasoVacio
        StudentDTO studentDTO = new StudentDTO();
        assertThrows(IllegalArgumentException.class, () -> service.analyzeScores(studentDTO.getId()));
        //CasoInvalido
        when(studentDao.findById(999L)).thenThrow(new StudentNotFoundException(999L));
        assertThrows(StudentNotFoundException.class, () -> service.analyzeScores(999L));
    }
        
}

