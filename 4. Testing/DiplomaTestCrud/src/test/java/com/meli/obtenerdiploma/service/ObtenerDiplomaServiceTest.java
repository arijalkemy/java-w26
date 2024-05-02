package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {
    @Mock
    IStudentDAO student;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    StudentDTO s1;
    long id;

    @BeforeEach
    void init(){
        id = (long) 1;
        s1 = new StudentDTO();

    }

    @Test
    void averageTest() {
        List<SubjectDTO> subjects = List.of( new SubjectDTO( "Literatura", 8.0),new SubjectDTO( "Matematica", 10.0) );
        StudentDTO s1 = new StudentDTO();
        s1.setId( (long) 1);
        s1.setStudentName("Jose");
        s1.setSubjects(subjects);

        when(student.findById((long) 1)).thenReturn(s1);

        StudentDTO s2 = obtenerDiplomaService.analyzeScores((long) 1);

        assertEquals( s2.getAverageScore(),9.0 );
    }

    @Test
    void subjectsNullTest() {
        List<SubjectDTO> subjects = null;
        StudentDTO s1 = new StudentDTO();
        s1.setId( (long) 1);
        s1.setStudentName("Jose");
        s1.setSubjects(subjects);

        when(student.findById((long) 1)).thenReturn(s1);

        assertThrows( NullPointerException.class, () -> obtenerDiplomaService.analyzeScores((long) 1));
    }
}