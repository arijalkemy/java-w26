package com.meli.obtenerdiploma.service;


import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    public void createExistentStudentTest(){
        //Arrange
        StudentDTO studentDTO = new StudentDTO(
                1L,
                "Anibal",
                null,
                null,
                List.of(
                        new SubjectDTO("Kahoot", 9.0),
                        new SubjectDTO("Musica", 9.0),
                        new SubjectDTO("POO", 10.0)
                )
        );
        //Act
        doThrow(StudentNotFoundException.class).when(studentDAO).save(studentDTO);

        //Assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentService.create(studentDTO));
    }

    @Test
    public void createNonExistentStudentTest(){
        //Arrange
        StudentDTO studentDTO = new StudentDTO(
                2L,
                "Andrés",
                null,
                null,
                List.of(
                        new SubjectDTO("Kahoot", 9.0)
                )
        );
        //Act
        studentService.create(studentDTO);
        //Assert
        verify(studentDAO, atLeast(1)).save(studentDTO);
    }

    @Test
    public void readExistentStudentTest(){
        //Arrange
        Long id = 1L;
        StudentDTO studentDTO = new StudentDTO(
                1L,
                "Anibal",
                null,
                null,
                List.of(
                        new SubjectDTO("Kahoot", 9.0),
                        new SubjectDTO("Musica", 9.0),
                        new SubjectDTO("POO", 10.0)
                )
        );
        //Act
        when(studentDAO.findById(id)).thenReturn(studentDTO);
        //Assert
        Assertions.assertEquals(studentDTO, studentService.read(id));
    }

    @Test
    public void readNonExistentStudentTest(){
        //Arrange
        Long id = 2L;
        //Act
        when(studentDAO.findById(id)).thenThrow(StudentNotFoundException.class);
        //Assert
        Assertions.assertThrows(StudentNotFoundException.class, ()->studentService.read(id));

    }

    @Test
    public void deleteExistentStudentTest(){
        //Arrange
        Long id = 1L;
        //Act
        when(studentDAO.delete(id)).thenReturn(true);
        //Assert
        Assertions.assertTrue(studentService.delete(id));
    }

    @Test
    public void deleteNonExistentStudentTest(){
        //Arrange
        Long id = 2L;
        //Act
        when(studentDAO.delete(id)).thenThrow(StudentNotFoundException.class);
        //Assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentService.delete(id));
    }

    @Test
    public void gettingAllStudentsTest(){
        //Arrange
        Set<StudentDTO> students = new HashSet<>(
                List.of(
                        new StudentDTO(
                                1L,
                                "Anibal",
                                null,
                                null,
                                List.of(
                                        new SubjectDTO("Matematica", 9.0)
                                )

                        )
                )
        );
        //Act
        when(studentRepository.findAll()).thenReturn(students);
        //Assert
        Assertions.assertEquals(students, studentService.getAll());
    }




}
