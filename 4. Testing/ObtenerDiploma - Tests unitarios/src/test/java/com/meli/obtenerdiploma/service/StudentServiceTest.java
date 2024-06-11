package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.utils.StudentGenerator;
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
import java.util.Set;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService service;

    StudentDTO student;

    @BeforeEach
    void setUp() {
        student = StudentGenerator.generateStudent();
    }

    @Test
    @DisplayName("Test Caso Exitoso Crear Student")
    public void createTest(){
        //        Act
        service.create(student);
        //        Assert
        verify(studentDAO).save((student));
    }

    @Test
    @DisplayName("Test Caso Exitoso Read")
    public void readTest(){
        // Arrange
        when(studentDAO.findById(student.getId())).thenReturn(student);

        // Act
        StudentDTO result = service.read(student.getId());

        // Assert
        Assertions.assertEquals(student.getId(), result.getId());
        Assertions.assertEquals(student.getStudentName(), result.getStudentName());
        Assertions.assertEquals(student.getSubjects(), result.getSubjects());
    }

    @Test
    @DisplayName("Test Caso No Exitoso Read")
    public void readTestNotFound(){
        // Arrange
        when(studentDAO.findById(student.getId())).thenThrow(StudentNotFoundException.class);

        // Assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> service.read(student.getId()));
    }


    @Test
    @DisplayName("Test Update Exitoso")
    public void updateTest(){
//        Act
        service.update(student);
//        Assert
        verify(studentDAO).save((student));
    }

    @Test
    @DisplayName("Test Delete Exitoso")
    public void deleteTest(){
//        Act
        service.delete(student.getId());
//        Assert
        verify(studentDAO).delete(student.getId());
    }

    @Test
    @DisplayName("Test getAll Exitoso")
    public void getAllTest() {
//        Arange

        Set<StudentDTO> studentList  = Set.copyOf(StudentGenerator.generate3Students());
//        Act
        when(studentRepository.findAll()).thenReturn(studentList);

//        Assert
        Assertions.assertEquals(studentList, service.getAll());
    }
}