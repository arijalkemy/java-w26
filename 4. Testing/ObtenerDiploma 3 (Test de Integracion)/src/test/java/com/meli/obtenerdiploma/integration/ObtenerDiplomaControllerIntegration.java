package com.meli.obtenerdiploma.integration;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegration {


    @MockBean
    ObtenerDiplomaService obtenerDiplomaService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAnalyseScores() throws Exception {

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setId(1L);
        studentDTO.setStudentName("Juan");
        studentDTO.setMessage("El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.");
        studentDTO.setAverageScore(7.33);
        studentDTO.setSubjects(new ArrayList<>(List.of(new SubjectDTO("Matemática", 9.0), new SubjectDTO("Física", 7.0), new SubjectDTO("Química", 6.0))));

        when(obtenerDiplomaService.analyzeScores(1L)).thenReturn(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1L))
                    .andDo(print()).andExpect(status().isOk())
                    .andExpect(content().contentType("application/json"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value(studentDTO.getStudentName()))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value(studentDTO.getAverageScore()));

    }
}
