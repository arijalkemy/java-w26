package com.EjercicioSpring.Ejercicio3_NumerosRomanos.controllers;

import com.EjercicioSpring.Ejercicio3_NumerosRomanos.service.RomanNumbersService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class RomanNumbersControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    RomanNumbersService romanNumbersService;

    @DisplayName("Test - Conversión exitosa de números")
    @ParameterizedTest
    @CsvSource({
            "1, I",
            "3, III",
            "5, V",
            "7, VII",
            "10, X",
            "50, L"
    })
    void translateNumberTest(Integer value, String expected) throws Exception {
        // Arrange
        when(romanNumbersService.convertDecimalToRoman(value)).thenReturn(expected);
        // Act - Assert
        mockMvc.perform(get("/translateNumber/{number}", value))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(result -> assertEquals(expected, result.getResponse().getContentAsString()));

    }


}