package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;;

@SpringBootTest
public class StudentDAOTest {
    @InjectMocks
    StudentDAO studentDAO;
    @Mock
    ObjectMapper mapper;

    private Set<StudentDTO> testList;

    @BeforeEach
    public void setup() throws IOException {

        testList = new HashSet<>();
        // Configurar el mock de ObjectMapper para devolver datos predefinidos al leer desde un archivo
        Set<StudentDTO> testData = new HashSet<>();
        // Agregar datos de prueba según sea necesario
        when(mapper.readValue(any(File.class), any(TypeReference.class))).thenReturn(testData);

        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Ingles",4.0));
        subjectDTOList.add(new SubjectDTO("Lengua",0.0));

        StudentDTO studentExptected = StudentDTO.builder()
                .id(1L)
                .averageScore(2.0)
                .subjects(subjectDTOList)
                .build();

        testList.add(studentExptected);

        studentDAO.students = testList;
    }

    @Test
    @DisplayName("Guardar un nuevo estudiante ok")
    public void saveOk(){
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Ingles",7.0));
        subjectDTOList.add(new SubjectDTO("Lengua",2.0));

        StudentDTO studentExptected = StudentDTO.builder()
                .studentName("Roberto")
                .subjects(subjectDTOList)
                .build();

        studentDAO.save(studentExptected);

        Assertions.assertTrue(studentExptected.getId()!=null);
    }

    @Test
    @DisplayName("Modificar estudiante ok")
    public void modifyOk(){
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Ingles",4.0));
        subjectDTOList.add(new SubjectDTO("Monito",0.0));

        StudentDTO studentExptected = StudentDTO.builder()
                .id(1L)
                .averageScore(2.0)
                .subjects(subjectDTOList)
                .build();

        studentDAO.save(studentExptected);

        Assertions.assertTrue(studentExptected.getId()==1);
    }

    @Test
    @DisplayName("Validar estudiante encontrado")
    public void existFound(){
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Ingles",4.0));
        subjectDTOList.add(new SubjectDTO("Lengua",0.0));

        StudentDTO studentExptected = StudentDTO.builder()
                .id(1L)
                .averageScore(2.0)
                .subjects(subjectDTOList)
                .build();

        boolean result = studentDAO.exists(studentExptected);

        assertTrue(result);
    }

    @Test
    @DisplayName("Validar estudiante no encontrado")
    public void existsNotFound(){
        StudentDTO studentExptected = new StudentDTO();
        studentExptected.setId(123L);

        boolean result = studentDAO.exists(studentExptected);

        assertFalse(result);
    }

    @Test
    @DisplayName("Eliminado con exito")
    public void deleteTrue(){
        Long id = 1L;

        boolean result = studentDAO.delete(id);

        assertTrue(result);

    }

    @Test
    @DisplayName("Estudiante encontrado")
    public void findById() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Ingles",4.0));
        subjectDTOList.add(new SubjectDTO("Lengua",0.0));

        StudentDTO studentExptected = StudentDTO.builder()
                .id(1L)
                .averageScore(2.0)
                .subjects(subjectDTOList)
                .build();

        StudentDTO studentObtained = studentDAO.findById(1L);

        String studentExpectedJSON = mapper.writeValueAsString(studentExptected);
        String studentObtainedJSON = mapper.writeValueAsString(studentObtained);

        assertEquals(studentExpectedJSON, studentObtainedJSON);
    }
}
