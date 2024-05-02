package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.utils.StudentDTOGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
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

    private StudentDTO studentDTO;
    private Long studentId;

    @BeforeEach
    public void setup(){
        studentId = 1L;
        studentDTO = StudentDTOGenerator.generateStudentDTO(studentId, "Facundo Lopez",
                StudentDTOGenerator.generateSubjectsDTOWithAverage(9)
                );
    }

    @Test
    @DisplayName("chek if studentDAO.save is triggered")
    public void createStudentTest() {
        studentService.create(studentDTO);
        verify(studentDAO, atLeastOnce()).save(studentDTO);
    }

    @Test
    @DisplayName("check if studentService.read return correctly")
    public void readTest() {
        when(studentDAO.findById(studentId)).thenReturn(studentDTO);
        Assertions.assertEquals(studentService.read(studentId), studentDTO);
    }

    @Test
    @DisplayName("test studentService.update ")
    public void updateTest() {
        studentService.update(studentDTO);
        verify(studentDAO, atLeastOnce()).save(studentDTO);
    }

    @Test
    @DisplayName("test studentService.delete")
    public void deleteTest() {
        studentService.delete(studentId);
        verify(studentDAO, atLeastOnce()).delete(studentId);
    }

    @Test
    @DisplayName("test studentService.getAll retrieving")
    public void getAll() {
        Set<StudentDTO> studentsExpected = Set.of(
                studentDTO
        );
        when(studentRepository.findAll()).thenReturn(studentsExpected);

        Set<StudentDTO> result = studentRepository.findAll();

        Assertions.assertEquals(studentsExpected, result);
    }

}
