package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
public class ObtenerDiplomaControllerTests {

    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController controller;

    @Autowired
    MockMvc mockMvc;

    private Set<StudentDTO> students;

    @BeforeEach
    public void setup() {
        students = TestUtilsGenerator.getStudentSet();
        TestUtilsGenerator.reestartJsonFile(students);
    }

    @Test
    public void obtenerDiplomaTestOk() throws Exception {
        // arrange
        Long id = 1L;
        // act
        controller.analyzeScores(id);
        MvcResult mvcResult =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{id}", id))
                        .andDo(print()).andExpect(status().isOk())
                        .andReturn();

        Assertions.assertEquals("application/json", mvcResult.getResponse().getContentType());
        // assert
        verify(service, atLeastOnce()).analyzeScores(id);
    }

    @Test
    @DisplayName("/analyzeScores/{id} not founded student ")
    public void obtenerDiplomaTestBadPath() throws Exception {
        // arrange
        Long notExistingId = 999L;
        // act
        controller.analyzeScores(notExistingId);
        MvcResult mvcResult =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{id}", notExistingId))
                        .andDo(print()).andExpect(status().isNotFound())
                        .andExpect(content().contentType("application/json"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.description").value(
                                "El alumno con Id " + notExistingId + " no se encuetra registrado.")
                        )
                        .andExpect(MockMvcResultMatchers.jsonPath("$.name")
                                .value("StudentNotFoundException"))
                        .andReturn();

        Assertions.assertEquals("application/json", mvcResult.getResponse().getContentType());
        // assert
        verify(service, atLeastOnce()).analyzeScores(notExistingId);
    }

}
