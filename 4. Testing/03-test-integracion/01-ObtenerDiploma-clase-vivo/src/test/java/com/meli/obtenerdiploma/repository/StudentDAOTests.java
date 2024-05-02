package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.*;


public class StudentDAOTests {

    IStudentDAO studentDAO;

    @BeforeEach @AfterEach
    private void setUp() {
       TestUtilsGenerator.emptyUsersFile();
       this.studentDAO = new StudentDAO();
    }

    @Test
    public void createNonExistentStudent() {
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        studentDAO.save(stu);

        Assertions.assertTrue(studentDAO.exists(stu));
        Assertions.assertEquals(1L, stu.getId());
        Assertions.assertEquals(studentDAO.findById(stu.getId()), stu);
    }

    @Test
    public void createExistentStudent() {
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        studentDAO.save(stu);

        Assertions.assertTrue(studentDAO.exists(stu));
        Assertions.assertEquals(1L, stu.getId());
        Assertions.assertEquals(studentDAO.findById(stu.getId()), stu);
    }

    @Test
    public void modifyNonExistentStudent() {
        StudentDTO stu1 = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        StudentDTO stu2 = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        stu2.setId(999L);
        stu2.setStudentName("Marco Polo");

        studentDAO.save(stu1);

        studentDAO.save(stu2);

        Assertions.assertTrue(studentDAO.exists(stu1));
        Assertions.assertEquals(1L, stu1.getId());
        Assertions.assertEquals(studentDAO.findById(stu1.getId()), stu1);

        Assertions.assertTrue(studentDAO.exists(stu2));
        Assertions.assertEquals(2L, stu2.getId());
        Assertions.assertEquals(studentDAO.findById(stu2.getId()), stu2);
    }

    @Test
    public void modifyExistentStudent() {
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        studentDAO.save(stu);

        stu.setStudentName("Marco Polo");
        studentDAO.save(stu);

        Assertions.assertTrue(studentDAO.exists(stu));
        Assertions.assertEquals(1L, stu.getId());
        Assertions.assertEquals(studentDAO.findById(stu.getId()), stu);
    }

    @Test
    public void findExistentStudent() {
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        studentDAO.save(stu);

        StudentDTO found = studentDAO.findById(stu.getId());

        Assertions.assertEquals(found, stu);
    }

    @Test
    public void findNonExistentStudent() {
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        Assertions.assertThrows(StudentNotFoundException.class,() -> studentDAO.findById(stu.getId()));
    }

    @Test
    public void deleteExistentStudent() {
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        studentDAO.save(stu);

        studentDAO.delete(stu.getId());

        Assertions.assertFalse(studentDAO.exists(stu));
        Assertions.assertThrows(StudentNotFoundException.class,() -> studentDAO.findById(stu.getId()));
    }

    @Test
    public void deleteNonExistentStudent() {
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        studentDAO.delete(stu.getId());

        Assertions.assertFalse(studentDAO.exists(stu));
        Assertions.assertThrows(StudentNotFoundException.class,() -> studentDAO.findById(stu.getId()));
    }
}
