package com.meli.obtenerdiploma.integration;

import com.meli.obtenerdiploma.util.TestUtils;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegration {

    @Autowired
    MockMvc mockmvc;

    @BeforeAll
    static void setUp() {
        TestUtils.loadData();
    }

    @AfterAll
    static void tearDown() {
        TestUtils.deleteInfoRepository();
    }

    @Test
    @DisplayName("analiza el score de un estudiante que si existe")
    public void analyzeScoresOfExistentStudentTest() throws Exception{
        mockmvc.perform(get("/analyzeScores/{studentId}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id" ).value(1));
    }

    @Test
    @DisplayName("devuelve la excepción StudentNotFoundException de un estudiante que no existe")
    public void analyzeScoresOfNotExistentStudentTest() throws Exception{
        Integer id = 10;
        mockmvc.perform(get("/analyzeScores/{studentId}", id))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.name" ).value("StudentNotFoundException"))
                .andExpect(jsonPath("$.description" ).value(
                        "El alumno con Id " + id + " no se encuetra registrado."));
    }
}
