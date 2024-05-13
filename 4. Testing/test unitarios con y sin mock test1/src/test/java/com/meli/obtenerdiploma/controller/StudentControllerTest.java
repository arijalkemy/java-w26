package com.meli.obtenerdiploma.controller;


import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    StudentDTO studentDTO;
    SubjectDTO subjectDTO;

    @BeforeEach
    public void setUp() {
        studentDTO = new StudentDTO();
        subjectDTO = new SubjectDTO();

        List<SubjectDTO> subjectDTOList = new ArrayList<>();

        subjectDTO.setName("mate");
        subjectDTO.setScore(8.0);

        subjectDTOList.add(subjectDTO);

        studentDTO.setStudentName("Pedro");
        studentDTO.setId(1L);
        studentDTO.setSubjects(subjectDTOList);

    }

    @Test
    @DisplayName("registerStudent")
    public void testRegisterStudent() {

        studentService.create(studentDTO);

        studentController.registerStudent(studentDTO);

        verify(studentService, atLeast(1)).create(studentDTO);
    }

    @Test
    @DisplayName("obtener estudiante por id")
    public void testGetStudent() {
        when(studentService.read(1L)).thenReturn(studentDTO);

        studentController.getStudent(1L);

        verify(studentService, atLeast(1)).read(1L);
    }

    @Test
    @DisplayName("modificar estudiante")
    public void testModifyStudent() {
        studentService.update(studentDTO);

        studentController.modifyStudent(studentDTO);

        verify(studentService, atLeast(1)).update(studentDTO);
    }

    @Test
    @DisplayName("eliminar estudiante")
    public void testRemoveStudent() {
        studentService.delete(1L);

        studentController.removeStudent(1L);

        verify(studentService, atLeast(1)).delete(1L);
    }

    @Test
    @DisplayName("listar estudiantes")
    public void testListStudents() {
        studentService.getAll();

        studentController.listStudents();

        verify(studentService, atLeast(1)).getAll();
    }
}
