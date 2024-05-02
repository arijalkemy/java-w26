package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.utils.StudentDTOGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import javax.management.DescriptorKey;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    IStudentService service;

    @InjectMocks
    StudentController controller;

    private StudentDTO studentDTO;
    private Long id;
    private Long notExisitingId;

    @BeforeEach
    public void setup() {
        id = 1L;
        notExisitingId = 2L;
        studentDTO = StudentDTOGenerator.generateStudentDTO(id, "Juan perez", StudentDTOGenerator.generateSubjectsDTOWithAverage(9));
    }

    @Test
    @DisplayName("/registerStudent test return ok")
    public void registerStudentTest() {
        ResponseEntity<?> expected = ResponseEntity.ok(null);
        ResponseEntity<?> result = controller.registerStudent(studentDTO);
        verify(service, atLeastOnce()).create(studentDTO);
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DescriptorKey("/getStudent/{id} status ok")
    public void getStudentTestOk() {
        when(service.read(id)).thenReturn(studentDTO);
        StudentDTO result = controller.getStudent(id);
        verify(service, atLeastOnce()).read(id);
        Assertions.assertEquals(studentDTO, result);
    }

    @Test
    @DescriptorKey("/getStudent/{id} not founded student")
    public void getStudentTestBadReq() {
        when(service.read(notExisitingId)).thenThrow(new StudentNotFoundException(notExisitingId));
        Assertions.assertThrows(StudentNotFoundException.class, () -> controller.getStudent(notExisitingId));
        verify(service, atLeastOnce()).read(notExisitingId);
    }

    @Test
    @DisplayName("/modifyStudent ok")
    public void modifyStudentTestOk() {
        ResponseEntity<?> result = controller.modifyStudent(studentDTO);
        verify(service, atLeastOnce()).update(studentDTO);
        ResponseEntity<?> expected = ResponseEntity.ok(null);
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DescriptorKey("/removeStudent/{id} ok")
    public void removeStudentTestOk() {
        ResponseEntity<?> result = controller.removeStudent(id);
        ResponseEntity<?> expected = ResponseEntity.ok(null);
        verify(service, atLeastOnce()).delete(id);
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DescriptorKey("/removeStudent/{id} not founded student")
    public void removeStudentTestNotFounded() {
        doThrow(new StudentNotFoundException(notExisitingId)).when(service).delete(notExisitingId);
        Assertions.assertThrows(StudentNotFoundException.class, () -> controller.removeStudent(notExisitingId));
        verify(service, atLeastOnce()).delete(notExisitingId);
    }

    @Test
    @DescriptorKey("/listStudents test ok")
    public void listStudentsTest() {
        Set<StudentDTO> expected = new HashSet<>();
        expected.add(studentDTO);
        when(service.getAll()).thenReturn(expected);
        Set<StudentDTO> result = controller.listStudents();
        verify(service, atLeastOnce()).getAll();
        Assertions.assertEquals(expected, result);
    }
}
