package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.utils.CargadorDatos;
import com.meli.obtenerdiploma.utils.StudentUtils;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;

/**
 * Ver comentario en {@link StudentDAOTest}.
 */
public class StudentRepositoryTest {

    @Test
    public void findAll() {

        StudentRepository studentRepository = new StudentRepository();
        Set<StudentDTO> expectedStudents = StudentUtils.createTestStudents();

        try (MockedStatic<CargadorDatos> mockedCargadorDatos = Mockito.mockStatic(CargadorDatos.class)) {

            mockedCargadorDatos.when(() -> CargadorDatos.cargarDatosDeResourceJson(anyString(), eq(StudentDTO.class)))
                .thenReturn(StudentUtils.createTestStudents());

            Set<StudentDTO> actualStudents = studentRepository.findAll();

            assertThat(actualStudents).isEqualTo(expectedStudents);
        }
    }
}