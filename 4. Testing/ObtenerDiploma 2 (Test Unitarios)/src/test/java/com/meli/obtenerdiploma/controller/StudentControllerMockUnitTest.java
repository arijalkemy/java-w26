package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.TestingGeneratorUtil;
import org.apache.http.protocol.HTTP;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerMockUnitTest {


    private StudentDTO estudianteEntrada;
    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController controller;

    @BeforeEach
    public void setup() {
        this.estudianteEntrada = new StudentDTO();
        this.estudianteEntrada.setStudentName("Luis");
        this.estudianteEntrada.setSubjects(List.of(new SubjectDTO("Mate", 10.0)));

    }



    @Test
    @DisplayName("Test - Estudiante registrado con exito")
    public void registerStudent() {
        //ARRANGE

        // ACT
        studentService.create(estudianteEntrada);
        ResponseEntity<?> responseDelMetodoRegisterStudent = controller.registerStudent(estudianteEntrada);

        //ASSERT

        verify(studentService, times(2)).create(estudianteEntrada);
        Assertions.assertEquals(HttpStatus.OK, responseDelMetodoRegisterStudent.getStatusCode());
        Assertions.assertNull(responseDelMetodoRegisterStudent.getBody());

    }

    @Test
    @DisplayName("Test - Obtencion del estuidante con id exitosamente devuelto")
    public void getStudentById() {
        // ARRANGE
        Long idStudent = 1L;
        estudianteEntrada.setId(idStudent);

        when(studentService.read(idStudent)).thenReturn(estudianteEntrada);
        StudentDTO estudianteDevuelto = controller.getStudent(idStudent);

        Assertions.assertEquals(estudianteEntrada, estudianteDevuelto);


    }

    @Test
    @DisplayName("Test - Modificacion de un usario de forma exitosa")
    public void modificacionDeEstudiante(){

        StudentDTO estudiante = new StudentDTO();

        studentService.update(estudiante);

        ResponseEntity<?> respuestaDelMetodoPost = controller.modifyStudent(estudiante);

        Assertions.assertEquals(HttpStatus.OK, respuestaDelMetodoPost.getStatusCode());
        Assertions.assertNull(respuestaDelMetodoPost.getBody());
    }

    @Test
    @DisplayName("TEST - Eliminacacion de un estudiante por id exitosamente")
    public void quitarUnEstudiante() {
        Long id = 1L;
        studentService.update(estudianteEntrada);

        ResponseEntity<?> responseMetodoRemoveStudent = controller.removeStudent(id);

        Assertions.assertEquals(HttpStatus.OK, responseMetodoRemoveStudent.getStatusCode());
        Assertions.assertNull(responseMetodoRemoveStudent.getBody());

    }

    @Test
    @DisplayName("Test - Obtencion de todos los usuarios de forma exitosa")
    public void obtenerTodosLosUsuarios(){
        Set<StudentDTO> listaDeEstudiantes = TestingGeneratorUtil.setDeEstudiantes();

        when(studentService.getAll()).thenReturn(listaDeEstudiantes);
        Set<StudentDTO> setDeEstudiantesObtenidos = controller.listStudents();

        Assertions.assertEquals(listaDeEstudiantes, setDeEstudiantesObtenidos);

    }
}
