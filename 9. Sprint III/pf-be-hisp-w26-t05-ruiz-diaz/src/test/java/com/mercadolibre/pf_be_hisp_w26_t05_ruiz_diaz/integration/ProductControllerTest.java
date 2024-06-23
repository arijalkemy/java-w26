package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.integration;

import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.enums.TypeProduct;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    static String BASE_URL = "/api/v1/products";


    @Test
    @WithMockUser(username = "buyerUser", roles = {"BUYER"})
    @DisplayName("Test searchProducts - GET /api/v1/products/ - 200 OK")
    public void testSearchProducts() throws Exception {
        mockMvc
                .perform(get(BASE_URL + "/"))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @WithAnonymousUser
    @DisplayName("Test searchProducts - GET /api/v1/products/ - 403 Forbidden")
    public void testSearchProducts403() throws Exception {
        mockMvc
                .perform(get(BASE_URL + "/"))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "buyerUser", roles = {"BUYER"})
    @DisplayName("Test searchProductsByCategory - GET /api/v1/products/list - 200 OK")
    public void testSearchProductsByCategory() throws Exception {
        mockMvc
                .perform(get(BASE_URL + "/list").queryParams(getParams()))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @WithAnonymousUser
    @DisplayName("Test searchProductsByCategory - GET /api/v1/products/list - 403 Forbidden")
    public void testSearchProductsByCategory403() throws Exception {
        mockMvc
                .perform(get(BASE_URL + "/list").queryParams(getParams()))
                .andDo(print())
                .andExpect(status().isForbidden());
    }


    private MultiValueMap<String, String> getParams() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.addAll("category", List.of(TypeProduct.FS.toString(), TypeProduct.FF.toString()));
        return params;
    }

}
