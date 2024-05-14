package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTests {

    @Autowired
    MockMvc mockMvc;

    StudentDAO studentDAO = new StudentDAO();

    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController controller;

    @BeforeEach
    void setUp() {
        StudentDTO studentDTO = new StudentDTO(1L,"Juanito Perez","",0.0,
                Arrays.asList(new SubjectDTO("Español",8.0),
                        new SubjectDTO("Ingles",10.0)));
        studentDAO.save(studentDTO);
    }

    @Test
    public void obtenerDiploma() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        controller.analyzeScores(stu.getId());

        // assert
        verify(service, atLeastOnce()).analyzeScores(stu.getId());
    }

    @DisplayName("Obtener diploma de un estudiante que no existe")
    @Test
    public void obtenerDiplomaEstudianteNoExiste() {
        Long id = 100L;
        String typeError = "StudentNotFoundException";

        try {
            this.mockMvc.perform(
                            MockMvcRequestBuilders.get("/analyzeScores/{studentId}",String.valueOf(id))
                                    .contentType(MediaType.APPLICATION_JSON))
                    .andDo(print()).andExpect(status().isNotFound())
                    .andExpect(content().contentType("application/json"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.name").
                            value(typeError));


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DisplayName("Obtener diploma de un estudiante")
    @Test
    public void obtenerDiplomaEstudiante() {
        Long id = 1L;

        try {
            this.mockMvc.perform(
                            MockMvcRequestBuilders.get("/analyzeScores/{studentId}",String.valueOf(id))
                                    .contentType(MediaType.APPLICATION_JSON))
                    .andDo(print()).andExpect(status().isOk())
                    .andExpect(content().contentType("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
