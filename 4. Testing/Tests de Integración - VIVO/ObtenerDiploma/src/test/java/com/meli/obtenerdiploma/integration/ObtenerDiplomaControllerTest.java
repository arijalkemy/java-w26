package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@AutoConfigureMockMvc
@SpringBootTest()
public class ObtenerDiplomaControllerTest {

    /*
     * ID correcto | DTO: Status: ok
     * ID Incorrect | Message error: ID no encontrado (Similar) status: 404
     * ID que no es del mismo tipo de dato (Dudoso) | 404 Message from sprint
     * Sin ID (Dudoso) | 404 Message from sprint
     */

    /**
     * Spring MockMVC: Se puede configurar de 3 maneras
     * - Con @AutoConfigureMockMVC Nota:
     * - Usando MockMVCBuilders.standAlone(new Controller()) Nota: Solo carga la
     * configuración necesaria para dicho endpoint
     * - Usando MockMVCBuilders.standAlone(WebContextApplications (la instancia) )
     * Nota: es un ambiente mas realista pues se cargan otros componentes
     * como @ControllerAdvice, @Validators
     */
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    // @BeforeEach
    // public void beforeEachRequest(WebApplicationContext wac) {
    // this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    // }

    @Test
    @DisplayName("Test if the analyze scores is correct for an exists Student With ID 1, following reosurces users.json")
    public void succesfullyGetAnalyzeScoresTest() throws Exception {

        // Arrange

        StudentDTO studentExpected = TestUtilsGenerator.getFirstStudent();
        Long idStudent = studentExpected.getId();

        RequestBuilder request = get("/analyzeScores/{studentId}", idStudent).contentType(MediaType.APPLICATION_JSON);
        // Act
        ResultActions result = mockMvc.perform(request);
        result.andDo(print());

        String bodyResponse = result.andReturn().getResponse().getContentAsString(Charset.forName("utf-8"));

        // Assertions
        result.andExpect(status().isOk());
        result.andExpect(content().contentType(MediaType.APPLICATION_JSON));
        result.andExpect(jsonPath("$.averageScore").value(studentExpected.getAverageScore()));
        result.andExpect(jsonPath("$.message").value(studentExpected.getMessage()));

        Assertions.assertEquals(objectMapper.writeValueAsString(studentExpected), bodyResponse);

    }

    @Test
    @DisplayName("Test if the analyze scores is correct for an not exists Student With ID -1, following reosurces users.json")
    public void badIdGetAnalyzeScoresTest() throws Exception {

        // Arrange

        Long idStudent = -1L;

        RequestBuilder request = get("/analyzeScores/{studentId}", idStudent).contentType(MediaType.APPLICATION_JSON);
        // Act
        ResultActions result = mockMvc.perform(request);
        result.andDo(print());

        // Assertions
        result.andExpect(status().isNotFound());
        result.andExpect(content().contentType(MediaType.APPLICATION_JSON));
        result.andExpect(
                jsonPath("$.description").value("El alumno con Id " + idStudent + " no se encuetra registrado."));
        result.andExpect(jsonPath("$.name").value("StudentNotFoundException"));
    }

    @Test
    @DisplayName("Test if the analyze scores endpoint return bad request for a not exists Student With ID 'NotID'")
    public void badRequestGetAnalyzeScoresTest() throws Exception {

        // Arrange

        String idStudent = "NotID";

        RequestBuilder request = get("/analyzeScores/{studentId}", idStudent).contentType(MediaType.APPLICATION_JSON);
        // Act
        ResultActions result = mockMvc.perform(request);
        result.andDo(print());

        // Assertions
        result.andExpect(status().isBadRequest());
    }
/* Nota: no es responsabilidad de Controlador ObtenerDiplomaController.java     
    @Test
    @DisplayName("Test if the analyze scores endpoint return bad request for a not exists Student With ID 'NotID'")
    public void badEndpointGetAnalyzeScoresTest() throws Exception {

        // Arrange


        RequestBuilder request = get("/analyzeScores/").contentType(MediaType.APPLICATION_JSON);
        // Act
        ResultActions result = mockMvc.perform(request);
        result.andDo(print());

        // Assertions
        result.andExpect(status().isBadRequest());
    }
*/
}
