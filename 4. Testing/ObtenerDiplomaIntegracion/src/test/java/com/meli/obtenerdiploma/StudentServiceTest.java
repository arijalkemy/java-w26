package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Arrays;
import java.util.HashSet;
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
    public void createStudentTest() {
        // Preparación
        StudentDTO testStudent = loadStudent();

        // Ejecución
        studentService.create(testStudent);

        // Verificación
        verify(studentDAO, times(1)).save(testStudent);
    }



    @Test
    public void ReadStudentTest() {
        // Preparación
        Long testId = 1L;
        StudentDTO expectedStudent = loadStudent();
        when(studentDAO.findById(testId)).thenReturn(expectedStudent);

        // Ejecución
        StudentDTO result = studentService.read(testId);

        // Verificación
        verify(studentDAO, times(1)).findById(testId);
        Assertions.assertEquals(expectedStudent, result);
    }

    @Test
    public void UpdateStudentTest() {
        // Preparación
        StudentDTO testStudent = loadStudent();

        // Ejecución
        studentService.update(testStudent);

        // Verificación
        verify(studentDAO, times(1)).save(testStudent);
    }

    @Test
    public void DeleteStudentTest() {
        // Preparación
        StudentDTO testStudent = loadStudent();

        // Ejecución
        studentService.delete(testStudent.getId());

        // Verificación
        verify(studentDAO, times(1)).delete(testStudent.getId());
    }

    @Test
    public void testGetAllStudents() {
        // Preparación
        Set<StudentDTO> expectedStudents = new HashSet<>();
        expectedStudents.add(loadStudent());
        when(studentRepository.findAll()).thenReturn(expectedStudents);

        // Ejecución
        Set<StudentDTO> result = studentService.getAll();

        // Verificación
        verify(studentRepository, times(1)).findAll();
        Assertions.assertEquals(expectedStudents, result);
    }





    public StudentDTO loadStudent(){
        StudentDTO stu = new StudentDTO();
        stu.setId((long) 1);
        stu.setSubjects(Arrays.asList(new SubjectDTO("Matematica", 8.0), new SubjectDTO("Lengua", 10.0)));
        stu.setStudentName("Pedro");
        return stu;
    }
}
