package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    private StudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Test 1 - Con base de un studentDTO registrado se analiza el score promedio bajo con leyenda Puedes mejorar")
    public void analyzeScoresTest() {
        //Arrange, se define los datos de entrada y de salida a analizar
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática", 10.0));
        subjectDTOList.add(new SubjectDTO("Física", 8.0));
        subjectDTOList.add(new SubjectDTO("Química", 4.0));
        StudentDTO studentDTO_esperado = new StudentDTO();
        studentDTO_esperado.setId(2L);
        studentDTO_esperado.setStudentName("Pedro");
        studentDTO_esperado.setSubjects(subjectDTOList);
        Long studentId = 2L;

        String leyenda = "Puedes mejorar";
        Double promedio = (10.0+8.0+4.0)/3.0;

        // Se define el resultado esperado
        StudentDTO studentDTO_mock = studentDTO_esperado;

        //Se simula el comportamiento del DAO
        Mockito.when(studentDAO.findById(studentId)).thenReturn(studentDTO_mock);

        // Act
        StudentDTO studentDTO_obtenido = obtenerDiplomaService.analyzeScores(studentId);

        // Assert
        Assertions.assertEquals(studentDTO_esperado, studentDTO_obtenido);//Verifica la creación de un ususario
        Assertions.assertEquals(promedio, studentDTO_obtenido.getAverageScore()); //Verifica el correcto calculo del promedio
        Assertions.assertTrue(studentDTO_obtenido.getMessage().contains(leyenda)); //Verifica la leyenda de "Puedes mejorar"
    }

    @Test
    @DisplayName("Test 1 - Con base de un studentDTO registrado se analiza el score promedio con leyenda Felicitaciones")
    public void analyzeScoresTest_2() {
        //Arrange, se define los datos de entrada y de salida a analizar
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática", 10.0));
        subjectDTOList.add(new SubjectDTO("Física", 10.0));
        subjectDTOList.add(new SubjectDTO("Química", 9.0));
        StudentDTO studentDTO_esperado = new StudentDTO();
        studentDTO_esperado.setId(2L);
        studentDTO_esperado.setStudentName("Pedro");
        studentDTO_esperado.setSubjects(subjectDTOList);
        Long studentId = 2L;

        String leyenda = "Felicitaciones";
        Double promedio = (10.0+10.0+9.0)/3.0;

        // Se define el resultado esperado
        StudentDTO studentDTO_mock = studentDTO_esperado;

        //Se simula el comportamiento del DAO
        Mockito.when(studentDAO.findById(studentId)).thenReturn(studentDTO_mock);

        // Act
        StudentDTO studentDTO_obtenido = obtenerDiplomaService.analyzeScores(studentId);

        // Assert
        Assertions.assertEquals(studentDTO_esperado, studentDTO_obtenido);//Verifica la creación de un ususario
        Assertions.assertEquals(promedio, studentDTO_obtenido.getAverageScore()); //Verifica el correcto calculo del promedio
        Assertions.assertTrue(studentDTO_obtenido.getMessage().contains(leyenda)); //Verifica la leyenda de "Puedes mejorar"
    }

    @Test
    @DisplayName("Test 2 - Con base de un studentDTO no registrado se analiza el escenario de excepcion para score")
    public void analyzeScoresTestSadPath(){
        //Arrange: se establece los datos de entrada
        Long id = 0L;
        //Configurar el mock para lanzar una excepción cuando se llame a findById
        Mockito.when(studentDAO.findById(id)).thenThrow(StudentNotFoundException.class);
        //Act y Assert
        Assertions.assertThrows(StudentNotFoundException.class, ()->obtenerDiplomaService.analyzeScores(id));
    }






}
