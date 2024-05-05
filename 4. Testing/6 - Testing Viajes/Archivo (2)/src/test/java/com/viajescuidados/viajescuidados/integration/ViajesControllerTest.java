package com.viajescuidados.viajescuidados.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.viajescuidados.dtos.UbicacionDTO;
import com.viajescuidados.dtos.ViajeDTO;
import com.viajescuidados.dtos.responses.ViajeResponseDTO;
import com.viajescuidados.entities.viajes.EstadoViaje;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDateTime;
import java.util.Arrays;
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
                        .registerModule(new JavaTimeModule())
                        .writer();

        objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    }

    @Test
    public void crearUnViajeTest() throws Exception {
        UbicacionDTO origen = new UbicacionDTO("", (long) -34.5, (long) -58.5);
        UbicacionDTO destino = new UbicacionDTO("", (long) -34.5, (long) -59);
        ViajeDTO viajeDTO = new ViajeDTO(List.of(1, 2), origen, destino);

        // inicializar pero no me da el tiempo
        ViajeResponseDTO respuestaEsperada = ViajeResponseDTO.builder()
                .id(1)
                .personaId(1)
                .cuidadores(Arrays.asList(1,2))
                .origen(origen)
                .destino(destino)
                .estado(String.valueOf(EstadoViaje.NO_INICIADO))
                .duracionEstimadaEnMins(2L)
                .fechaComienzo(LocalDateTime.now())
                .fechaFinalizacion(LocalDateTime.now())
                .build();


        // lo usé por apurado (al var)
        var results = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/personas/{id}/viajes", 3)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(viajeDTO))
        );

        results
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.personaId").value(3));

        var result = results.andReturn();
        String respuesta = result.getResponse().getContentAsString(); // Esto nos sirve para comparar contra el objeto string esperado
        String respuestaEsperadaString = writer.writeValueAsString(respuestaEsperada);
        Assertions.assertEquals(respuestaEsperadaString, respuesta);
    }

    @Test
    @DisplayName("it should return the correct output of the CalculoDemora")
    public void calculoDemoraTest() throws Exception{
        UbicacionDTO origen = new UbicacionDTO("", (long) -34.5, (long) -58.5);
        UbicacionDTO destino = new UbicacionDTO("", (long) -34.5, (long) -59);
        ViajeDTO viajeDTO = new ViajeDTO(List.of(1, 2), origen, destino);

        var results = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/personas/{id}/viajes", 3)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(viajeDTO))
        );

        results
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.duracionEstimadaEnMins").value(2L))
                .andReturn();
    }

    @Test
    @DisplayName("it should return a incorrect output of the CalculoDemora")
    public void calculoDemoraTestSadPath() throws Exception{
        UbicacionDTO origen = new UbicacionDTO("", (long) -34.5, (long) -58.5);
        UbicacionDTO destino = new UbicacionDTO("", (long) -34.5, (long) -59);
        ViajeDTO viajeDTO = new ViajeDTO(List.of(1, 2), origen, destino);

        var results = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/personas/{id}/viajes", 3)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(viajeDTO))
        );

        results
                .andDo(print())
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.duracionEstimadaEnMins",
                        Matchers.not(Matchers.equalTo(34L))));
    }
}
