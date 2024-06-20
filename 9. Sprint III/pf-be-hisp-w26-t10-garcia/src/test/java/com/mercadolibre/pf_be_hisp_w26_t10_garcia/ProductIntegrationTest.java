package com.mercadolibre.pf_be_hisp_w26_t10_garcia;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.dtos.ProductSellerRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.dtos.ProductSellerResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.dtos.ProductUpdateRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.dtos.ProductsRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.entity.Rol;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.entity.UserAccount;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.repository.*;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.util.EntitiesUtilsTest;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class ProductIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IUserAccountRepository accountRepository;

    @Autowired
    private IUserAccountRepository userAccountRepository;

    @BeforeEach
    public void setUp() {

    }

    private String getToken(String username, String password) throws Exception {

        String jsonBody = "{ \"username\": \"" + username + "\", \"password\": \"" + password + "\" }";

        MvcResult result = mockMvc.perform(post("/auth/login")
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

    @DisplayName("US-03: List Products")
    @Test
    public void listProductsSellerTest() throws Exception {
        String messageError = "Product not found";

        mockMvc.perform(get("/api/v1/fresh-products/seller/list/8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + getToken("gpaco","12345")))
                .andDo(print())
                .andExpect(status().isOk());
                //.andExpect(MockMvcResultMatchers.jsonPath("$.message").value(messageError));

    }

    @DisplayName("US-03: Created products")
    @Test
    public void createProductsSellerTest() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        ProductsRequestDTO productsRequestDTO = new ProductsRequestDTO();

        List<ProductSellerRequestDTO> products = new ArrayList<>();
        products.add(new ProductSellerRequestDTO("Helado con crema",14.0));
        products.add(new ProductSellerRequestDTO("Papas a la francesa",6.0));

        productsRequestDTO.setProducts(products);

        String sendjson = mapper.writeValueAsString(productsRequestDTO);

        mockMvc.perform(post("/api/v1/fresh-products/products/9")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(sendjson)
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + getToken("gpaco","12345")))
                .andDo(print())
                .andExpect(status().isCreated());
        //.andExpect(MockMvcResultMatchers.jsonPath("$.message").value(messageError));

    }

    @DisplayName("US-03: updates products")
    @Test
    public void updatesProductsSellerTest() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        ProductUpdateRequestDTO productsUpdate = new ProductUpdateRequestDTO();

        List<ProductSellerResponseDTO> products = new ArrayList<>();
        products.add(new ProductSellerResponseDTO(1,"Helado con crema",14.0));
        products.add(new ProductSellerResponseDTO(1,"Papas a la francesa",6.0));

        productsUpdate.setProducts(products);

        String sendjson = mapper.writeValueAsString(productsUpdate);

        mockMvc.perform(put("/api/v1/fresh-products/9")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(sendjson)
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + getToken("gpaco","12345")))
                .andDo(print())
                .andExpect(status().isOk());
        //.andExpect(MockMvcResultMatchers.jsonPath("$.message").value(messageError));

    }

    @DisplayName("US-03: updated product")
    @Test
    public void updateProductSellerTest() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        ProductSellerRequestDTO productUpdate = new ProductSellerRequestDTO();
        productUpdate.setProduct_desc("Jugo de uvas");
        productUpdate.setPrice(15.69);

        String sendjson = mapper.writeValueAsString(productUpdate);

        mockMvc.perform(put("/api/v1/fresh-products/9/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(sendjson)
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + getToken("gpaco","12345")))
                .andDo(print())
                .andExpect(status().isOk());
        //.andExpect(MockMvcResultMatchers.jsonPath("$.message").value(messageError));

    }


}
