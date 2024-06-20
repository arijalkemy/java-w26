package com.mercadolibre.fresh_market.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.fresh_market.config.security.JwtService;
import com.mercadolibre.fresh_market.dtos.ProductStockDTO;
import com.mercadolibre.fresh_market.dtos.WarehouseProduct;
import com.mercadolibre.fresh_market.dtos.product.ProductDetailDTO;
import com.mercadolibre.fresh_market.dtos.product.ProductReqDTO;
import com.mercadolibre.fresh_market.dtos.product.ProductResDTO;
import com.mercadolibre.fresh_market.model.*;
import com.mercadolibre.fresh_market.service.IProductService;
import com.mercadolibre.fresh_market.util.JsonUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JwtService jwtTokenService;

    @MockBean
    private IProductService productService;

    private ProductReqDTO productReqDTO;
    private User testSeller;
    private String token;

    @BeforeEach
    void setUp() throws IOException {
        productReqDTO = JsonUtil.readJsonFromFile("productReq.json", ProductReqDTO.class);
        testSeller = JsonUtil.readJsonFromFile("user_seller.json", User.class);

        HashMap<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("role", "SELLER");
        token = "Bearer" + jwtTokenService.generateToken(extraClaims, testSeller);

    }

    @Test
    @DisplayName("Given a product id, when getStockByProductAndWarehouse is called, then it should return the stock information for the product. - Failed to token validation")
    void modifyOrderExistenceFailed() throws Exception {
        Long idProduct = 1L;

        // Act
        ResultActions result = mockMvc.perform(get("/api/v1/fresh-products/{idProduct}/warehouse/list", idProduct)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        // Assert
        result.andExpect(status().isForbidden());
    }


    @Test
    @DisplayName("Given a product id, when getStockByProductAndWarehouse is called, then it should return the stock information for the product.")
    @WithMockUser(roles = "BUYER")
    void modifyOrderExistence() throws Exception {

        // Arrange
        Long idProduct = 1L;
        WarehouseProduct warehouseProduct = new WarehouseProduct(1L, 200);
        ProductStockDTO productStockDTO = new ProductStockDTO(1L, List.of(warehouseProduct));
        when(productService.getProductStock(idProduct)).thenReturn(productStockDTO);

        // Act
        mockMvc.perform(get("/api/v1/fresh-products/{idProduct}/warehouse/list", idProduct)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", token)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.product_id").value(1L))
                .andExpect(jsonPath("$.warehouse_products[0].warehouse_id").value(1L))
                .andExpect(jsonPath("$.warehouse_products[0].quantity").value(200));

    }

    @Test
    @DisplayName("Given a category, when getProducts is called, then it should return the product list of this category")
    @WithMockUser(roles = "SELLER")
    void getProductsByCategory() throws Exception {
        // Arrange
        ProductDetailDTO product1 = new ProductDetailDTO();
        product1.setId(1L);
        ProductDetailDTO product2 = new ProductDetailDTO();
        product2.setId(2L);
        List<ProductDetailDTO> products = List.of(product1, product2);
        when(productService.getAllProductsByCategory(any())).thenReturn(products);

        // Act
        mockMvc.perform(get("/api/v1/fresh-products/list")
                        .param("category", "FF")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", token)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[1].id").value(2));

    }

    @Test
    @DisplayName("When getProducts is called, then it should return the product list")
    @WithMockUser(roles = "SELLER")
    void getAllProducts() throws Exception {
        // Arrange
        ProductDetailDTO product1 = new ProductDetailDTO();
        product1.setId(1L);
        List<ProductDetailDTO> products = List.of(product1);
        when(productService.getAllProducts()).thenReturn(products);

        // Act and Assert
        mockMvc.perform(get("/api/v1/fresh-products/list")
                        .param("category", (String) null)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization",  token)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1));
    }

    @Test
    @DisplayName("When save Product Seller is called, then it should return ProductResDTO")
    @WithMockUser(roles = "SELLER")
    void saveProductSeller() throws Exception {
        // Arrange
        ObjectMapper objectMapper = new ObjectMapper();
        ProductResDTO productResDTO = new ProductResDTO(productReqDTO.getProducts().size(),
                "Products created successfully.", 201);
        when(productService.createProducts(any(ProductReqDTO.class), anyLong())).thenReturn(productResDTO);

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/fresh-products/{idSeller}", testSeller.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productReqDTO))
                        .header(HttpHeaders.AUTHORIZATION, token))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.operation").value(2))
                .andExpect(jsonPath("$.message").value("Products created successfully."))
                .andExpect(jsonPath("$.code").value(201));
    }

    @Test
    @DisplayName("When updateProductSeller is called, then it should return updated ProductResDTO")
    @WithMockUser(roles = "SELLER")
    void updateProductSeller() throws Exception {
        // Arrange
        ObjectMapper objectMapper = new ObjectMapper();
        ProductResDTO productResDTO = new ProductResDTO(productReqDTO.getProducts().size(),
                "Product update successfully.", 201);
        when(productService.updateProduct(any(ProductDetailDTO.class), anyLong(), anyLong())).thenReturn(productResDTO);

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/fresh-products/{idSeller}/{idProduct}",
                                testSeller.getId(), 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productReqDTO))
                        .header(HttpHeaders.AUTHORIZATION, token))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.operation").value(2))
                .andExpect(jsonPath("$.message").value("Product update successfully."))
                .andExpect(jsonPath("$.code").value(201));
    }

}
