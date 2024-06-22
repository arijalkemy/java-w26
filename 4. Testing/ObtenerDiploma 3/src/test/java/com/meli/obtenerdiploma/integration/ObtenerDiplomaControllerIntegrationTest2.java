package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTest2 {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    @DisplayName("Verify analize scores with average greater than 9")
    public void verifyAnalizeScoreWithAverageGreaterThan9() throws Exception {

        StudentDTO studentExpectedDTO = getStudentDTO();

        MvcResult mvcResult = mockMvc
                .perform(get("/analyzeScores/1"))
                .andDo(print())
                .andReturn();

        StudentDTO studentResultDTO = objectMapper.readValue(
                mvcResult
                        .getResponse()
                        .getContentAsString(),
                StudentDTO.class
        );

        System.out.println(studentResultDTO);

        System.out.println(studentExpectedDTO);


        Assertions.assertEquals(studentResultDTO,studentExpectedDTO);
    }

    private static @NotNull StudentDTO getStudentDTO() {
        SubjectDTO matematica = new SubjectDTO("Math", 10.0d);
        SubjectDTO science = new SubjectDTO("Science", 6.0d);

        List<SubjectDTO> subjectDTOList = List.of(matematica,science);

        return new StudentDTO(
                1L,
                "Test",
                "El alumno Test ha obtenido un promedio de 8,00. Puedes mejorar.",
                8.0D,
                subjectDTOList
        );
    }


}
