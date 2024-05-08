package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerIntegrationTest {

    private MockMvc mockMvc;

    private static ObjectWriter objectWriter;
    private static ObjectMapper objectMapper;

    @BeforeAll
    public static void setup() {
        objectWriter = new ObjectMapper().configure()
    }
}
