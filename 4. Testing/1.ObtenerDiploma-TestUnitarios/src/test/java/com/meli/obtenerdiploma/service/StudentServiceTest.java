package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @InjectMocks
    private StudentService studentService;
    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }



//ejercicio 3
    @Test
    @DisplayName("Se crea un estudiante")
    void create() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(1L, "John Doe","message",8D,
                List.of(
                        new SubjectDTO("Math", 10D),
                        new SubjectDTO("Science", 9D),
                        new SubjectDTO("History", 8D)));
        // Act
        studentService.create(studentDTO);
        // Assert
        verify(studentDAO).save(studentDTO);
      //  Assertions.assertEquals(studentDTO, studentDAO.findById(1L));

    }

    @Test
    @DisplayName("Busca estudiantes por id y lo devuelve si lo encuentra")
    void read() {
        // Arrange (el parametro requerido y el tipo de devolucion)
        Long idStudent = 1L;

        //act
        studentService.read(idStudent);
        //assert
        verify(studentDAO).findById(idStudent);

    }

    @Test
    @DisplayName("Guarda un estudiante con datos actualizados")
    void update() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(1L, "John Doe","message",8D,
                List.of(
                        new SubjectDTO("Math", 10D),
                        new SubjectDTO("Science", 9D),
                        new SubjectDTO("History", 8D)));
        // Act
        studentService.update(studentDTO);
        // Assert
        verify(studentDAO).save(studentDTO);

    }

    @Test
    @DisplayName("Elimina un estudiante por id")
    void delete() {
        // Arrange
        Long idStudent = 1L;
        // Act
        studentService.delete(idStudent);
        // Assert
        verify(studentDAO).delete(idStudent);
        Assertions.assertNull(studentDAO.findById(idStudent));
    }

    @Test
    @DisplayName("Obtiene todos los datos de estudiantes que estan en el Json")
    void getAll() {
        // Arrange
        HashSet<StudentDTO> students = new HashSet<>();
        students.add(new StudentDTO(1L, "John Doe","message",8D,
                List.of(
                        new SubjectDTO("Math", 10D),
                        new SubjectDTO("Science", 9D),
                        new SubjectDTO("History", 8D))));
        //cuando llamamos al metodo findAll del repositorio, retornara el conjunto de estudiantes
        when(studentRepository.findAll()).thenReturn(students);
        // Act
        studentService.getAll();
        // Assert
        verify(studentRepository).findAll();
        Assertions.assertEquals(students, studentRepository.findAll());
    }
}