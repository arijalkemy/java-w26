package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentServiceTests {
    @Mock
    private IStudentDAO studentDAO;
    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    private Set<StudentDTO> setEstudiantes;
    private StudentDTO estudiante;
    @BeforeEach
    public void setUp(){
        setEstudiantes = new HashSet<>();
        estudiante = new StudentDTO();
        estudiante.setId(1L);
        estudiante.setStudentName("Juan");
        estudiante.setSubjects(List.of(new SubjectDTO("Fisica",9.0)));
        setEstudiantes.add(estudiante);
    }

    @Test
    @DisplayName("FindAll deberia mostrar todos los estudiantes")
    public void encontrarTodosLosEstudiantes(){
        Set<StudentDTO> esperado = setEstudiantes;

        when(studentRepository.findAll()).thenReturn(setEstudiantes);
        Set<StudentDTO> obtenido = studentService.getAll();

        Assertions.assertEquals(esperado,obtenido);
    }

    @Test
    @DisplayName("Leer alumno exitosamente")
    public void leerEstudianteTest(){
        StudentDTO esperado = estudiante;

        when(studentDAO.findById(1L)).thenReturn(estudiante);
        StudentDTO obtenido = studentService.read(1L);

        Assertions.assertEquals(esperado,obtenido);
    }
}
