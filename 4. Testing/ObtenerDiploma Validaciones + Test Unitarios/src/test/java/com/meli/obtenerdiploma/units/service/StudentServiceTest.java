package com.meli.obtenerdiploma.units.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
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

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentRepository studentRepository;

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    StudentService studentService;

    @Test
    @DisplayName("crea un estudiante y verifica que llame al metodo save de StudentDAO")
    public void createStudentTest() {
        //Arrange
        StudentDTO studentDTO = new StudentDTO(1L, "Pepito", "Mensaje",
                10.0, List.of());

        //Act
        studentService.create(studentDTO);

        //Assert
        verify(studentDAO, atLeast(1)).save(studentDTO);
    }

    @Test
    @DisplayName("busca un estudiante y devuelve un estudiante")
    public void readStudentTest() {
        //Arrange
        StudentDTO expected = new StudentDTO(1L, "Pepito", "Mensaje",
                10.0, List.of());

        //Act
        when(studentDAO.findById(expected.getId())).thenReturn(expected);
        StudentDTO output = studentService.read(expected.getId());

        //Assert
        Assertions.assertEquals(expected, output);
    }

    @Test
    @DisplayName("actualiza un estudiante y verifica que llame al metodo save de StudentDAO")
    public void updateStudentTest() {
        //Arrange
        StudentDTO studentDTO = new StudentDTO(1L, "Pepito", "Mensaje",
                10.0, List.of());

        //Act
        studentService.update(studentDTO);

        //Assert
        verify(studentDAO, atLeast(1)).save(studentDTO);
    }

    @Test
    @DisplayName("elimina un estudiante y verifica que llame al metodo delete de StudentDAO")
    public void deleteStudentTest() {
        //Arrange
        Long id = 1L;

        //Act
        studentService.delete(id);

        //Assert
        verify(studentDAO, atLeast(1)).delete(id);
    }

    @Test
    @DisplayName("devuelve un Set con todos los estudiantes")
    public void findAllStudentsTest() {
        //Arrange
        Set<StudentDTO> expected = new HashSet<>();
        expected.add(new StudentDTO(1L, "Pepito","Mensaje",10.0, List.of()));
        expected.add(new StudentDTO(2L, "Pepito 2","Mensaje",9.0, List.of()));
        expected.add(new StudentDTO(3L, "Pepito 3","Mensaje",8.0, List.of()));

        //Act
        when(studentRepository.findAll()).thenReturn(expected);
        Set<StudentDTO> output = studentService.getAll();

        //Assert
        Assertions.assertEquals(output, expected);
    }
}
