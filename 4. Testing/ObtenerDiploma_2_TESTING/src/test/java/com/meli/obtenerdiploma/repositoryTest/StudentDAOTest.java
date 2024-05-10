package com.meli.obtenerdiploma.repositoryTest;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class StudentDAOTest {

    StudentDAO studentDAO = new StudentDAO();

//    @BeforeEach
//    public void setUp() {
//        studentDAO = new StudentDAO();
//    }


    @Test
    @DisplayName("Debe de matchear con true en el caso de que el usuario se guarde exisamente")
    public void checkSaveUser(){

        // Arrange
        List<SubjectDTO> subjects = Arrays.asList(
                new SubjectDTO.Builder()
                        .setName("Math")
                        .setScore(9.0)
                        .build(),
                new SubjectDTO.Builder()
                        .setName("English")
                        .setScore(10.0)
                        .build()
                );
        StudentDTO studentDTO = new StudentDTO.Builder()
                .studentName("Alexis")
                .message("Felicidades has aprobado")
                .setId(studentDAO.studentsLength + 1L)
                .subjects(subjects)
                .build();


        // Act
        boolean isStudentStored = studentDAO.save(studentDTO);

        // Assert
        assertTrue(isStudentStored);
    }

    @Test
    @DisplayName("Debe mostrar false ya que no existe un id 1001 en la base de datos")
    public void checkDeleteNonExistentStudent(){
        long idToRemove = 1001L;

        boolean isDeleted = studentDAO.delete(idToRemove);

        assertFalse(isDeleted);
    }

    @Test
    @DisplayName("Debe de retornar true en el caso de que el usuario con el id 5 exista")
    public void checkDeleteExistentStudent(){
        // Arrange
            long idToRemove = 5L;
        // Act
            boolean isDeleted = studentDAO.delete(idToRemove);
        // Assert
            assertTrue(isDeleted);
    }


    @Test
    @DisplayName("Revisar que se lanze la StudentNotFoundException cuando no exista el alumno")
    public void checkFindByIdPossibleException(){
        long idToRemove = 1001L;
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(idToRemove));
    }


}
