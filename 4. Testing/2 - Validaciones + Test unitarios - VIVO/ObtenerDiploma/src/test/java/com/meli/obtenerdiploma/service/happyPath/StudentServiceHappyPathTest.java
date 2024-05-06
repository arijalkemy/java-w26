package com.meli.obtenerdiploma.service.happyPath;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceHappyPathTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    @DisplayName("it should added correctly a student into the repository")
    public void createStudentTest(){
        // arrange
        StudentDTO studentInput = this.createDTO();

        // act
        studentService.create(studentInput);

        // arrage
        verify(studentDAO).save(studentInput);
    }

    @Test
    @DisplayName("it should return a student by id")
    public void readStudentTest(){
        // arrange
        StudentDTO studentInput = this.createDTO();

        // act
        when(studentDAO.findById(1L)).thenReturn(studentInput);
        StudentDTO studentOutput = studentService.read(studentInput.getId());

        // assert
        assertEquals(studentInput, studentOutput);
    }

    @Test
    @DisplayName("it should update the data of a student")
    public void updateStudentTest(){
        StudentDTO studentInput = this.createDTO();
        StudentDTO updatedStudentInput = new StudentDTO(
                1L,
                "J. Perez Updated",
                "",
                0.0,
                new ArrayList<>(
                        Arrays.asList(
                                new SubjectDTO("Animacion II", 8.0)
                        )
                )
        );

        // act
        studentService.create(studentInput);
        studentService.update(updatedStudentInput);
        when(studentDAO.findById(updatedStudentInput.getId())).thenReturn(updatedStudentInput);
        StudentDTO studentOutput = studentService.read(updatedStudentInput.getId());

        // assert
        assertEquals(updatedStudentInput, studentOutput);
    }

    @Test
    @DisplayName("it should update the delete a student from the repository")
    public void deleteStudentTest(){
        // arrange
        Long id = 12L;

        // act
        studentService.delete(id);

        // assert
        verify(studentDAO).delete(id);
    }

    @Test
    @DisplayName("it should return a Set of StudentDTO")
    public void getAllStudents(){
        // arrange
        StudentDTO student1 = createDTO();
        StudentDTO student2 = createDTO();
        student2.setStudentName("Pepe");
        Set<StudentDTO> expectedStudents = new HashSet<>();
        expectedStudents.add(student1);
        expectedStudents.add(student2);

        // arrange
        when(studentRepository.findAll()).thenReturn(expectedStudents);
        Set<StudentDTO> actualStudents = studentService.getAll();

        // assert
        assertEquals(expectedStudents.size(), actualStudents.size());
        assertTrue(expectedStudents.containsAll(actualStudents));
        assertTrue(actualStudents.containsAll(expectedStudents));

    }

    public StudentDTO createDTO(){
        return new StudentDTO(
                1L,
                "Jose",
                "",
                0.0,
                new ArrayList<SubjectDTO>(Arrays.asList(
                        new SubjectDTO(
                                "Fisica",
                                10.0
                        ),
                        new SubjectDTO(
                                "Graficacion",
                                9.0
                        ),
                        new SubjectDTO(
                                "Circuitos",
                                6.0
                        )
                ))
        );
    }
}
















