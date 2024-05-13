package com.meli.obtenerdiploma;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObetenerDiplomaApplicationTestsMocks{

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void averageScoreWellCalculated() {
        StudentDTO arturo = new StudentDTO();
        SubjectDTO subjectDTO = new SubjectDTO();
        List<SubjectDTO> subjectDTOList = new ArrayList<>();

        subjectDTO.setName("mate");
        subjectDTO.setScore(8.0);
        subjectDTOList.add(subjectDTO);

        arturo.setStudentName("arturo");
        arturo.setSubjects(subjectDTOList);

        when(studentDAO.findById(arturo.getId())).thenReturn(arturo);

        obtenerDiplomaService.analyzeScores(arturo.getId());

        verify(studentDAO, atLeastOnce()).findById(arturo.getId());
        assertEquals(8.0, arturo.getAverageScore());

    }

    @Test
    @DisplayName("Leyenda del Diploma")
    public void averageScoreWellCalculated2() {

        StudentDTO arturo = new StudentDTO();
        SubjectDTO subject1 = new SubjectDTO("Matemática", 8.0);
        SubjectDTO subject2 = new SubjectDTO("Lengua", 9.0);
        SubjectDTO subject3 = new SubjectDTO("Física", 10.0);
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(subject1);
        subjectDTOList.add(subject2);
        subjectDTOList.add(subject3);

        arturo.setStudentName("arturo");
        arturo.setSubjects(subjectDTOList);

        when(studentDAO.findById(arturo.getId())).thenReturn(arturo);


        obtenerDiplomaService.analyzeScores(arturo.getId());

        verify(studentDAO, atLeastOnce()).findById(arturo.getId());
        assertEquals("El alumno arturo ha obtenido un promedio de 9. Puedes mejorar.", arturo.getMessage());
    }

}
