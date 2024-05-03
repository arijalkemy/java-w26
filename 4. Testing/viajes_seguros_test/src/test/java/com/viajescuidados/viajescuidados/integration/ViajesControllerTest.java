package com.viajescuidados.viajescuidados.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.viajescuidados.dtos.UbicacionDTO;
import com.viajescuidados.dtos.ViajeDTO;
import com.viajescuidados.dtos.responses.ViajeResponseDTO;
import com.viajescuidados.entities.viajes.Viaje;
import com.viajescuidados.mappers.ViajeMapper;
import lombok.val;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

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
    @Autowired
    WebApplicationContext context;

    @BeforeAll
    public static void setup() {
        writer = new ObjectMapper()
                        .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                        .writer();

        objectMapper = new ObjectMapper();
    }
    @BeforeEach
    void setupMvc() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .alwaysDo(MockMvcResultHandlers.print())
                .build();
    }
    /**
     * Tareas:
     * - Diseñar pruebas unitarias para verificar el correcto funcionamiento de cada paso del método crearViaje.
     * - Verificar que la persona y los cuidadores se asignan correctamente al nuevo viaje.
     * - Asegurarse de que la duración estimada del viaje se calcula correctamente.
     * - Diseñar pruebas de integración para verificar que el servicio de creación de viajes interactúa
     *   correctamente con los servicios de búsqueda de personas, la calculadora de demora y el
     *   repositorio de viajes.
     * - Verificar que el nuevo viaje se guarda correctamente en la base de datos.
     * - Validar que se devuelve un objeto ViajeResponseDTO con los detalles del viaje creado.
     */
    @Test
    public void crearUnViajeTest() throws Exception {
        UbicacionDTO origin = new UbicacionDTO("", (long) -34.5, (long) -58.5);
        UbicacionDTO destination = new UbicacionDTO("", (long) -34.5, (long) -59);
        ViajeDTO viajeDTO = new ViajeDTO(List.of(1, 2), origin, destination);

        ResultActions results = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/personas/{id}/viajes", 3)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(viajeDTO))
        );

        results
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.personaId").value(3));

        ViajeResponseDTO expectedRes = ViajeResponseDTO.builder()
                .id(1)
                .personaId(3)
                .cuidadores(List.of(1, 2))
                .origen(origin)
                .destino(destination)
                .estado("NO_INICIADO")
                .duracionEstimadaEnMins(2L)
                .build();

        MvcResult result = results.andReturn();
        String responseStr = result.getResponse().getContentAsString();

        String respuestaEsperadaString = writer.writeValueAsString(expectedRes);

        Assertions.assertEquals(respuestaEsperadaString, responseStr);
    }

    @Test
    @DisplayName("Test para el endpoint viajes/{id}/comienzo")
    void comenzarViajeTest() throws Exception {
        ResultActions results = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/personas/{id}/viajes", 3)
        );
    }
}
