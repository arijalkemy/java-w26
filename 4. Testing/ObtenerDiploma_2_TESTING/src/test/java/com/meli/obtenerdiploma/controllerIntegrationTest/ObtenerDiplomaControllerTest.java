package com.meli.obtenerdiploma.controllerIntegrationTest;


import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTest {

    @Autowired
    private MockMvc mockmvc;


    /**
     * Verficar que se lanze la excepcion cuando se mande como parametro del endpoint un id que no exista
     */

    @Test
    @DisplayName("Verificar que se lanza la exception cuando se llame al endpoint con el id 1001")
    public void analyzeScoresTestNoOK() throws Exception
    {
        StudentDTO student = new StudentDTO.Builder()
                .studentName("Jose")
                .setId(1001L)
                .build();


        mockmvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", student.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound()
                );
    }


    /**
     * Verificar que cuando al endpoint /analyzeScores/{studentId} se le pase
     * studentId: 4
     * retorne la siguiente data:
     * studentName: Alexis
     * message: El alumno Alexis ha obtenido un promedio de 9.5. Felicitaciones!
     * averageScore: 9.5
     */

    @Test
    @DisplayName("Verficar que el endpoint regrese la informacion que deberia de regresar al mandar como studentId=1")
    public void  analyzeScoreTestOk() throws Exception
    {
        long studentId = 1L;
        mockmvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", studentId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.studentName").value("Alexis"))
                .andExpect(jsonPath("$.message")
                        .value("El alumno Alexis ha obtenido un promedio de 8.5. Puedes mejorar."))
                .andExpect(jsonPath("$.averageScore").value(8.5)
                );
    }

}
