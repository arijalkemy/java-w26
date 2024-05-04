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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDateTime;
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
        UbicacionDTO origen = new UbicacionDTO("", (long) -34.5, (long) -58.5);
        UbicacionDTO destino = new UbicacionDTO("", (long) -34.5, (long) -60);
        ViajeDTO viajeDTO = new ViajeDTO(List.of(1, 2), origen, destino);

        MvcResult response = this.mockMvc
            .perform(
                MockMvcRequestBuilders
                    .post("/personas/{id}/viajes", 3)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(writer.writeValueAsString(viajeDTO))
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.personaId").value(3))
            .andReturn();

        ViajeResponseDTO respuestaEsperada = ViajeResponseDTO.builder()
            .id(1)
            .personaId(3)
            .cuidadores(List.of(1, 2))
            .origen(origen)
            .destino(destino)
            .estado("NO_INICIADO")
            .duracionEstimadaEnMins(2L)
            .fechaComienzo(null)
            .fechaFinalizacion(null)
            .build();

        String viajeRespuesta = response.getResponse().getContentAsString();

        String respuestaEsperadaString = writer.writeValueAsString(respuestaEsperada);

        Assertions.assertEquals(respuestaEsperadaString, viajeRespuesta);
    }

}
