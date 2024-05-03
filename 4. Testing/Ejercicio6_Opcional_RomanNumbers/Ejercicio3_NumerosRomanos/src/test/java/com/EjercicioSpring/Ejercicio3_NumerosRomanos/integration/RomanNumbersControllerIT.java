package com.EjercicioSpring.Ejercicio3_NumerosRomanos.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RomanNumbersControllerIT {

    @Autowired
    MockMvc mockMvc;

    @DisplayName("Integration Test - Conversión exitosa de números")
    @ParameterizedTest
    @CsvSource({
            "1, I",
            "3, III",
            "5, V",
            "7, VII",
            "10, X",
            "50, L",
            "-50, -L"
    })
    void translateNumberTest(Integer value, String expected) throws Exception {
        mockMvc.perform(get("/translateNumber/{number}", value))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(result -> assertEquals(expected, result.getResponse().getContentAsString()));
    }

}
