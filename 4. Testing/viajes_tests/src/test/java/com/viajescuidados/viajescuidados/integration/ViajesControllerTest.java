package com.viajescuidados.viajescuidados.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.viajescuidados.dtos.ViajeDTO;
import com.viajescuidados.dtos.responses.ViajeResponseDTO;
import com.viajescuidados.repositories.IViajesRepository;
import com.viajescuidados.repositories.ViajesRepository;
import com.viajescuidados.viajescuidados.util.TestingGeneratorUtil;

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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class ViajesControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    IViajesRepository viajesRepository;

    private static ObjectWriter writer;

    @BeforeAll
    public static void setup() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

    }

    @Test
    void postAndCheckViajeTest() throws Exception {
        ViajeDTO viajeDTO = TestingGeneratorUtil.crateViajeDTO();

        ResultActions actions = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/personas/{id}/viajes", 3)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(viajeDTO)));
        actions
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.personaId").value(3));

        ViajeResponseDTO respuestaEsperada = TestingGeneratorUtil.createViajeResponseWithDef();

        MvcResult result = actions.andReturn();
        String respuesta = result.getResponse()
                .getContentAsString();

        String respuestaEsperadaString = writer.writeValueAsString(respuestaEsperada);

        assertEquals(respuestaEsperadaString, respuesta);
        assertTrue(() -> viajesRepository.buscarPorId(1).isPresent());
    }



}
