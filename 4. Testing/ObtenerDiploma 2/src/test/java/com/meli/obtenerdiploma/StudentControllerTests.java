package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(value = MockitoExtension.class)
public class StudentControllerTests {
    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    @BeforeEach
    public void setup(){

    }

    @Test
    @DisplayName("Se registra OK un estudiante")
    public void registrarEstudianteOkTest() {
        StudentDTO student = new StudentDTO();
        student.setStudentName("Juan");
        student.setId(1L);

        ResponseEntity<?> response = studentController.registerStudent(student);

        verify(studentService, times(1)).create(student);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    @DisplayName("Se obtiene OK un estudiante")
    public void leerEstudianteOKTest(){
        Long id = 1L;
        StudentDTO estudiante = new StudentDTO();
        estudiante.setId(id);
        estudiante.setStudentName("Juan");
        when(studentService.read(id)).thenReturn(estudiante);

        StudentDTO obtenido = studentController.getStudent(id);

        verify(studentService, times(1)).read(id);

        Assertions.assertEquals(obtenido, estudiante);
        Assertions.assertNotNull(obtenido);
    }

    @Test
    @DisplayName("Se modifica estudiante con exito")
    public void modificarEstudianteOkTest(){
        Long id = 2L;
        StudentDTO estudiante = new StudentDTO();
        estudiante.setId(id);
        estudiante.setStudentName("Juan");

        ResponseEntity<?> obtenido = studentController.modifyStudent(estudiante);

        verify(studentService, times(1)).update(estudiante);

        Assertions.assertNotNull(obtenido);
        Assertions.assertEquals(200, obtenido.getStatusCodeValue());
    }

    @Test
    @DisplayName("Borrar estudiante OK")
    public void borrarEstudianteOkTest(){
        long id = 12L;
        ResponseEntity<?> obtenido = studentController.removeStudent(id);

        verify(studentService,times(1)).delete(id);

        Assertions.assertNotNull(obtenido);
        Assertions.assertEquals(200, obtenido.getStatusCodeValue());
    }

    @Test
    @DisplayName("Traer todos los estudiantes OK")
    public void listarEstudiantesOkTest(){
        Set<StudentDTO> students = new HashSet<>();
        StudentDTO stu1 = new StudentDTO();
        StudentDTO stu2 = new StudentDTO();
        stu1.setStudentName("Juan");
        stu1.setId(1L);
        stu2.setStudentName("John");
        stu2.setId(2L);
        students.add(new StudentDTO());
        students.add(new StudentDTO());

        when(studentService.getAll()).thenReturn(students);

        Set<StudentDTO> obtenido = studentController.listStudents();

        verify(studentService,times(1)).getAll();

        Assertions.assertNotNull(obtenido);
        Assertions.assertEquals(students,obtenido);
    }

}
