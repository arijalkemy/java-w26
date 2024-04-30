package com.meli.obtenerdiploma.integrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAnalyzeScoresSuccessResponse() throws Exception {
        StudentDTO response = createStudentDTO();

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String responseJson = writer.writeValueAsString(response);

        MvcResult mvcResult = mockMvc
            .perform(MockMvcRequestBuilders.get("/analyzeScores/1"))
            .andDo(print())
            .andExpect(status().isOk())
            .andReturn();

        Assertions.assertEquals(mvcResult.getResponse().getContentAsString(), responseJson);
    }

    private StudentDTO createStudentDTO() {
        List<SubjectDTO> subjectDTOList = new ArrayList<SubjectDTO>();
        subjectDTOList.add(
                new SubjectDTO(
                        "Matematica",
                        9.0
                )
        );
        subjectDTOList.add(
                new SubjectDTO(
                        "Fisica",
                        7.0
                )
        );
        subjectDTOList.add(
                new SubjectDTO(
                        "Quimica",
                        8.0
                )
        );

        return new StudentDTO(
                1L,
                "Juan",
                "El alumno Juan ha obtenido un promedio de 8. Puedes mejorar.",
                8.0,
                subjectDTOList
        );
    }
}
