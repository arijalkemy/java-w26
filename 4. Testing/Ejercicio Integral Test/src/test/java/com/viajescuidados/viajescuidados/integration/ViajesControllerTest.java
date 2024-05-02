package com.viajescuidados.viajescuidados.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.viajescuidados.dtos.UbicacionDTO;
import com.viajescuidados.dtos.ViajeDTO;
import com.viajescuidados.dtos.responses.ViajeResponseDTO;
import com.viajescuidados.entities.Persona;
import com.viajescuidados.entities.viajes.Viaje;
import com.viajescuidados.mappers.ViajeMapper;
import com.viajescuidados.repositories.PersonasRepository;
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
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
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
        UbicacionDTO origen = new UbicacionDTO("", (long) -34.5, (long) -58.5);
        UbicacionDTO destino = new UbicacionDTO("", (long) -34.5, (long) -59);
        ViajeDTO viajeDTO = new ViajeDTO(List.of(2), origen, destino);

        ResultActions results = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/personas/{id}/viajes", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(viajeDTO))
        );

        results
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.personaId").value(1));

        Persona persona = new Persona(1, "Mara", "Lopez");
        Persona cuidador =new Persona(2, "Juan", "Lopez");

        Viaje nuevoViaje = ViajeMapper.crearViaje(viajeDTO);
        nuevoViaje.setPersona(persona);
        nuevoViaje.setCuidadores( List.of( cuidador) );
        nuevoViaje.setDuracionEstimadaEnMins(2L);
        nuevoViaje.setId(1);
        ViajeResponseDTO respuestaEsperada = ViajeMapper.crearViajeResponseDTO(nuevoViaje);

        var result = results.andReturn();
        String respuesta = result.getResponse().getContentAsString(); // esto nos sirve para comparar contra el objeto string esperado

        String respuestaEsperadaString = writer.writeValueAsString(respuestaEsperada);

        Assertions.assertEquals(respuestaEsperadaString, respuesta);
    }

}
