package com.viajescuidados.viajescuidados.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.viajescuidados.dtos.PersonaDTO;
import com.viajescuidados.dtos.responses.PersonaResponseDTO;
import com.viajescuidados.entities.Persona;
import com.viajescuidados.repositories.IPersonasRepository;
import com.viajescuidados.repositories.PersonasRepositoryTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonasControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private IPersonasRepository personasRepository;

    private static ObjectWriter objectWriter;

    private static ObjectMapper objectMapper;

    @BeforeAll
    public static void setup() {
        objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        objectMapper = new ObjectMapper();
    }

    @BeforeEach
    public void setupDB() {
        personasRepository.limpiarDatos();
        personasRepository.guardar(
                new Persona(1, "Mara", "Lopez")
        );
    }

    @Test
    public void agregarPersonaTest() throws Exception {
        PersonaDTO personaDTO = new PersonaDTO("Carlos", "Perez");
        PersonaResponseDTO expectedResponse = new PersonaResponseDTO(2, "Carlos", "Perez");

        String payloadJson = objectWriter.writeValueAsString(personaDTO);
        String expectedResponseJson = objectWriter.writeValueAsString(expectedResponse);

        MvcResult mvcResult = mockMvc
                .perform(
                    MockMvcRequestBuilders.post("/personas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson)
                )
                .andDo(print()).andExpect(status().isOk())
                .andReturn();

        assertEquals(expectedResponseJson, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void agregarPersonaConPayloadInvalidoTest() throws Exception {
        PersonaDTO personaDTO = new PersonaDTO("Carlos", "Perez");

        String payloadJson = "{\"nombre\":\"Carlos\", \"apellido\"}";

        mockMvc.perform(
                MockMvcRequestBuilders.post("/personas")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(payloadJson)
                )
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("HttpMessageNotReadableException"));
    }

    @Test
    public void buscarPersonaTest() throws Exception {
        PersonaResponseDTO personaResponseDTO = new PersonaResponseDTO(1, "Mara", "Lopez");
        String expectedResponseJson = objectWriter.writeValueAsString(personaResponseDTO);

        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get("/personas/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(result.getResponse().getContentAsString(), expectedResponseJson);
    }

    @Test
    public void buscarPersonaInexistenteTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/personas/3"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Not found"))
                .andExpect(jsonPath("$.description").value("No se ha encontrado una persona con el id 3 brindado"));
    }
}
