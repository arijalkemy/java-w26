package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;


import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void GivenAverageScoreThenResponseFelicitacionesTest(){
        StudentDTO stu = loadStudent();
        stu.setSubjects(Arrays.asList(new SubjectDTO("Matematica", 10.0), new SubjectDTO("Lengua", 10.0)));
        when(studentDAO.findById(1l)).thenReturn(stu);
        StudentDTO result = obtenerDiplomaService.analyzeScores(1l);
        Assertions.assertTrue(result.getMessage().contains("Felicitaciones"));
    }

    @Test
    void GivenAverageScoreThenResponsePuedesMejorarTest(){
        StudentDTO stu = loadStudent();
        when(studentDAO.findById(1l)).thenReturn(stu);
        StudentDTO result = obtenerDiplomaService.analyzeScores(1l);
        Assertions.assertTrue(result.getMessage().contains("Puedes mejorar"));
    }

    @Test
    void GivenScores8and10thenResponse9AverageTest(){
        double expected = 9.0;
       StudentDTO stu = loadStudent();
        when(studentDAO.findById((long) 1)).thenReturn(stu);
        StudentDTO result = obtenerDiplomaService.analyzeScores((long) 1);
        Assertions.assertEquals(expected,result.getAverageScore());
    }

    @Test
    void GivenListWithoutScoresThenResponseException(){

        StudentDTO stu = loadStudent();
        stu.setSubjects(null);
        when(studentDAO.findById((long) 1)).thenReturn(stu);
        Assertions.assertThrows(NullPointerException.class,() -> obtenerDiplomaService.analyzeScores(1l));
    }




    public StudentDTO loadStudent(){
        StudentDTO stu = new StudentDTO();
        stu.setId((long) 1);
        stu.setSubjects(Arrays.asList(new SubjectDTO("Matematica", 8.0), new SubjectDTO("Lengua", 10.0)));
        stu.setStudentName("Pedro");
        return stu;
    }

}
