package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import static org.mockito.Mockito.when;

import java.util.HashSet;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTests {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepo;

    @InjectMocks
    StudentService service;


    @Test
    void testCreateStudent() {
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        student.setStudentName("John Doe");

        doNothing().when(studentDAO).save(student); // No se necesita retorno para un método void

        service.create(student);

        verify(studentDAO).save(student);
    }


    @Test
    void testReadStudent() {
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        student.setStudentName("John Doe");

        when(studentDAO.findById(1L)).thenReturn(student);

        StudentDTO retrievedStudent = service.read(1L);

        assertEquals(student, retrievedStudent);
    }

    @Test
    void testUpdateStudent() {
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        student.setStudentName("John Doe");

        doNothing().when(studentDAO).save(student); // No se necesita retorno para un método void

        service.update(student);

        verify(studentDAO).save(student);
    }


    @Test
    void testDeleteStudent() {
        when(studentDAO.delete(1L)).thenReturn(true);

        service.delete(1L);

        assertEquals(true, studentDAO.delete(1L));
    }

    @Test
    void testGetAllStudents() {
        Set<StudentDTO> students = new HashSet<>();

        StudentDTO student = new StudentDTO();
        student.setId(1L);
        student.setStudentName("John Doe");

        StudentDTO student2 = new StudentDTO();
        student2.setId(1L);
        student2.setStudentName("John Doe");
        students.add(student);
        students.add(student2);


        when(studentRepo.findAll()).thenReturn(students);

        Set<StudentDTO> retrievedStudents = service.getAll();

        assertEquals(students.size(), retrievedStudents.size());
        for (StudentDTO stu : retrievedStudents) {
            assertEquals(true, students.contains(stu));
        }
    }

}
