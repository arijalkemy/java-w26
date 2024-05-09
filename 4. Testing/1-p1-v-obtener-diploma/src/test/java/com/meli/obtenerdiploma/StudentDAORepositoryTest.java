package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class StudentDAORepositoryTest {

    private static StudentDAO studentDAO;

    @BeforeAll
    static void setup() {
        studentDAO = new StudentDAO();
    }

    @Test
    @DisplayName("Estudiante nuevo guardado exitosamente.")
    void saveNewStudentTest() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(
                3L,
                "Carlos",
                "Mensaje",
                9.7,
                new ArrayList<SubjectDTO>()
        );

        // Act
         studentDAO.save(studentDTO);

        // Assert
        Assertions.assertTrue(studentDAO.exists(studentDTO));
    }

    @Test
    @DisplayName("Estudiante existente guardado exitosamente")
    void saveExistentStudentTest() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(
                1L,
                "Carlos",
                "Mensaje",
                9.7,
                new ArrayList<SubjectDTO>()
        );

        // Act
        studentDAO.save(studentDTO);

        // Assert
        Assertions.assertTrue(studentDAO.exists(studentDTO));
    }

    @Test
    @DisplayName("Falla al guardar un estudiante nulo")
    void saveNullStudentTest() {
        // Act & Assert
        Assertions.assertThrows(NullPointerException.class, () -> {
            studentDAO.save(null);
        });
    }

    @Test
    @DisplayName("Estudiante existente eliminado exitosamente")
    void deleteExistentStudentTest() {
        // Act
        boolean result = studentDAO.delete(2L);

        // Assert
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Eliminación fallida de estudiante no existente")
    void deleteNotExistentStudentTest() {
        // Act
        boolean result = studentDAO.delete(1L);

        // Assert
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Verificar que el estudiante existe")
    void findByIdSuccessfullyTest() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(
                3L,
                "Carlos",
                "Mensaje",
                9.7,
                new ArrayList<SubjectDTO>()
        );

        // Act
        boolean result = studentDAO.exists(studentDTO);

        // Assert
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Verificar que el estudiante no existe")
    void findByIdFailedTest() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(
                6L,
                "Carlos",
                "Mensaje",
                9.7,
                new ArrayList<SubjectDTO>()
        );

        // Act
        boolean result = studentDAO.exists(studentDTO);

        // Assert
        Assertions.assertFalse(result);
    }
}
