package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@DisplayName("Tests para los diplomas")
class ObetenerDiplomaApplicationTests {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentDAO studentDAO;

    @BeforeEach
    public void setUp() {
        Set<StudentDTO> studentDTOS = new HashSet<>();
        Mockito.when(studentRepository.findAll()).thenReturn(studentDTOS);
    }

    @Test
    @DisplayName("Verificar los imports")
    public void contextLoads() {
        Assertions.assertThat(studentRepository).isNotNull();
        Assertions.assertThat(studentDAO).isNotNull();
    }

    @Test
    @DisplayName("Encontrar todos los estudiantes")
    public void findAll() {
        // Given

        // When
        Set<StudentDTO> studentList = studentRepository.findAll();

        // Then
        Assertions.assertThat(studentList).isNotNull();
    }

    @Test
    @DisplayName("Guardar un nuevo estudiante")
    public void saveTest() {
        // Given - Arrange
        List<SubjectDTO> subjectsDto = new ArrayList<>(
                List.of(new SubjectDTO("Math", 12.2))
        );
        StudentDTO newStudent = new StudentDTO(4L, "Juan", "Msg", 7.2, subjectsDto);

        // When - Act
//        Mockito.when(studentDAO.save(newStudent)).thenCallRealMethod();

        // Then - Assert
        Assertions.assertThat(studentDAO.exists(newStudent)).isEqualTo(true);
    }
}
