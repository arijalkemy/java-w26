package com.mercadolibre.pf_be_hisp_w26_t07_torres.integration.Controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.product.LocationForProductDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.warehouse.StockQuantityResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.service.JwtService;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.util.DataUtils;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.util.TestDataGenerator;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.util.enums.MessageError;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.util.enums.RoleEnumUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = {"SCOPE_SUFFIX = integration_test"})
public class ProductControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JwtService jwtService;

    private ObjectMapper mapper;
    private ObjectWriter writer;

    @BeforeEach
    void setUp() {
        mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        writer = mapper
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .writer();
    }


    @Test
    void getAllProductsHappyPath() throws Exception {
        String token = jwtService.generateToken(RoleEnumUtil.BUYER, 1L).getToken();
        String expected = DataUtils.getJsonProductsFrozen();
        mockMvc.perform(get("/api/v1/fresh-products/list?category=FF")
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(result -> assertEquals(
                        expected, result.getResponse().getContentAsString(StandardCharsets.UTF_8)
                ));
    }

    @Test
    @DisplayName("Integration Test - Get Stock Quantity For Each Warehouse White ID=1 ")
    void getStockQuantityForEachWarehouse() throws Exception {
        Long id = 1L;
        StockQuantityResponseDto expected_stockQuantityResponseDto = TestDataGenerator.getStockQuantityResponseDto();

        String token = jwtService.generateToken(RoleEnumUtil.BUYER, id).getToken();
        String expected = writer.writeValueAsString(expected_stockQuantityResponseDto);
        mockMvc.perform(get("/api/v1/fresh-products/{idProduct}/warehouse/list", id)
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(result -> assertEquals(
                        expected, result.getResponse().getContentAsString(StandardCharsets.UTF_8)
                ));
    }


    @Test
    @DisplayName("Integration test: obtain stock quantity for an ID 100 not stored in the systems, exception scenario")
    void getStockQuantityForEachWarehouseException() throws Exception {
        Long id = 100L;
        String token = jwtService.generateToken(RoleEnumUtil.BUYER, 1L).getToken();
        String expected = MessageError.PRODUCTS_NOT_FOUND.getMessage();

        mockMvc.perform(get("/api/v1/fresh-products/{idProduct}/warehouse/list", id)
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message", is(expected)));
    }

    @Test
    void getLocationProductoInWarehouse() throws Exception {
        Long idProduct = 1L;
        String token = jwtService.generateToken(RoleEnumUtil.REPRESENTATIVE, 1L).getToken();
        LocationForProductDTO expectedLocation = DataUtils.getJsonLocationProductoInWarehouse(idProduct);
        String expected = writer.writeValueAsString(expectedLocation);

        mockMvc.perform(get("/api/v1/fresh-products/{idProduct}/batch/list", idProduct)
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(result -> assertEquals(
                        expected, result.getResponse().getContentAsString(StandardCharsets.UTF_8)
                ));

    }
}
