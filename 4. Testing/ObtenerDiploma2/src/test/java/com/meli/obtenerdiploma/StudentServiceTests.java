package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
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

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTests {
    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    private Set<StudentDTO> studentSet;
    private StudentDTO sample;

    @BeforeEach
    void setUp() {
        studentSet = new HashSet<>();
        sample = new StudentDTO();
        sample.setId(0L);
        sample.setStudentName("Juan");
        sample.setSubjects(List.of(new SubjectDTO("Matemática", 10.0)));
        studentSet.add(sample);
    }

    @Test
    @DisplayName("Alumno se lee con éxito")
    public void readStudentTest() {
        //Arrange
        StudentDTO expected = sample;

        //Act
        when(studentDAO.findById(0L)).thenReturn(sample);
        StudentDTO obtained = studentService.read(0L);

        //Assert
        Assertions.assertEquals(expected, obtained);
    }

    @Test
    @DisplayName("Find all trae todo")
    public void readAllStudentTest() {
        //Arrange
        Set<StudentDTO> expected = studentSet;

        //Act
        when(studentRepository.findAll()).thenReturn(studentSet);
        Set<StudentDTO> obtained = studentService.getAll();

        //Assert
        Assertions.assertEquals(expected, obtained);
    }

}
