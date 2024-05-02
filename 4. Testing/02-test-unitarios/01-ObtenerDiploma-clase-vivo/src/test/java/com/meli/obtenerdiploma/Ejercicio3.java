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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class Ejercicio3 {

    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    private Set<StudentDTO> studentSet;
    private StudentDTO sample;
    private StudentDTO student;

    @BeforeEach
    void setUp() {
        studentSet = new HashSet<>();
        sample = new StudentDTO();
        sample.setId(0L);
        sample.setStudentName("Juan");
        sample.setSubjects(List.of(new SubjectDTO("Matemática", 10.0)));
        studentSet.add(sample);

        student = new StudentDTO();
        student.setId(1L);
        student.setStudentName("John Doe");

    }

    @Test
    @DisplayName("Crear estudiante")
    void createStudent(){

        studentService.create(student);

        verify(studentDAO, times(1)).save(student);
    }

    @Test
    @DisplayName("Encontrar estudiante")
    void readStudent(){
        when(studentDAO.findById(1L)).thenReturn(student);

        StudentDTO actualStudent = studentService.read(1L);

        assertEquals(student, actualStudent);
        verify(studentDAO, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Actualizar estudiante")
    void updateStudent(){
        student.setStudentName("Jane Doe");

        studentService.update(student);

        verify(studentDAO, times(1)).save(student);
    }

    @Test
    @DisplayName("Eliminar estudiante")
    void deleteStudent(){
        studentService.delete(student.getId());

        verify(studentDAO, times(1)).delete(student.getId());
    }

    @Test
    @DisplayName("Obtener todos los estudiantes")
    void getAllStudents(){
        when(studentRepository.findAll()).thenReturn(studentSet);

        Set<StudentDTO> actualStudents = studentService.getAll();

        assertEquals(studentSet, actualStudents);
        verify(studentRepository, times(1)).findAll();
    }
}
