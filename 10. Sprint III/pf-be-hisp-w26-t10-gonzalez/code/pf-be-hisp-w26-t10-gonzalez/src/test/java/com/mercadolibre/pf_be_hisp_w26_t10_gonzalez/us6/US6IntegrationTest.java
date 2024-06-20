package com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.us6;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos.ProductUS6Dto;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos.ProductsUS6RequestDto;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.repository.IProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class US6IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    IProductRepository productRepository;

    @BeforeEach
    public void setUp() throws Exception{
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void Test(){
        List<Product> products = productRepository.findAll();
        for(Product pro: products){
            System.out.println(pro.getName());
        }
    }

    @Test
    @DisplayName("Test US 6 - Endpoint Call Update Product, Happy Path")
    public void testUpdateProductHappyPath() throws Exception {
        ProductUS6Dto productDto = new ProductUS6Dto("Updated Product", 15.0);

        String token = getToken("jgonz", "12345");
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/fresh-products/{isSeller}/{idProduct}", 2, 1)
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Producto con el id: 1 asociado al vendedor 2"));
    }

    @Test
    @DisplayName("Test US 6 - Endpoint Call CreateProduct, Happy Path")
    public void testCreateProductHappyPath() throws Exception {
        ProductUS6Dto productDto = new ProductUS6Dto("Test Product", 10.0);
        ProductsUS6RequestDto requestDto = new ProductsUS6RequestDto(Collections.singletonList(productDto));

        String token = getToken("jgonz", "12345");
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/fresh-products/2")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Productos insertados y asociados al vendedor con id 2"));
    }

    @Test
    @DisplayName("Test US 6 - Endpoint Call Find Products By Price Range, Happy Path")
    public void testFindByPriceRangesHappyPath() throws Exception {
        String token = getToken("jgonz", "12345");
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fresh-products/prices?low=10.0&high=20.0")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    @DisplayName("Test US 6 - Endpoint Call Find Products By Keyword, Happy Path")
    public void testFindByKeywordHappyPath() throws Exception {
        String token = getToken("jgonz", "12345");
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fresh-products/keyword/apple")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }


    @Test
    public void testCreateProductSellerNotFound() throws Exception {
        ProductUS6Dto productDto = new ProductUS6Dto("Test Product", 10.0);
        ProductsUS6RequestDto requestDto = new ProductsUS6RequestDto();
        requestDto.setProducts(List.of(productDto));

        String token = getToken("mluis", "12345");
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/v1/fresh-products/1000")
                                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(requestDto)))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("The seller with ID: 1000 does not exists"));
    }

    @Test
    public void testUpdateProductProductNotFound() throws Exception {
        ProductUS6Dto productDto = new ProductUS6Dto("Updated Product", 15.0);

        String token = getToken("jgonz", "12345");
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/fresh-products/{idSeller}/{idProduct}", 999, 1)
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productDto)))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("The seller with ID: 999 does not exists"));
    }

    @Test
    public void testFindByPriceRangesInvalidRange() throws Exception {
        String token = getToken("jgonz", "12345");
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fresh-products/prices?low=-10.0&high=20.0")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("The prices ranges cannot be under zero"));
    }

    private String getToken(String username, String password) throws Exception {

        String jsonBody = "{ \"username\": \"" + username + "\", \"password\": \"" + password + "\" }";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String response = result.getResponse().getContentAsString();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(response);

        return jsonNode.get("token").asText();
    }

}
