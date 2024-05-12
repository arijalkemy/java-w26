package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Assertions;
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
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    public void create() {
        // Arrange
        Long studentId = 1L;
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Math", 5.0));
        subjects.add(new SubjectDTO("Science", 7.0));
        StudentDTO student = new StudentDTO(studentId, "Jane Doe", null, null, subjects);

        // Act
        doNothing().when(studentDAO).save(student);
        studentService.create(student);

        // Asserrt
        verify(studentDAO, atLeast(1)).save(student);
    }

    @Test
    public void read() {
        // Arrange
        Long studentId = 9L;

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Math", 5.0));
        subjects.add(new SubjectDTO("Science", 7.0));
        StudentDTO studentExpected = new StudentDTO(studentId, "Jane Doe", null, null, subjects);

        // Act
        when(studentDAO.findById(studentId)).thenReturn(studentExpected);
        StudentDTO result = studentService.read(studentExpected.getId());

        // Assert
        Assertions.assertEquals(studentExpected.getId(), result.getId());
        Assertions.assertEquals(studentExpected.getStudentName(), result.getStudentName());
        Assertions.assertEquals(studentExpected.getMessage(), result.getMessage());
        Assertions.assertEquals(studentExpected.getAverageScore(), result.getAverageScore());
    }

    @Test
    public void update() {
        // Arrange
        Long studentId = 2L;
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Math", 5.0));
        subjects.add(new SubjectDTO("Science", 7.0));
        StudentDTO student = new StudentDTO(studentId, "Jane Doe", null, null, subjects);

        // Act
        doNothing().when(studentDAO).save(student);
        studentService.update(student);

        // Asserrt
        verify(studentDAO, atLeast(1)).save(student);
    }

    @Test
    public void delete() {
        // Arrange
        Long studentId = 104L;

        // Act
        when(studentDAO.delete(studentId)).thenReturn(true);
        studentService.delete(studentId);

        // Asserrt
        verify(studentDAO, atLeast(1)).delete(studentId);
    }

    @Test
    public void findAll() {
        // Arrange
        Set<StudentDTO> students = new HashSet<>();
        students.add(new StudentDTO(1L, "Jane Doe", null, null, List.of()));
        students.add(new StudentDTO(2L, "Jane Doe", null, null, List.of()));
        students.add(new StudentDTO(3L, "Jane Doe", null, null, List.of()));

        // Act
        when(studentRepository.findAll()).thenReturn((Set<StudentDTO>) students);
        Set<StudentDTO> studentsResult = studentRepository.findAll();

        // Asserrt
        verify(studentRepository, atLeastOnce()).findAll();
        Assertions.assertEquals(students.size(), studentsResult.size());
    }

}
