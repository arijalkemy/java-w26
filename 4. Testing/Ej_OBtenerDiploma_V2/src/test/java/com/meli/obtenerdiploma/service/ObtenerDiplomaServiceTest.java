package com.meli.obtenerdiploma.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DecimalFormat;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.utils.StudentDtoBuilder;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void whenAnalizeScoreAverageIsUnderThanNineThenReturnMejorar() {

        Long id = Long.MAX_VALUE;
        StudentDTO expectedStudentDTO = StudentDtoBuilder.buildBasicStudentDTO(id);
        Mockito.when(studentDAO.findById(id)).thenReturn(expectedStudentDTO);
        StudentDtoBuilder.setExtraAttributesStudentDto(expectedStudentDTO);

        assertEquals(expectedStudentDTO, obtenerDiplomaService.analyzeScores(id));

    }


}
