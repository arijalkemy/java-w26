package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StudentDAOTests {
    IStudentDAO studentDAO;

    @BeforeEach
    public void setUp(){
        TestUtilsGenerator.emptyUsersFile();
        this.studentDAO = new StudentDAO();
    }

    @Test
    @DisplayName("Crear un estudiante nuevo")
    public void createNonExistentStudent() {
        // arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        studentDAO.save(student);

        // assert
        Assertions.assertTrue(studentDAO.exists(student));
        Assertions.assertEquals(1L, student.getId());
        Assertions.assertEquals(studentDAO.findById(student.getId()), student);
    }

    @Test
    @DisplayName("Crear un estudiante existente")
    public void createExistentStudent() {
        // arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        studentDAO.save(student);

        // assert
        Assertions.assertTrue(studentDAO.exists(student));
        Assertions.assertEquals(1L, student.getId());
        Assertions.assertEquals(studentDAO.findById(student.getId()), student);
    }

    @Test
    @DisplayName("Modificar estudiante inexistente")
    public void modifyNonExistentStudent() {
        // arrange
        StudentDTO student1 = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        StudentDTO student2 = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        student2.setId(999L);
        student2.setStudentName("Marco Polo");

        studentDAO.save(student1);

        // act
        studentDAO.save(student2);

        // assert
        Assertions.assertTrue(studentDAO.exists(student1));
        Assertions.assertEquals(1L, student1.getId());
        Assertions.assertEquals(studentDAO.findById(student1.getId()), student1);

        Assertions.assertTrue(studentDAO.exists(student2));
        Assertions.assertEquals(2L, student2.getId());
        Assertions.assertEquals(studentDAO.findById(student2.getId()), student2);

    }

    @Test
    @DisplayName("Modificar el nombre (un atributo) de un estudiante existente")
    public void modifyExistentStudent() {
        // arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        studentDAO.save(student);

        // act
        student.setStudentName("Marco Polo");
        studentDAO.save(student);

        // assert
        Assertions.assertTrue(studentDAO.exists(student));
        Assertions.assertEquals(1L, student.getId());
        Assertions.assertEquals(studentDAO.findById(student.getId()), student);
    }

    @Test
    @DisplayName("Encontrar un estudiante por id")
    public void findExistentStudent() {
        // arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        studentDAO.save(student);

        // act
        StudentDTO found = studentDAO.findById(student.getId());

        // assert
        Assertions.assertEquals(found, student);
    }

    @Test
    @DisplayName("Buscar un estudiante que no existe")
    public void findNonExistentStudent() {
        // arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act & assert
        Assertions.assertThrows(StudentNotFoundException.class,() -> studentDAO.findById(student.getId()));
    }

    @Test
    @DisplayName("Eliminar un estudiante existente por id")
    public void deleteExistentStudent() {
        // arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        studentDAO.save(student);

        // act
        studentDAO.delete(student.getId());

        // assert
        Assertions.assertFalse(studentDAO.exists(student));
        Assertions.assertThrows(StudentNotFoundException.class,() -> studentDAO.findById(student.getId()));
    }

    @Test
    @DisplayName("Eliminar un estudiante que no existe")
    public void deleteNonExistentStudent() {
        // arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        studentDAO.delete(student.getId());

        // assert
        Assertions.assertFalse(studentDAO.exists(student));
        Assertions.assertThrows(StudentNotFoundException.class,() -> studentDAO.findById(student.getId()));
    }
}
