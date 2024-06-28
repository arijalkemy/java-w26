package com.mercadolibre.project_be_java_hisp_w26_t7.integration.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.product.ProductResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.util.DataUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = {"SCOPE_SUFFIX = integration_test"})
public class OrderControllerIT {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper mapper;
    private ObjectWriter writer;

    @BeforeEach
    void setUp() {
        mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    @DisplayName("Integration Test - Get Products By Order 1")
    public void getProductsByOrder1IntegrationTest() throws Exception {
        List<ProductResponseDTO> products = DataUtils.getProductsResponseDTOIT();
        String expected = writer.writeValueAsString(products);
        mockMvc.perform(get("/api/v1/fresh-products/orders/{idOrder}", 1)
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiQlVZRVIiLC" +
                                "JzdWIiOiIxIiwiaWF0IjoxNzE4NzM5NzkyLCJleHAiOjE3MjEzMzE3OTJ9.8gZnYtbaASsm7eZxn8ZiZv" +
                                "k1MFdDITVH6qhlXo__VQ0")
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(result -> assertEquals(
                        expected, result.getResponse().getContentAsString(StandardCharsets.UTF_8)
                ));
    }

}
