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
        this.studentDAO=new StudentDAO();
    }

    @Test
    @DisplayName("Guardar un estudiante que no existe en el users.json")
    public void saveNonExistentStudent(){
        //Arrange
        StudentDTO student = new StudentDTO(
                99L,
                "Andrés",
                null,
                null,
                List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 8.0),
                        new SubjectDTO("Poo", 7.0)
                )
        );
        //Act
        studentDAO.save(student);
        //Assert
        Assertions.assertEquals(student, studentDAO.findById(student.getId()));
    }

    @Test
    @DisplayName("Guardar un estudiante ya existente en el users.json")
    public void saveExistentStudent(){
        //Arrange
        StudentDTO student = new StudentDTO(
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
        //Act&Assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.save(student));
    }

    @Test
    @DisplayName("Buscando un usuario por id que no existe")
    public void findNonExistentStudentByIdTest(){
        //Arrange
        Long id = 99L;
        //Act&Assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(id));
    }

    @Test
    @DisplayName("Buscando un usuario existente")
    public void findExistentStudentByIdTest(){
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
        StudentDTO actual = studentDAO.findById(id);

        //Asser
        Assertions.assertEquals(studentDTO.getId(), actual.getId());
    }

    @Test
    @DisplayName("Eliminando un usuario que no existe")
    public void deleteNonExistentStudentTest(){
        //Arrange
        Long id = 99L;
        //Act&Assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.delete(id));
    }

    @Test
    @DisplayName("Eliminando un usuario que existe")
    public void deleteExistentStudentTest() {
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

        //Act&Assert
        Assertions.assertTrue(studentDAO.exists(studentDTO));
        Assertions.assertTrue(studentDAO.delete(studentDTO.getId()));
    }

    @Test
    @DisplayName("Comprobando existencia de un usuario")
    public void studentExistsOnDBTest(){
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
        boolean actual;
        // Act
        actual = studentDAO.exists(studentDTO);
        // Assert
        Assertions.assertTrue(actual);

    }

    @Test
    @DisplayName("Comprobando la no existencia de un usuario")
    public void studentDoesntExistsOnDBTest(){
        //Arrange
        StudentDTO studentDTO = new StudentDTO(
                2L,
                "Salomé",
                null,
                null,
                List.of(
                        new SubjectDTO("Kahoot",10.0)
                )
        );
        boolean actual;
        // Act
        actual = studentDAO.exists(studentDTO);
        // Assert
        Assertions.assertFalse(actual);
    }


}
