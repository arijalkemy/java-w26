package com.meli.obtenerdiploma.service.sadPath;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceSadPathTest {
    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    @DisplayName("it should throw StudentNotFoundException when trying to read non-existent student")
    public void readNoExistingStudent(){
        // arrange
        Long nonExistentId = 999L;
        when(studentDAO.findById(nonExistentId)).thenThrow(new StudentNotFoundException(nonExistentId));

        // act & assert
        assertThrows(StudentNotFoundException.class, () -> studentService.read(nonExistentId));
    }


    @Test
    @DisplayName("it should throw StudentNotFoundException when trying to delete non-existent student")
    public void deleteNonExistentStudentTest(){
        // arrange
        Long nonExistentId = 999L;
        when(studentDAO.delete(nonExistentId)).thenReturn(false);
        studentDAO.delete(nonExistentId);

        // act/assert
        verify(studentDAO).delete(nonExistentId);
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
