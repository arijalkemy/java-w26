package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.when;

public class ObtenerDiplomaServiceTest {
    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService service;


    @Test
    public void GuardarUnEstudianteTest() {
        when(studentDAO.findById(1L)).thenReturn(new StudentDTO(1L, "Juan", null,null,List.of(new SubjectDTO("Matematicas", 10.0), new SubjectDTO("Fisica", 2.0))));
        StudentDTO studentDTO= service.analyzeScores(1L);
    }




}
