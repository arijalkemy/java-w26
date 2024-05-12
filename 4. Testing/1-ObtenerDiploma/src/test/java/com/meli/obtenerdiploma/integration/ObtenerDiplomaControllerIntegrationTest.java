package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.ErrorDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void analyzeScoresTest() throws Exception {
        mockMvc.perform(get("/analyzeScores/{studentId}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.averageScore").value((7+9+6)/3))
                .andReturn();
    }

    @Test
    public void analyzeScoresTestSadPath() throws Exception {

        ErrorDTO errorDTO = new ErrorDTO("StudentNotFoundException", "El alumno con Id 3 no se encuetra registrado.");

        MvcResult mvcResult = mockMvc.perform(get("/analyzeScores/{studentId}", 3))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        ObjectWriter ow = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        Assertions.assertEquals(ow.writeValueAsString(errorDTO), mvcResult.getResponse().getContentAsString());

    }

  /*
    @MockBean
    private IObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void testAnalyzeScores() throws Exception {
        Long studentId = 1L;
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(studentId);

        when(obtenerDiplomaService.analyzeScores(anyLong())).thenReturn(studentDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", studentId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(studentId));
    }

   */
}
