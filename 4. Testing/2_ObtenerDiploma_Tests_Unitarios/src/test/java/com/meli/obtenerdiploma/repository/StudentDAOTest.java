package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.utils.CargadorDatos;
import com.meli.obtenerdiploma.utils.StudentUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;


/**
 * Para estos tests se decidió mockear la fuente de datos, debido a que considero
 * que esta fuente de datos es una dependencia externa a lo que estoy testeando.
 */
public class StudentDAOTest {

    private StudentDAO studentDAO;

    private MockedStatic<CargadorDatos> mockedCargadorDatos;

    /**
     * Es necesario mockear CargadorDatos <strong>antes</strong> de crear el StudentDAO,
     * porque ya en el constructor de StudentDAO se ocupa CargadorDatos.
     */
    @BeforeEach
    public void setup() {

        mockedCargadorDatos = Mockito.mockStatic(CargadorDatos.class);

        mockedCargadorDatos.when(() -> CargadorDatos.cargarDatosDeResourceJson(anyString(), eq(StudentDTO.class)))
            .thenReturn(StudentUtils.createTestStudents());

        studentDAO = new StudentDAO();
    }

    @AfterEach
    public void tearDown() {
        mockedCargadorDatos.close();
    }


    @Test
    public void guardarNuevoEstudiante() {

        StudentDTO nuevoEstudiante = StudentDTO.builder()
            .studentName("Pepito")
            .subjects(List.of())
            .build();

        studentDAO.save(nuevoEstudiante);

        assertThat(nuevoEstudiante.getId()).isNotNull();
    }

    @Test
    public void guardarEstudianteExistente() {

        Long idEstudianteExistente = 1L;
        StudentDTO estudianteExistente = StudentDTO.builder()
            .id(idEstudianteExistente)
            .studentName("Pepito")
            .subjects(List.of())
            .build();

        studentDAO.save(estudianteExistente);

        assertThat(estudianteExistente.getId()).isEqualTo(idEstudianteExistente);
    }

    @Test
    public void borrarEstudianteExistente() {

        Long idEstudianteExistente = 2L;

        boolean borrado = studentDAO.delete(idEstudianteExistente);

        assertThat(borrado).isTrue();
    }

    @Test
    public void borrarEstudianteQueNoExiste() {

        boolean borrado = studentDAO.delete(4L);

        assertThat(borrado).isFalse();
    }

    @Test
    public void existeEstudianteTrue() {

        StudentDTO estudianteExistente = StudentDTO.builder().id(2L).build();

        boolean resultado = studentDAO.exists(estudianteExistente);

        assertThat(resultado).isTrue();
    }

    @Test
    public void existeEstudianteFalse() {

        StudentDTO estudianteInexistente = StudentDTO.builder().id(4L).build();

        boolean resultado = studentDAO.exists(estudianteInexistente);

        assertThat(resultado).isFalse();
    }

}