package com.mercadolibre.sprint3_individual_perez.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.sprint3_individual_perez.dto.request.ProductDTO;
import com.mercadolibre.sprint3_individual_perez.dto.response.ResponseProductDTO;
import com.mercadolibre.sprint3_individual_perez.exceptions.ApiException;
import com.mercadolibre.sprint3_individual_perez.projections.ProductProjection;
import com.mercadolibre.sprint3_individual_perez.service.ProductService;
import com.mercadolibre.sprint3_individual_perez.utils.UtilAutenticationTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {
    // Autowiring MockMvc
    @Autowired
    private MockMvc mockMvc;
    // Mocking ProductService
    @MockBean
    private ProductService service;

    // Creating objects to test
    ObjectWriter writer;
    ResponseProductDTO responseProductDTO;
    List<ProductProjection> productsProjection;
    UtilAutenticationTest utilAutenticationTest;
    String token;

    // Setting up the objects
    @BeforeEach
    void setUp() throws Exception {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        List<ProductDTO> productsDTO= new ArrayList<>();
        productsDTO.add(new ProductDTO(1000,2));
        productsDTO.add(new ProductDTO(1001,3));
        responseProductDTO = new ResponseProductDTO(productsDTO);
        productsProjection = new ArrayList<>();
        ProductProjection product1 = new ProductProjection() {
            @Override
            public Long getIdProduct() {return 1000L;}
            @Override
            public Integer getQuantity() {return 2;}
        };
        ProductProjection product2 = new ProductProjection() {
            @Override
            public Long getIdProduct() {return 1001L;}
            @Override
            public Integer getQuantity() {return 3;}
        };
        productsProjection.add(product1);
        productsProjection.add(product2);

        utilAutenticationTest = new UtilAutenticationTest();
        token = utilAutenticationTest.getTokenUser(mockMvc);
    }

    /**
     * Test to get all products happy path with null category
     * @throws Exception
     */
    @Test
    void testGetProductsNullCategory() throws Exception {
        //Arrange
        String category = null;
        when(service.selectMethod(category)).thenReturn(responseProductDTO);
        String expectedJSON = writer.writeValueAsString(responseProductDTO);
        //Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fresh-products/list")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .param("category", category))
                .andExpect(status().isOk())
                .andReturn();
        //Assert
        Assertions.assertEquals(200, result.getResponse().getStatus());
        Assertions.assertEquals(expectedJSON, result.getResponse().getContentAsString());
    }
    /**
     * Test to get all products error path with null category
     * this error is when the list of products is empty
     * @throws Exception
     */
    @Test
    void errorTestGetProductsNullCategory() throws Exception {
        // Arrange
        String category = null;
        when(service.selectMethod(category))
                .thenThrow(new ApiException("Not Found", "No products found", HttpStatus.NOT_FOUND.value()));

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fresh-products/list")
                        .param("category", category)
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token))
                .andExpect(status().isNotFound())
                .andExpect(result -> Assertions.assertTrue(result.getResolvedException() instanceof ApiException))
                .andExpect(result -> Assertions.assertEquals("No products found",
                        result.getResolvedException().getMessage()));
    }

    /**
     * Test to get all products happy path with category
     * @throws Exception
     */
    @Test
    void testGetProductsCategory() throws Exception {
        //Arrange
        String category = "FS";
        when(service.selectMethod(category)).thenReturn(responseProductDTO);
        String expectedJSON = writer.writeValueAsString(responseProductDTO);
        //Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fresh-products/list")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .param("category", category))
                .andExpect(status().isOk())
                .andReturn();
        //Assert
        Assertions.assertEquals(200, result.getResponse().getStatus());
        Assertions.assertEquals(expectedJSON, result.getResponse().getContentAsString());
    }
    /**
     * Test to get  products first error path with category
     * this error is when the category is invalid
     * @throws Exception
     */
    @Test
    void firstErrorTestGetProductsCategory() throws Exception {
        // Arrange
        String category = "F";
        when(service.selectMethod(category))
                .thenThrow(new ApiException("Not Found", "No products found", HttpStatus.NOT_FOUND.value()));

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fresh-products/list")
                        .param("category", category)
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token))
                .andExpect(status().isNotFound())
                .andExpect(result -> Assertions.assertTrue(result.getResolvedException() instanceof ApiException))
                .andExpect(result -> Assertions.assertEquals("No products found",
                        result.getResolvedException().getMessage()));
    }
    /**
     * Test to get  products second error path with category
     * this error is when the list of products is empty
     * @throws Exception
     */
    @Test
    void secondErrorTestGetProductsCategory() throws Exception {
        // Arrange
        String category = "FF";
        when(service.selectMethod(category))
                .thenThrow(new ApiException("Not Found", "No products found", HttpStatus.NOT_FOUND.value()));

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fresh-products/list")
                        .param("category", category)
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token))
                .andExpect(status().isNotFound())
                .andExpect(result -> Assertions.assertTrue(result.getResolvedException() instanceof ApiException))
                .andExpect(result -> Assertions.assertEquals("No products found",
                        result.getResolvedException().getMessage()));
    }
}
