package com.viajescuidados.viajescuidados.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.viajescuidados.dtos.UbicacionDTO;
import com.viajescuidados.dtos.ViajeDTO;
import com.viajescuidados.dtos.responses.ViajeResponseDTO;
import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class ViajesControllerTest {
    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    private static ObjectMapper objectMapper;

    @BeforeAll
    public static void setup() {
        writer = new ObjectMapper()
                        .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                        .writer();

        objectMapper = new ObjectMapper();
    }

    @Test
    public void crearUnViajeTest() throws Exception {
        UbicacionDTO origen = new UbicacionDTO("", -100L, -200L);
        UbicacionDTO destino = new UbicacionDTO("", -300L, -400L);
        ViajeDTO viajeDTO = new ViajeDTO(List.of(1, 2), origen, destino);

        ResultActions results = this.mockMvc.perform(
                post("/personas/{id}/viajes", 3)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(viajeDTO))
        );

        results
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.personaId").value(3));

        ViajeResponseDTO respuestaEsperada = ViajeResponseDTO.builder()
                .id(1)
                .personaId(3)
                .cuidadores(List.of(1,2))
                .origen(origen)
                .destino(destino)
                .estado("NO_INICIADO")
                .duracionEstimadaEnMins(2L)
                .build();
        System.out.println(respuestaEsperada);

        MvcResult result = results.andReturn();
        String respuesta = result.getResponse().getContentAsString(); // esto nos sirve para comparar contra el objeto string esperado

        String respuestaEsperadaString = writer.writeValueAsString(respuestaEsperada);

        Assertions.assertEquals(respuestaEsperadaString, respuesta);
    }

}
