package com.meli.obtenerdiploma.repository;


import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.*;

import java.util.List;

public class StudentDAOTest {

    private StudentDAO studentDAO;

    @BeforeEach
    public void setup(){
        this.studentDAO = new StudentDAO();
    }

    @Test
    @DisplayName("Test to save a student with used ID")
    public void saveTestUsedID(){
//            Arrange
        StudentDTO studentDTO = new StudentDTO(1L,
                "Pedro",
                "message",
                10.0,
               null);

//            Act
            studentDAO.save(studentDTO);

//            Assert
        Assertions.assertTrue(studentDAO.exists(studentDTO));
    }

    @Test
    @DisplayName("Test to save a student with New ID")
    public void saveTestNewID(){
//            Arrange
        StudentDTO studentDTO = new StudentDTO(3L,
                "Nombre",
                "message",
                10.0,
                null);

//            Act
        studentDAO.save(studentDTO);

//            Assert
        Assertions.assertTrue(studentDAO.exists(studentDTO));
    }

    @Test
    @DisplayName("Find a Student by Id")
    public void findByIdTest(){
//        Arrange
        List<SubjectDTO> subjectDTOList = List.of(
                new SubjectDTO("Matemática",9D),
                new SubjectDTO("Física",7D),
                new SubjectDTO("Química",6D)
        );
        StudentDTO studentDTO = new StudentDTO(1L,
                "Juan",
                null,
                null,
                subjectDTOList);

        studentDAO.save(studentDTO);

        System.out.println(studentDTO);
//        Act & Assert
        Assertions.assertEquals(studentDTO.getStudentName(), studentDAO.findById(studentDTO.getId()).getStudentName());
    }

    @Test
    @DisplayName("Find a Student by Id not Existent")
    public void findByIdTestNotExistent(){
//        Arrange
        StudentDTO studentDTO = new StudentDTO(5L,
                "Nombre",
                "message",
                10.0,
                null);

//        Act & Assert
        Assertions.assertThrows(
                StudentNotFoundException.class,
                () -> studentDAO.findById(studentDTO.getId()));
    }

    @Test
    @DisplayName("Eliminar un alumno.")
    public void deleteStudent(){
//        Arrange
        Long id = 1L;

        Assertions.assertTrue(studentDAO.delete(id));

    }

    @Test
    @DisplayName("Eliminar un alumno No encontrado.")
    public void deleteStudentNotFound(){
//        Arrange
        Long id = 10L;

//        Act & Assert
        Assertions.assertFalse(studentDAO.delete(id));

    }


    @Test
    @DisplayName("Test Student Exists")
    public void existsTestTrue(){
//        Arrange
        List<SubjectDTO> subjectDTOList = List.of(
                new SubjectDTO("Matemática",9D),
                new SubjectDTO("Física",7D),
                new SubjectDTO("Química",6D)
        );
        StudentDTO studentDTO = new StudentDTO(5L,
                "Juan",
                null,
                null,
                subjectDTOList);

        studentDAO.save(studentDTO);
        // Act & Assert

        Assertions.assertTrue(studentDAO.exists(studentDTO));

    }

    @Test
    @DisplayName("Test Student Not Exists")
    public void existsTestFalse(){
//        Arrange
        List<SubjectDTO> subjectDTOList = List.of(
                new SubjectDTO("Matemática",9D),
                new SubjectDTO("Física",7D),
                new SubjectDTO("Química",6D)
        );
        StudentDTO studentDTO = new StudentDTO(5L,
                "Juan",
                null,
                null,
                subjectDTOList);

        // Act & Assert

        Assertions.assertFalse(studentDAO.exists(studentDTO));

    }

}
