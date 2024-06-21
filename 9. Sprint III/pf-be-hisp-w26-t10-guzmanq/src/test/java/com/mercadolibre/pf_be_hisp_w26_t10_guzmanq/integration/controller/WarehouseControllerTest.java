package com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.integration.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = {com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.Application.class})
@AutoConfigureMockMvc
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class WarehouseControllerTest {

    @Autowired
    MockMvc mockMvc;

    /**
     * Test integration Case Use 6 - Issue Obtiene la cantidad de ordenes que ingresaron
     * Test Exitoso - camino feliz
     */
    @Test
    @DisplayName("Controller: IntegrationTest CU 6 - Obtiene la cantidad de ordenes que ingresaron")
    void getCantInboundOrderForMonthTestOK() throws Exception{

        String requestAccess = getToken("jlaura", "12345");
        MvcResult mvcResult = mockMvc.perform(get("/api/v1/fresh-products/warehouse/1/sales/inbound_order")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + requestAccess))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }

    /**
     * Test integration Case Use 6 - Issue Obtiene el total recaudado en las ventas del ultimo mes
     * Test Exitoso - camino feliz
     */
    @Test
    @DisplayName("Controller: IntegrationTest CU 6 - Obtiene el total recaudado en las ventas del ultimo mes")
    void getTotalSalesForMonthTestOK() throws Exception{

        String requestAccess = getToken("jlaura", "12345");
        MvcResult mvcResult = mockMvc.perform(get("/api/v1/fresh-products/warehouse/1/sales/collected-Total")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + requestAccess))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }

    /**
     * Test integration Case Use 6 - Issue Obtiene a cantidad de productos vendidos
     * Test Exitoso - camino feliz
     */
    @Test
    @DisplayName("Controller: IntegrationTest CU 6 - Obtiene a cantidad de productos vendidos")
    void getTotalProductsSalesForMonthTestOK() throws Exception{

        String requestAccess = getToken("jlaura", "12345");
        MvcResult mvcResult = mockMvc.perform(get("/api/v1/fresh-products/warehouse/1/sales/products")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + requestAccess))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }

    /**
     * Test integration Case Use 6 - Issue Obtiene las ventas del ultimo mes
     * Test NotFoundException - camino triste
     */
    @Test
    @DisplayName("Controller: IntegrationTest CU 6 - Obtiene las ventas del ultimo mes")
    void getSalesInLastMonthTestNotFoundEx() throws Exception{

        String requestAccess = getToken("jlaura", "12345");
        MvcResult mvcResult = mockMvc.perform(get("/api/v1/fresh-products/warehouse/1/sales")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + requestAccess))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andReturn();
    }

    /**
     * Test integration Case Use 6 - Issue Obtiene el producto más vendido
     * Test NotFoundException - camino triste
     */
    @Test
    @DisplayName("Controller: IntegrationTest CU 6 - Obtiene el producto más vendido")
    void findBestSellingProductInLastMonthTestNotFoundEx() throws Exception{

        String requestAccess = getToken("jlaura", "12345");
        MvcResult mvcResult = mockMvc.perform(get("/api/v1/fresh-products/warehouse/1/sales/products/best-selling")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + requestAccess))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andReturn();
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
