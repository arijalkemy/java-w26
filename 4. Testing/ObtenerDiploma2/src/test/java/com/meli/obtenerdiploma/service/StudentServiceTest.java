package com.meli.obtenerdiploma.service;

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
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private IStudentDAO studentDAO;
    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    private StudentDTO monicaStudent;
    private StudentDTO cristinaStudent;
    private Set<StudentDTO> listStudents;

    @BeforeEach
    void setUp(){
        cristinaStudent = new StudentDTO(2L, "Cristina", "Felicitaciones", 50D,
                List.of(new SubjectDTO("Matematicas", 9.5D),
                        new SubjectDTO("biologia", 9.5D),
                        new SubjectDTO("politica", 9.5D)));
        monicaStudent = new StudentDTO(1L,"Monica", "Puedes mejorar", 50D,
                List.of(new SubjectDTO("Matematicas", 9.5D),
                        new SubjectDTO("biologia", 9.5D),
                        new SubjectDTO("politica", 9.5D)));


    listStudents = Set.of(monicaStudent, cristinaStudent);
    }

    @Test
    void readShouldReturnStudent(){
        when(studentDAO.findById(2L)).thenReturn(cristinaStudent);
        StudentDTO studentDTO = studentService.read(2L);

        Assertions.assertEquals(studentDTO.getStudentName(), "Cristina");
        Assertions.assertEquals(studentDTO.getAverageScore(), 50D);

    }

    @Test
    void getAllShouldReturnListOfStudents(){
        when(studentRepository.findAll()).thenReturn(listStudents);
        Set<StudentDTO> list = studentService.getAll();

        Assertions.assertEquals(list.size(), 2);
    }

    @Test
    void createShouldCallRepository(){
        studentService.create(monicaStudent);

        Mockito.verify(studentDAO).save(monicaStudent);
    }

    @Test
    void deleteShouldCallRepository(){
        studentService.delete(2L);

        Mockito.verify(studentDAO).delete(2L);
    }


    @Test
    void updateShouldCallRepository(){
        studentService.update(monicaStudent);

        Mockito.verify(studentDAO).save(monicaStudent);
    }









}
