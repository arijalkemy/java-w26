package com.viajescuidados.viajescuidados.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import com.viajescuidados.controllers.ViajesController;
import com.viajescuidados.dtos.UbicacionDTO;
import com.viajescuidados.dtos.ViajeDTO;
import com.viajescuidados.dtos.responses.ErrorDTO;
import com.viajescuidados.dtos.responses.ViajeResponseDTO;
import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.context.WebApplicationContext;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.xml.transform.Source;
import javax.xml.validation.Validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class ViajesControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ViajesController viajesController;

    @Autowired
    private WebApplicationContext context;

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
        UbicacionDTO destino = new UbicacionDTO("", (long) -34.5, (long) -59);
        ViajeDTO viajeDTO = new ViajeDTO(List.of(1, 2), origen, destino);

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

        ViajeResponseDTO respuestaEsperada = ViajeResponseDTO.builder()
                .cuidadores(List.of(1, 2))
                .origen(origen)
                .destino(destino)
                .id(1)
                .personaId(3)
                .estado("NO_INICIADO")
                .duracionEstimadaEnMins(2L)
                .build(); // inicializar pero no me da el tiempo

        var result = results.andReturn();
        String respuesta = result.getResponse().getContentAsString(); // esto nos sirve para comparar contra el objeto string esperado

        String respuestaEsperadaString = writer.writeValueAsString(respuestaEsperada);

        Assertions.assertEquals(respuestaEsperadaString, respuesta);
    }


    @Test
    @DisplayName("Comenzar un viaje")
    public void comenzarViajeTest() throws Exception {
        // Arrange
        UbicacionDTO origen = new UbicacionDTO("", (long) -34.5, (long) -58.5);
        UbicacionDTO destino = new UbicacionDTO("", (long) -34.5, (long) -59);
        ViajeDTO viajeExpectedDTO = new ViajeDTO(List.of(1, 2), origen, destino);

        // Crear el viaje
        MvcResult result1 = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/personas/{id}/viajes", 3)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(viajeExpectedDTO)))
                        .andReturn();

        // Obtener el viaje creado despues de ejecutar comenzarViaje
        MvcResult result = this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/viajes/{id}/comienzo", 1)
                                .contentType(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk())
                                .andExpect(content().contentType("application/json"))
                                .andExpect(jsonPath("$.id").value(1))
                                .andExpect(jsonPath("$.personaId").value(3))
                                .andExpect(jsonPath("$.estado").value("EN_PROCESO"))
                                .andReturn();

        // Act
        // Assert
    }

    @Test
    @DisplayName("Comenzar un viaje que no existe")
    public void comenzarViajeNoExisteTest() throws Exception {
        // Arrange

        // Act
        // Comenzamos un viaje cuando un id no existe
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/viajes/{id}/comienzo", 10)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("Not found"))
                .andExpect(jsonPath("$.description").value("No existe un viaje que coincida con el id brindado"));
        // Assert
    }


}
