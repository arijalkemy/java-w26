package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTests {

    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController controller;

    @Autowired
    MockMvc mockMvc;

    StudentDAO studentDAO = new StudentDAO();

    @BeforeEach
    public void createEnvironment(){
        StudentDTO studentDTO = new StudentDTO(1L,"Juan","",0.0, List.of(new SubjectDTO("Math",9.0)));
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
    @Test
    public void analyzeOk() throws Exception{
        Long id = 1L;
        mockMvc.perform(get("/analyzeScores/{studentId}",id)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }
    @Test
    public void analyzeNotOk() throws Exception{
        Long id = 333333L;

        mockMvc.perform(get("/analyzeScores/{studentId}",id)).andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("description").value("El alumno con Id 333333 no se encuetra registrado."))
                .andReturn();
    }

}
