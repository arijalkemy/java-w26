package org.ejercicio.joyerialasperlas.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.ejercicio.joyerialasperlas.dto.JoyaCreateDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class JoyaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        objectMapper = new ObjectMapper();
    }

    @Test
    @DisplayName("Debería crear una nueva joya y retornar 200 OK")
    public void createJoyaTest() throws Exception {
        JoyaCreateDto joyaCreateDto = new JoyaCreateDto();
        joyaCreateDto.setNombre("Anillo");
        joyaCreateDto.setMaterial("Oro");
        joyaCreateDto.setPeso(300);
        joyaCreateDto.setParticularidad("Ninguna");
        joyaCreateDto.setPoseePiedra(Boolean.FALSE);
        joyaCreateDto.setVentaONo(Boolean.TRUE);

        String json = objectMapper.writeValueAsString(joyaCreateDto);

        mockMvc.perform(post("/jewerly/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value("1"));
    }
}
