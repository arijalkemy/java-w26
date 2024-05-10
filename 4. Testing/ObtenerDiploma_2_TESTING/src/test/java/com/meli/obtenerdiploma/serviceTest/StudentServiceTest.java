package com.meli.obtenerdiploma.serviceTest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    private IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepository;
    @InjectMocks
    private StudentService studentService;

    @Test
    @DisplayName("Se crea a Alexis como un nuevo student")
    public void createStudentTest()
    {
        StudentDTO studentDTO = new StudentDTO.Builder()
                .studentName("Alexis")
                .setId(1001L)
                .build();

        studentService.create(studentDTO);
        verify(studentDAO).save(studentDTO);
    }

    @Test
    public void updateStudentTest()
    {
        StudentDTO studentDTO = new StudentDTO.Builder()
                .setId(1001L)
                .studentName("Alexis")
                .build();

        studentService.update(studentDTO);
        verify(studentDAO).save(studentDTO);
    }

    @Test
    @DisplayName("Check if delete student service")
    public void deleteStudentTest()
    {

        studentService.delete(1001L);
        verify(studentDAO).delete(1001L);
    }
}
