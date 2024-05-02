package com.meli.obtenerdiploma.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    StudentDAO repository;
    ObjectMapper mapper = new ObjectMapper();
    @InjectMocks
    ObtenerDiplomaService service;

    @Test
    @DisplayName("Mensaje obtenido correctamente")
    public void analyzeScoresMessageOk(){
        //arrange
        StudentDTO student = getStudent();

        //act
        when(repository.findById(student.getId())).thenReturn(student);
        StudentDTO studentObtained = service.analyzeScores(student.getId());

        //assert
        Assertions.assertTrue(studentObtained.getMessage().equals("El alumno " + studentObtained.getStudentName()
                + " ha obtenido un promedio de "
                + new DecimalFormat("#.##").format(studentObtained.getAverageScore())
                + ". Puedes mejorar."));
    }

    @Test
    @DisplayName("Promedio obtenido correctamente")
    public void analyzeScoresAverageOk(){
        StudentDTO student = getStudent();

        when(repository.findById(student.getId())).thenReturn(student);
        StudentDTO studentObtained = service.analyzeScores(student.getId());

        Assertions.assertTrue(studentObtained.getAverageScore()==2.0);
    }

    @Test
    @DisplayName("Estudiante existente")
    public void analyzeScoresOk() throws JsonProcessingException {
        long id = 1L;

        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Ingles",4.0));
        subjectDTOList.add(new SubjectDTO("Lengua",0.0));

        StudentDTO studentExptected = StudentDTO.builder()
                .id(1L)
                .studentName("jorge")
                .averageScore(2.0)
                .message("El alumno jorge ha obtenido un promedio de "
                        + "2. Puedes mejorar.")
                .subjects(subjectDTOList)
                .build();

        StudentDTO studentInit = StudentDTO.builder()
                .id(1L)
                .studentName("jorge")
                .subjects(subjectDTOList)
                .build();

        when(repository.findById(id)).thenReturn(studentInit);

        String obtained = mapper.writeValueAsString(service.analyzeScores(id));
        String expected = mapper.writeValueAsString(studentExptected);

        Assertions.assertEquals(expected, obtained);
    }

    private StudentDTO getStudent(){
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Ingles",4.0));
        subjectDTOList.add(new SubjectDTO("Lengua",0.0));

        return StudentDTO.builder()
                .id(1L)
                .studentName("jorge")
                .subjects(subjectDTOList)
                .build();
    }


}
