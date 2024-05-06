package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ObtenerDiplomaServiceTest {
    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void calculateAverageTest(){
        List<SubjectDTO> subjectDTOList = new ArrayList<>();

        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Matematicas");
        subjectDTO.setScore(10.0);

        SubjectDTO subjectDTO1 = new SubjectDTO();
        subjectDTO1.setName("Lengua");
        subjectDTO1.setScore(8.0);

        subjectDTOList.add(subjectDTO);
        subjectDTOList.add(subjectDTO1);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Rodrigo");
        studentDTO.setSubjects(subjectDTOList);

        long idStudent = 1;

        when(studentDAO.findById(idStudent)).thenReturn(studentDTO);


        double result = obtenerDiplomaService.analyzeScores(idStudent).getAverageScore();

        Assertions.assertEquals(9.0, result);
    }
}
