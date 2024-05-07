package com.viajescuidados.viajescuidados.integration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.viajescuidados.dtos.UbicacionDTO;
import com.viajescuidados.dtos.ViajeDTO;
import com.viajescuidados.dtos.responses.ViajeResponseDTO;
import com.viajescuidados.entities.Persona;
import com.viajescuidados.entities.ubicaciones.Ubicacion;
import com.viajescuidados.entities.viajes.EstadoViaje;
import com.viajescuidados.entities.viajes.Viaje;
import com.viajescuidados.repositories.IViajesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class ViajesControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private IViajesRepository viajesRepository;

    private static ObjectWriter writer;

    private static ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        writer = new ObjectMapper()
                        .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                        .writer();

        objectMapper = new ObjectMapper();

        // Guardamos un viaje sin iniciar
        viajesRepository.guardar(
                Viaje.builder()
                        .id(1)
                        .persona(new Persona(1, "Primer", "Usuario"))
                        .cuidadores(
                                List.of(
                                        new Persona(2, "Un", "Cuidador"),
                                        new Persona(3, "Otro", "Cuidador")
                                    )
                        )
                        .origen(new Ubicacion("N",20L,34L))
                        .destino(new Ubicacion("N",23L,37L))
                        .estado(EstadoViaje.NO_INICIADO)
                        .duracionEstimadaEnMins(2L)
                        .fechaComienzo(null)
                        .fechaFinalizacion(null)
                        .build()
        );
    }

    @Test
    @DisplayName("Se crea un viaje nuevo correctamente")
    public void crearUnViajeTest() throws Exception {
        UbicacionDTO origen = new UbicacionDTO("", -27L, -32L);
        UbicacionDTO destino = new UbicacionDTO("", 30L, -50L);
        ViajeDTO viajeDTO = ViajeDTO.builder()
                .cuidadores(List.of(1,2))
                .origen(origen)
                .destino(destino)
                .build();

        ViajeResponseDTO respuestaEsperada = ViajeResponseDTO.builder()
                .id(2)
                .personaId(3)
                .cuidadores(List.of(1,2))
                .origen(origen)
                .destino(destino)
                .estado(EstadoViaje.NO_INICIADO.toString())
                .duracionEstimadaEnMins(2L)
                .fechaComienzo(null)
                .fechaFinalizacion(null)
                .build();

        // lo usé por apurado (al var)
        ResultActions results = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/personas/{id}/viajes", 3)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(viajeDTO))
        );

        results
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.personaId").value(3));

        String respuestaString = results
                .andReturn()
                .getResponse()
                .getContentAsString(); // esto nos sirve para comparar contra el objeto string esperado

        String respuestaEsperadaString = writer.writeValueAsString(respuestaEsperada);

        Assertions.assertEquals(respuestaEsperadaString, respuestaString);
    }

    @Test
    @DisplayName("Se comieza un viaje creado previamente")
    public void comenzarViajeTest() throws Exception{
        ViajeResponseDTO respuestaEsperada = ViajeResponseDTO.builder()
                .id(1)
                .personaId(1)
                .cuidadores(List.of(2,3))
                .origen(new UbicacionDTO("N",20L,34L))
                .destino(new UbicacionDTO("N",23L,37L))
                .estado(EstadoViaje.EN_PROCESO.toString())
                .duracionEstimadaEnMins(2L)
                .fechaComienzo(null)
                .fechaFinalizacion(null)
                .build();

        ResultActions resultActions = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/viajes/{id}/comienzo", 1)
        );

        resultActions
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));

        String jsonResponse = resultActions.andReturn().getResponse().getContentAsString();

        JsonNode jsonNode = objectMapper.readTree(jsonResponse);

        Assertions.assertEquals(EstadoViaje.EN_PROCESO.toString(), jsonNode.get("estado").asText());
        Assertions.assertNotNull(jsonNode.get("fechaComienzo").asText());

        // NO se puede comparar igualdad porque la fecha LocalDateTime.now() es dinamica
        // Hay que mockear la fecha de alguna forma
        // String respuestaEsperadaString = writer.writeValueAsString(respuestaEsperada);
        // String respuestaString = resultActions.andReturn().getResponse().getContentAsString();
        // Assertions.assertEquals(respuestaString, respuestaEsperadaString);
    }
}
