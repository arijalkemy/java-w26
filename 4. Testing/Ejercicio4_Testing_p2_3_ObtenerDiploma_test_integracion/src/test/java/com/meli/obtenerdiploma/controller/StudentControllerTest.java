package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    private IStudentService studentService;
    @InjectMocks
    private StudentController studentController;

    @Test
    @DisplayName("Test 1 - Obtener estudiante con ID 1")
    void getStudentTest(){
        //Arrange: preparación de los datos de entrada y de salida
        Long id = 2L;

        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática", 10.0));
        subjectDTOList.add(new SubjectDTO("Física", 8.0));
        subjectDTOList.add(new SubjectDTO("Química", 4.0));
        StudentDTO studentDTO_esperado = new StudentDTO();
        studentDTO_esperado.setId(2L);
        studentDTO_esperado.setStudentName("Pedro");
        studentDTO_esperado.setSubjects(subjectDTOList);

        //Act:Fragmento de codigo a testear
        Mockito.when(studentService.read(id)).thenReturn(studentDTO_esperado);
        StudentDTO studentDTO_obtenido = studentController.getStudent(id);

        //Assert: Validaciones del test
        Assertions.assertEquals(studentDTO_esperado, studentDTO_obtenido);


    }

    @Test
    @DisplayName("Test 2 - Validación del registro del estudiante")
    void registerStudentTest(){
        //Arrange: define los requisitos de entrada y salida que debe de cumplir el codigo
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática", 9.0));
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Cristian");
        studentDTO.setSubjects(subjectDTOList);
        // Act
        ResponseEntity<?> responseEntity = studentController.registerStudent(studentDTO);
        // Assert
        // Verificar que el método create del servicio de estudiantes se llamó una vez con el objeto studentDTO
        verify(studentService, times(1)).create(studentDTO);
        // Verificar que el ResponseEntity devuelto es OK
        assertEquals(ResponseEntity.ok().build(), responseEntity);
    }

    @Test
    @DisplayName("Test 3 - Modificar los datos del usuario con id = 2")
    void updateStudentTest(){
        //Arrange: define los datos de entrada y salida necesarios para la validacion
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática", 10.0));
        subjectDTOList.add(new SubjectDTO("Física", 8.0));
        subjectDTOList.add(new SubjectDTO("Química", 4.0));
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(2L);
        studentDTO.setStudentName("Cristian");
        studentDTO.setSubjects(subjectDTOList);
        //Act: llamado del codigo necesario para validación
        ResponseEntity<?> responseEntity = studentController.modifyStudent(studentDTO);
        //Validaciones
        verify(studentService, times(1)).update(studentDTO);
        assertEquals(ResponseEntity.ok().build(), responseEntity);
    }

    @Test
    @DisplayName("Test 4 - Eliminar un estudiante con id = 2")
    void removeStudentTest(){
        //Arrange: define los datos de entrada y salida necesarios para la validacion
        Long id = 2L;
        //Act: llamado del codigo necesario para validación
        ResponseEntity<?> responseEntity = studentController.removeStudent(id);
        //Validaciones
        verify(studentService, times(1)).delete(id);
        assertEquals(ResponseEntity.ok().build(), responseEntity);
    }

    @Test
    @DisplayName("Test 5 - Lista todos los estudiantes")
    void listStudentsTest(){
        //Arrange: definición de los datos de entrada y de salida
        List<SubjectDTO> subjectDTOList = new ArrayList<>();

        subjectDTOList.add(new SubjectDTO("Matemática", 10.0));
        subjectDTOList.add(new SubjectDTO("Física", 8.0));
        subjectDTOList.add(new SubjectDTO("Química", 4.0));
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(2L);
        studentDTO.setStudentName("Pedro");
        studentDTO.setSubjects(subjectDTOList);

        List<SubjectDTO> subjectDTOList_1 = new ArrayList<>();
        subjectDTOList_1.add(new SubjectDTO("Matemática", 9.0));
        subjectDTOList_1.add(new SubjectDTO("Física", 7.0));
        subjectDTOList_1.add(new SubjectDTO("Química", 6.0));
        StudentDTO studentDTO_1 = new StudentDTO();
        studentDTO_1.setId(1L);
        studentDTO_1.setStudentName("Juan");
        studentDTO_1.setSubjects(subjectDTOList_1);

        Set<StudentDTO> datosEsperados = new HashSet<>();
        datosEsperados.add(studentDTO);
        datosEsperados.add(studentDTO_1);

        //Act: llamada del fragmento de codigo a testear
        Mockito.when(studentService.getAll()).thenReturn(datosEsperados);
        Set<StudentDTO> datosObtenidos = studentController.listStudents();

        //Assert: comproación de lo obtenido con lo esperado
        Assertions.assertEquals(datosEsperados, datosObtenidos);


    }



}