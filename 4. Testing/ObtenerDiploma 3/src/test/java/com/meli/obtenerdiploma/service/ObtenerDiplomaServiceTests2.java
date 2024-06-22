package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTests2 {
    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Analyze scores")
    public void analyzeScoresTest(){
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        studentDTO.setId(1L);
        when(studentDAO.findById(1L)).thenReturn(studentDTO);

        obtenerDiplomaService.analyzeScores(1L);
    }

}
