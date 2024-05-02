package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    StudentDTO studentToRepository = new StudentDTO();

    Set<StudentDTO> students = new HashSet<>();

    @BeforeEach
    void setup(){
        studentToRepository.setId(1L);
        studentToRepository.setStudentName("Juan");

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matemática", 9.0));
        subjects.add(new SubjectDTO("Física", 7.0));
        subjects.add(new SubjectDTO("Química", 6.0));
        studentToRepository.setSubjects(subjects);

        StudentDTO student1 = new StudentDTO();
        student1.setId(1L);
        student1.setStudentName("Juan");
        List<SubjectDTO> subjects1 = new ArrayList<>();
        subjects1.add(new SubjectDTO("Matemática", 9.0));
        subjects1.add(new SubjectDTO("Física", 7.0));
        subjects1.add(new SubjectDTO("Química", 6.0));
        student1.setSubjects(subjects1);
        students.add(student1);

        StudentDTO student2 = new StudentDTO();
        student2.setId(2L);
        student2.setStudentName("Pedro");
        List<SubjectDTO> subjects2 = new ArrayList<>();
        subjects2.add(new SubjectDTO("Matemática", 10.0));
        subjects2.add(new SubjectDTO("Física", 8.0));
        subjects2.add(new SubjectDTO("Química", 4.0));
        student2.setSubjects(subjects2);
        students.add(student2);
    }

    @Test
    void createStudent(){

        studentService.create(studentToRepository);

        verify(studentDAO, atLeastOnce()).save(studentToRepository);
    }

    @Test
    void readStudentWithId1() {
        Long id = 1L;

        when(studentDAO.findById(id)).thenReturn(studentToRepository);

        var student = studentService.read(id);

        Assertions.assertEquals(studentToRepository, student);

    }

    @Test
    void readStudentWithId3ReturnsException() {
        Long id = 3L;

        Assertions.assertThrows(StudentNotFoundException.class,
                () -> studentService.read(id));
    }

    @Test
    void getAllReturnsTwoStudents(){
        when(studentRepository.findAll()).thenReturn(students);

        var studentsFromService = studentService.getAll();

        Assertions.assertEquals(students, studentsFromService);
        Assertions.assertTrue(studentsFromService.size() == 2);
    }
}
