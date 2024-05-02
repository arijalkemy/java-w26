package com.meli.obtenerdiploma.repository;


import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentDAOTest {

    StudentDAO studentDAO;

    @BeforeEach
    void setup(){
        studentDAO = new StudentDAO();
    }

    /*Set<StudentDTO> studentsFake = new HashSet<>();

    @BeforeEach
    void setup() {
        StudentDTO student1 = new StudentDTO();
        student1.setId(1L);
        student1.setStudentName("Juan");
        List<SubjectDTO> subjects1 = new ArrayList<>();
        subjects1.add(new SubjectDTO("Matemática", 9.0));
        subjects1.add(new SubjectDTO("Física", 7.0));
        subjects1.add(new SubjectDTO("Química", 6.0));
        student1.setSubjects(subjects1);
        studentsFake.add(student1);

        StudentDTO student2 = new StudentDTO();
        student2.setId(2L);
        student2.setStudentName("Pedro");
        List<SubjectDTO> subjects2 = new ArrayList<>();
        subjects2.add(new SubjectDTO("Matemática", 10.0));
        subjects2.add(new SubjectDTO("Física", 8.0));
        subjects2.add(new SubjectDTO("Química", 4.0));
        student2.setSubjects(subjects2);
        studentsFake.add(student2);
    }

    @AfterEach
    void cleanList(){
        studentsFake.clear();
    }*/

    @Test
    void findById1(){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Juan");

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matemática", 9.0));
        subjects.add(new SubjectDTO("Física", 7.0));
        subjects.add(new SubjectDTO("Química", 6.0));
        studentDTO.setSubjects(subjects);


        studentDAO.save(studentDTO);
        StudentDTO studentFound = studentDAO.findById(1L);

        Assertions.assertEquals(studentDTO, studentFound);
    }

    /*@Test
    void findById3ReturnException(){
        StudentDTO studentDTO = studentsFake.stream().filter(s -> s.getId() == 1L).findFirst().get();
        studentDAO.save(studentDTO);

        Assertions.assertThrows(StudentNotFoundException.class,
                () -> studentDAO.findById(3L));
    }

    @Test
    void saveStudentOk(){
        StudentDTO studentDTO = studentsFake.stream().filter(s -> s.getId() == 1L).findFirst().get();
        studentDAO.save(studentDTO);

        Assertions.assertTrue(studentDAO.exists(studentDTO));
    }

    @Test
    void deleteExistingStudent(){
        StudentDTO studentDTO = studentsFake.stream().filter(s -> s.getId() == 1L).findFirst().get();
        studentDAO.save(studentDTO);

        Long id = 1L;

        boolean deleted = studentDAO.delete(id);

        Assertions.assertTrue(deleted);
        //Assertions.assertFalse(studentDAO.exists(studentDTO));
    }

    @Test
    void deleteExistingStudent(){
        StudentDTO studentDTO = studentsFake.stream().filter(s -> s.getId() == 1L).findFirst().get();
        studentDAO.save(studentDTO);

        Long id = 1L;

        boolean deleted = studentDAO.delete(id);

        Assertions.assertTrue(deleted);

    }*/

}
