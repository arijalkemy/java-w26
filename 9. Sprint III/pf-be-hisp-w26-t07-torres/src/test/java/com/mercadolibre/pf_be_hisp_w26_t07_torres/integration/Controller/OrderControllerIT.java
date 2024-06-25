package com.mercadolibre.pf_be_hisp_w26_t07_torres.integration.Controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.order.OrderStatusRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.others.TotalPriceResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.product.ProductPurchaseOrderRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.product.ProductResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.product.PurchaseOrderDetailsRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.product.PurchaseOrderRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.service.JwtService;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.util.DataUtils;
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
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = {"SCOPE_SUFFIX = integration_test"})
public class OrderControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JwtService jwtService;

    private ObjectMapper mapper;
    private ObjectWriter writer;

    @BeforeEach
    public void setup() {
        mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        writer = mapper
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .writer();
    }

    @Test
    @DisplayName("Integration Test - Get Products By Order 1")
    public void getProductsByOrder1IntegrationTest() throws Exception {
        String token = jwtService.generateToken(RoleEnumUtil.BUYER, 1L).getToken();
        List<ProductResponseDTO> products = DataUtils.getProductsResponseDTOIT();
        String expected = writer.writeValueAsString(products);
        mockMvc.perform(get("/api/v1/fresh-products/orders/{idOrder}", 1)
                        .header("Authorization", "Bearer " + token)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(result -> assertEquals(
                        expected, result.getResponse().getContentAsString(StandardCharsets.UTF_8)
                ));
    }

    @Test
    @DisplayName("Integration: create products list")
    public void createProductListTest() throws Exception {
        Long buyerId = 2L;
        String token = jwtService.generateToken(RoleEnumUtil.BUYER, buyerId).getToken();

        OrderStatusRequestDTO statusDto = OrderStatusRequestDTO
                .builder()
                .statusCode("carrito")
                .build();
        List<ProductPurchaseOrderRequestDto> productListDto = new ArrayList<>();
        productListDto.add(new ProductPurchaseOrderRequestDto(2, 5));
        PurchaseOrderDetailsRequestDTO productsDto = DataUtils
                .getOrderDetailsWithIdAndQuantity(buyerId.intValue(), statusDto, productListDto);
        PurchaseOrderRequestDTO requestDTO = PurchaseOrderRequestDTO
                .builder()
                .purchaseOrder(productsDto)
                .build();
        String requestBody = writer.writeValueAsString(requestDTO);

        TotalPriceResponseDTO expectedDto = DataUtils.getTotalPriceResponseDtoWithPrice(79.95);
        String expected = writer.writeValueAsString(expectedDto);

        mockMvc.perform(post("/api/v1/fresh-products/orders")
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(result -> assertEquals(
                        expected, result.getResponse().getContentAsString(StandardCharsets.UTF_8)
                ));
    }

    @Test
    @DisplayName("Integration: update products list")
    public void updateProductListTest() throws Exception {
        Long buyerId = 1L;
        String token = jwtService.generateToken(RoleEnumUtil.BUYER, buyerId).getToken();

        OrderStatusRequestDTO statusDto = OrderStatusRequestDTO
                .builder()
                .statusCode("carrito")
                .build();
        List<ProductPurchaseOrderRequestDto> productListDto = new ArrayList<>();
        productListDto.add(new ProductPurchaseOrderRequestDto(2, 5));
        PurchaseOrderDetailsRequestDTO productsDto = DataUtils
                .getOrderDetailsWithIdAndQuantity(buyerId.intValue(), statusDto, productListDto);
        PurchaseOrderRequestDTO requestDTO = PurchaseOrderRequestDTO
                .builder()
                .purchaseOrder(productsDto)
                .build();
        String requestBody = writer.writeValueAsString(requestDTO);

        TotalPriceResponseDTO expectedDto = DataUtils.getTotalPriceResponseDtoWithPrice(79.95);
        String expected = writer.writeValueAsString(expectedDto);

        mockMvc.perform(put("/api/v1/fresh-products/orders/{idOrder}", 1)
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(result -> assertEquals(
                        expected, result.getResponse().getContentAsString(StandardCharsets.UTF_8)
                ));
    }
}
