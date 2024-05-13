package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentRepositoryTest {
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        studentRepository = new StudentRepository();
    }

    @Test
    @DisplayName("Test 1 - Listado de todos los StudentDAO escenario hay datos en el json")
    void listartest() {
        //Arrange: definición de los datos de entrada y de salida
        List<SubjectDTO> subjectDTOList = new ArrayList<>();

        subjectDTOList.add(new SubjectDTO("Matemática", 10.0));
        subjectDTOList.add(new SubjectDTO("Física", 8.0));
        subjectDTOList.add(new SubjectDTO("Química", 4.0));
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(2L);
        studentDTO.setStudentName("Pedro");
        studentDTO.setSubjects(subjectDTOList);

        List<SubjectDTO> subjectDTOList_1 = new ArrayList<>();
        subjectDTOList_1.add(new SubjectDTO("Matemática", 9.0));
        subjectDTOList_1.add(new SubjectDTO("Física", 7.0));
        subjectDTOList_1.add(new SubjectDTO("Química", 6.0));
        StudentDTO studentDTO_1 = new StudentDTO();
        studentDTO_1.setId(1L);
        studentDTO_1.setStudentName("Juan");
        studentDTO_1.setSubjects(subjectDTOList_1);

        Set<StudentDTO> datosEsperados = new HashSet<>();
        datosEsperados.add(studentDTO);
        datosEsperados.add(studentDTO_1);
        //Act: llamado del metodo necesario para la validacion
        Set<StudentDTO> datosObtenidos = studentRepository.findAll();
        //Assert: Comparación de los valores

        Assertions.assertEquals(datosEsperados, datosObtenidos);
    }

    @Test
    @DisplayName("Test 2 - Listado de todos los StudentDAO escenario no hay datos en el json")
    void listarNulltest() {
        //Arrange: definición de los datos de entrada y de salida
        Set<StudentDTO> datosEsperados = new HashSet<>();
        //Act: llamado del metodo necesario para la validacion
        Set<StudentDTO> datosObtenidos = studentRepository.findAll();
        datosObtenidos.removeAll(datosObtenidos);
        //Assert: Comparación de los valores
        Assertions.assertEquals(datosEsperados, datosObtenidos);
    }


}
