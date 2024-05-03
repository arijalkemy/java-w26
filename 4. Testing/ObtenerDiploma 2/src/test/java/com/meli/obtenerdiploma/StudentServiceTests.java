package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.service.StudentService;
import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTests {

    StudentDTO studentDTO;
    Set<StudentDTO> students;
    Set<StudentDTO> emptyStudents;


    @Mock
    private IStudentRepository studentRepository;

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    public void setup() {
        List<SubjectDTO> subjects = List.of(new SubjectDTO("Math", 10.0));
        this.studentDTO = new StudentDTO(1L, "Juan", "", null, subjects);
        this.students = new HashSet<>();
        students.add(studentDTO);
        this.emptyStudents = new HashSet<>();
    }

    @Test
    @DisplayName("Buscar todos los estudiantes debe traerlos.")
    public void getAllStudentsTest() {
        when(studentRepository.findAll()).thenReturn(students);
        Set<StudentDTO> retrievedStudents = studentService.getAll();
        Assertions.assertEquals(students, retrievedStudents);
    }

    @Test
    @DisplayName("Buscar todos los estudiantes debe traer una lista vacía si no hay estudiantes.")
    public void getAllEmptyStudentsTest() {
        when(studentRepository.findAll()).thenReturn(emptyStudents);
        Set<StudentDTO> retrievedStudents = studentService.getAll();
        Assertions.assertEquals(emptyStudents, retrievedStudents);
    }

}
