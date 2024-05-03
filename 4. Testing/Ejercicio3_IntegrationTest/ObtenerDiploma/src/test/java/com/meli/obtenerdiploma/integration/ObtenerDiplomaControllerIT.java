package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class ObtenerDiplomaControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @BeforeEach
    @AfterEach
    void cleanData() {
        TestUtilsGenerator.usersFile();
    }

    @DisplayName("Test - Obtener Diploma Caso exitoso")
    @Test
    public void testObtenerDiploma() throws Exception {
        StudentDTO student = new StudentDTO(
                1L, "Juan", "El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.",
                7.333333333333333, List.of(
                    new SubjectDTO("Matemática", 9.0),
                    new SubjectDTO("Física", 7.0),
                    new SubjectDTO("Química", 6.0)
            )
        );
        String studentExpected = mapper.writeValueAsString(student);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1L))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(studentExpected, response.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @DisplayName("Test - Obtener diploma caso fallido")
    @Test
    public void testObtenerDiplomaCasoFallido() throws Exception {
        String textExpected = "El alumno con Id 3 no se encuetra registrado.";
        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 3L))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(result -> assertTrue(
                                result.getResolvedException() instanceof StudentNotFoundException
                        )
                );
    }


}
