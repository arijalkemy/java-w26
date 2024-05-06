package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.utils.GenerateStudentsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    IStudentDAO iStudentDAO;
    @Mock
    IStudentRepository iStudentRepository;

    @InjectMocks
    StudentService studentService;

    private StudentDTO studentDTO;

    @BeforeEach
    void setupTest(){
        studentDTO = new StudentDTO(1L, "Juan", "Perez", 10.0, new ArrayList<>(){
            {
                add(new SubjectDTO("Matematicas", 10.0));
            }
        });
    }

    @Test
    public void testCreate(){
        studentService.create(new StudentDTO(1L, "Juan", "Perez", 10.0, new ArrayList<>(){
            {
                add(new SubjectDTO("Matematicas", 10.0));
            }
        }));

        verify(iStudentDAO, atLeastOnce()).save(any());
    }

    @Test
    public void testRead(){
        when(iStudentDAO.findById(1L)).thenReturn(new StudentDTO(1L, "Juan", "Perez", 10.0, new ArrayList<>(){
            {
                add(new SubjectDTO("Matematicas", 10.0));
            }
        }));

        assertEquals(studentDTO, studentService.read(1L));
    }

    @Test
    void testReadWithIdInvalid(){
        when(iStudentDAO.findById(2L)).thenThrow(StudentNotFoundException.class);

        assertThrows(StudentNotFoundException.class, () -> {
            studentService.read(2L);
        });
    }

    @Test
    public void testUpdate(){
        studentService.update(new StudentDTO(1L, "Juan", "Perez", 10.0, new ArrayList<>(){
            {
                add(new SubjectDTO("Matematicas", 10.0));
            }
        }));

        verify(iStudentDAO, atLeastOnce()).save(any());
    }

    @Test
    public void testDelete(){
        studentService.delete(1L);
        verify(iStudentDAO, atLeastOnce()).delete(any());
    }

    @Test
    public void testGetAll(){
        when(iStudentRepository.findAll()).thenReturn(GenerateStudentsTest.generateStudents());
        assertEquals(GenerateStudentsTest.generateStudents() ,studentService.getAll());
    }
}
