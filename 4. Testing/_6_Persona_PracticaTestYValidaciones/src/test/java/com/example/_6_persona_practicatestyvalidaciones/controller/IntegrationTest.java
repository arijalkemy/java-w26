package com.example._6_persona_practicatestyvalidaciones.controller;


import com.example._6_persona_practicatestyvalidaciones.dto.requestDTO.DeporteRequestDTO;
import com.example._6_persona_practicatestyvalidaciones.dto.responseDTO.DeporteResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Deporte cargado correctamente")
    public void testPostDeporte() throws Exception {
        DeporteRequestDTO request = DeporteRequestDTO.builder().nombre("Futbol").nivel(9).build();
        DeporteResponseDTO response = DeporteResponseDTO.builder().nombre("Futbol").nivel(9).build();


        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String requestJson = writer.writeValueAsString(request);
        String responseJson = writer.writeValueAsString(response);

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/Sports")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(requestJson))
                .andDo(print()).andExpect(status().isCreated())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Tira excepcion por errores de validacion de entrada")
    public void testPostDeporteFail() throws Exception {
        DeporteRequestDTO request = DeporteRequestDTO.builder().nombre("futbol").nivel(9).build();

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String requestJson = writer.writeValueAsString(request);

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/Sports")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();


        String responseContent = result.getResponse().getContentAsString();
        Map<String, String> errorResponse = new ObjectMapper()
                .readValue(responseContent, new TypeReference<Map<String,String>>(){});

        Assertions.assertTrue(errorResponse.containsKey("nombre"));
        Assertions.assertEquals("El nombre debe comenzar con mayuscula",
                errorResponse.get("nombre"));
    }

}
