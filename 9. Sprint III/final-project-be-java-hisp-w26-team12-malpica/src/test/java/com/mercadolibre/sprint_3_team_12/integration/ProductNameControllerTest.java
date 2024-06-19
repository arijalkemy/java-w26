package com.mercadolibre.sprint_3_team_12.integration;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.sprint_3_team_12.dto.request.ProductDTO;
import com.mercadolibre.sprint_3_team_12.dto.request.ProductNameDTO;
import com.mercadolibre.sprint_3_team_12.dto.response.ResponseProductDTO;
import com.mercadolibre.sprint_3_team_12.projections.ProductProjection;
import com.mercadolibre.sprint_3_team_12.service.ProductService;
import com.mercadolibre.sprint_3_team_12.utils.UtilAutenticationTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductNameControllerTest {

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
    String tokenAdmin;

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


        utilAutenticationTest = new UtilAutenticationTest();
        tokenAdmin = utilAutenticationTest.getTokenAdmin(mockMvc);
    }

    /**
     * Test to post a product with name happy path
     */
    @Test
    @DisplayName("Test to post a product with name happy path")
    void testGetProductsByName() throws Exception {
        //Arrange - We create a ProductNameDTO object
        ProductNameDTO productNameDTO = new ProductNameDTO("Manzanas Golden", 40.0);

        String name = "name";
        String expectedJSON = writer.writeValueAsString(productNameDTO);
        //Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/fresh-products/addProduct")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + tokenAdmin)
                .contentType("application/json")
                .content(writer.writeValueAsString(productNameDTO)))
                        .andExpect(status().isCreated()).andReturn();
        //Assert
        Assertions.assertEquals(201, result.getResponse().getStatus());

    }

    /**
     * Test to modify a product with name happy path
     */
    @Test
    @DisplayName("Test to modify a product with name happy path")
    void testModifyProductsByName() throws Exception {
        //Arrange - We create a ProductNameDTO object
        ProductNameDTO productNameOriginal = new ProductNameDTO("Manzanas Golden", 50.0);
        ProductNameDTO productNameModified = new ProductNameDTO("Manzanas Golden", 60.0);

        String name = "name";
        String expectedJSONO = writer.writeValueAsString(productNameOriginal);
        //Act
        String expectedJSONM = writer.writeValueAsString(productNameModified);
        //Act
        MvcResult resulto = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/fresh-products/addProduct")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + tokenAdmin)
                        .contentType("application/json")
                        .content(writer.writeValueAsString(productNameOriginal)))
                .andExpect(status().isCreated()).andReturn();
        //Assert
        Assertions.assertEquals(201, resulto.getResponse().getStatus());

        MvcResult resultm = mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/fresh-products/modifyProduct")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + tokenAdmin)
                .contentType("application/json")
                .content(writer.writeValueAsString(productNameModified)))
                        .andExpect(status().isCreated()).andReturn();
        //Assert
        Assertions.assertEquals(201, resultm.getResponse().getStatus());

    }


}
