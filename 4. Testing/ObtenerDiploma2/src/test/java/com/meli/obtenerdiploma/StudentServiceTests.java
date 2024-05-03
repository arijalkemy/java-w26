package com.meli.obtenerdiploma;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTests {
    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    private Set<StudentDTO> testList;
    private StudentDTO studentExpected;

    @BeforeEach
    public void setup() throws IOException {
        MockitoAnnotations.openMocks(this);

        testList = new HashSet<>();

        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Ingles", 4.0));
        subjectDTOList.add(new SubjectDTO("Lengua", 0.0));

        studentExpected = new StudentDTO();
        studentExpected.setId(0L);
        studentExpected.setStudentName("Juan");
        studentExpected.setSubjects(subjectDTOList);
        testList.add(studentExpected);

        studentDAO.setStudents(testList);
    }

    @Test
    @DisplayName("Alumno se guarda con éxito")
    public void saveStudentTest(){
        studentService.create(studentExpected);

        verify(studentDAO).save(studentExpected);
    }

    @Test
    @DisplayName("Alumno se elimina con éxito")
    public void deleteStudentTest(){
        studentService.delete(studentExpected.getId());
        verify(studentDAO).delete(studentExpected.getId());
    }

    @Test
    @DisplayName("Alumno se actualiza con éxito")
    public void updateStudentTest(){
        studentService.update(studentExpected);
        verify(studentDAO).save(studentExpected);
    }

    @Test
    @DisplayName("Alumno se lee con éxito")
    public void readStudentTest() {
        //Arrange
        StudentDTO expected = studentExpected;

        //Act
        when(studentDAO.findById(0L)).thenReturn(studentExpected);
        StudentDTO obtained = studentService.read(0L);

        //Assert
        Assertions.assertEquals(expected, obtained);
    }

    @Test
    @DisplayName("Find all trae todo")
    public void readAllStudentTest() {
        //Arrange
        Set<StudentDTO> expected = testList;

        //Act
        when(studentRepository.findAll()).thenReturn(testList);
        Set<StudentDTO> obtained = studentService.getAll();

        //Assert
        Assertions.assertEquals(expected, obtained);
    }

}
