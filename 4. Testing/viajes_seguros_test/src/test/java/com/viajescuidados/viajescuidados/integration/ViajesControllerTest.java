package com.viajescuidados.viajescuidados.integration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;
import com.viajescuidados.dtos.UbicacionDTO;
import com.viajescuidados.dtos.ViajeDTO;
import com.viajescuidados.dtos.responses.ErrorDTO;
import com.viajescuidados.dtos.responses.ViajeResponseDTO;
import org.hamcrest.Matchers;
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
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
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
                .registerModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .writer();

        objectMapper = new ObjectMapper();
    }

    @BeforeEach
    void setupMvc() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .addFilter(new CharacterEncodingFilter("UTF-8", true))
                .alwaysDo(MockMvcResultHandlers.print())
                .build();
    }

    /**
     * Tareas:
     * - Diseñar pruebas unitarias para verificar el correcto funcionamiento de cada paso del método crearViaje.
     * - Verificar que la persona y los cuidadores se asignan correctamente al nuevo viaje.
     * - Asegurarse de que la duración estimada del viaje se calcula correctamente.
     * - Diseñar pruebas de integración para verificar que el servicio de creación de viajes interactúa
     * correctamente con los servicios de búsqueda de personas, la calculadora de demora y el
     * repositorio de viajes.
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
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.personaId").value(3));

        ViajeResponseDTO expectedRes = ViajeResponseDTO.builder()
                .id(2)
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

    /**
     * Test for comienzoViajes
     *
     * @throws Exception
     */
    @Test
    @DisplayName("Test para el endpoint viajes/{id}/comienzo")
    void comenzarViajeTest() throws Exception {
        // Given - Arrange
        LocalDateTime currDateTime = LocalDateTime.now();
        UbicacionDTO origenDto = new UbicacionDTO("Dir1", 22L, 23L);
        UbicacionDTO destinoDto = new UbicacionDTO("Dir2", 33L, 88L);
        String dateStr = currDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));

        // When - Act
        ResultActions results = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/viajes/{id}/comienzo", 1)
                        .accept(MediaType.APPLICATION_JSON)
        );

        // Then - Assert
        results.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.personaId").value("1"))
                .andExpect(jsonPath("$.cuidadores").value(Matchers.contains(2, 3)))
                .andExpect(jsonPath("$.estado").value("EN_PROCESO"))
                .andExpect(jsonPath("$.duracionEstimadaEnMins").value(234))
                .andExpect(jsonPath("$.fechaComienzo", startsWith(dateStr)))
                .andExpect(jsonPath("$.fechaFinalizacion", Matchers.nullValue()));

        MvcResult result = results.andReturn();
        String jsonResponseStr = result.getResponse().getContentAsString();
        Object document = Configuration.defaultConfiguration().jsonProvider().parse(jsonResponseStr);

        LinkedHashMap<String, String> origenResStr = JsonPath.read(document, "$.origen");
        UbicacionDTO origenResDto = objectMapper.convertValue(origenResStr, UbicacionDTO.class);
        LinkedHashMap<String, String> destinoResStr = JsonPath.read(document, "$.destino");
        UbicacionDTO destinoResDto = objectMapper.convertValue(destinoResStr, UbicacionDTO.class);

        org.assertj.core.api.Assertions.assertThat(origenResDto).usingRecursiveComparison().isEqualTo(origenDto);
        org.assertj.core.api.Assertions.assertThat(destinoResDto).usingRecursiveComparison().isEqualTo(destinoDto);
    }

    @Test
    @DisplayName("No se encuentra el usuario con el id")
    void comenzarViajeBadTest() throws Exception {
        ErrorDTO expectedResponse = new ErrorDTO("Not found", "No existe un viaje que coincida con el id brindado");
        String expectedResStr = writer.writeValueAsString(expectedResponse);

        ResultActions results = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/viajes/{id}/comienzo", 3)
        );

        results.andExpect(status().isNotFound());
        MvcResult result = results.andReturn();
        String resStr = result.getResponse().getContentAsString();

        Assertions.assertEquals(expectedResStr, resStr);
    }
}
