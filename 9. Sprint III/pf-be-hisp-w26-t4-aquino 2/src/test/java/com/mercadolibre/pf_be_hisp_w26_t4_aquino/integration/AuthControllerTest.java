package com.mercadolibre.pf_be_hisp_w26_t4_aquino.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = {"SCOPE_SUFFIX = integration_test"})
public class AuthControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("testing denied access to login without auth")
    void loginFailTest() throws Exception {
        // Construir el String JSON manualmente
        String payload = "{ \"username\": \"fake\", \"password\": \"fake\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/auth/login")
                        .content(payload)
                        .contentType(MediaType.APPLICATION_JSON) // Establecer el tipo de contenido como JSON
                )
                .andDo(print())
                .andExpect(status().is5xxServerError()); //falta crear manejo excepciones auth
    }

    @Test
    @DisplayName("testing register endpoint")
    void registerTest() throws Exception {

        // Construir el String JSON manualmente
        String payload = "{ \"username\": \"test2\", \"password\": \"test\", \"role\": \"BUYER\" }";

        mockMvc.perform(MockMvcRequestBuilders.post("/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload)
                )
                .andDo(print())
                .andExpect(status().isOk());
    }
}
