package com.meli.obtenerdiploma.unitarytest;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    //Mockear el service
    private IStudentService studentService;
    @InjectMocks
    //Inyectamos el service en el controller
    private StudentController studentController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void registerStudentTest() {
        StudentDTO studentDTO = new StudentDTO(123L, "Manuel", "", 0.0, Arrays.asList(
                new SubjectDTO("Matematicas", 10.0),
                new SubjectDTO("Fisica", 10.0),
                new SubjectDTO("Quimica", 10.0)
        ));
        doNothing().when(studentService).create(studentDTO);
        studentController.registerStudent(studentDTO);

        verify(studentService, times(1)).create(studentDTO);
    }

    @Test
    void getStudentTest() {
        StudentDTO studentDTO = new StudentDTO(123L, "Manuel", "", 0.0, Arrays.asList(
                new SubjectDTO("Matematicas", 10.0),
                new SubjectDTO("Fisica", 10.0),
                new SubjectDTO("Quimica", 10.0)
        ));
        when(studentService.read(123L)).thenReturn(studentDTO);
        StudentDTO result = studentController.getStudent(123L);
        assertEquals(studentDTO, result);
    }

    @Test
    void modifyStudentTest() {
        StudentDTO studentDTO = new StudentDTO(123L, "Manuel", "", 0.0, Arrays.asList(
                new SubjectDTO("Matematicas", 10.0),
                new SubjectDTO("Fisica", 10.0),
                new SubjectDTO("Quimica", 10.0)
        ));
        doNothing().when(studentService).update(studentDTO);
        studentController.modifyStudent(studentDTO);

        verify(studentService, times(1)).update(studentDTO);
    }

    @Test
    void removeStudentTest() {
        doNothing().when(studentService).delete(123L);
        studentController.removeStudent(123L);

        verify(studentService, times(1)).delete(123L);

    }

    @Test
    void listStudentsTest() {
        Set<StudentDTO> students = Set.of(
                new StudentDTO(123L, "Manuel", "", 0.0, Arrays.asList(
                        new SubjectDTO("Matematicas", 10.0),
                        new SubjectDTO("Fisica", 10.0),
                        new SubjectDTO("Quimica", 10.0)
                )),
                new StudentDTO(123L, "Pepe", "", 0.0, Arrays.asList(
                        new SubjectDTO("Matematicas", 10.0),
                        new SubjectDTO("Fisica", 10.0),
                        new SubjectDTO("Quimica", 10.0)
                ))
        );
        when(studentService.getAll()).thenReturn(students);
        Set<StudentDTO> result = studentController.listStudents();
        assertEquals(students, result);

    }

}
