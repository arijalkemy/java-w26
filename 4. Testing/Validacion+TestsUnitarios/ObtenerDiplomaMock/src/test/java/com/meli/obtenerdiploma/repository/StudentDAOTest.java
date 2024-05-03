package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDAOTest {

    private StudentDAO studentDAO = new StudentDAO();

    private StudentDTO createStudent(){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(3L);
        studentDTO.setStudentName("Facundo");
        List<SubjectDTO> list= new ArrayList<>();
        list.add(new SubjectDTO("Matemática", 9.0));
        list.add(new SubjectDTO("Física", 7.0));
        list.add(new SubjectDTO("Química", 6.0));
        studentDTO.setSubjects(list);
        return studentDTO;
    }

    @Test
    public void testSave() {
        StudentDTO studentDTO=createStudent();
        studentDAO.save(studentDTO);

        assertTrue(studentDAO.exists(studentDTO));
    }

    @Test
    public void testDelete() {
        StudentDTO studentDTO=createStudent();

        studentDAO.delete(studentDTO.getId());

        assertFalse(studentDAO.exists(studentDTO));
    }

    @Test
    public void testFindById() {
        StudentDTO studentDTO = studentDAO.findById(1L);

        assertNotNull(studentDTO);
        assertEquals("Juan", studentDTO.getStudentName());
    }


}
