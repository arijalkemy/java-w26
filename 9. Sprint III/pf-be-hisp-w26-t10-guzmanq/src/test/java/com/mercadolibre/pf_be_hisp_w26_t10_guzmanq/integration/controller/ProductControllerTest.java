package com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.integration.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = {com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.Application.class})
@AutoConfigureMockMvc
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductControllerTest{

    @Autowired
    MockMvc mockMvc;

    /**
     * Test integration Case Use 2 - Issue Obtener una lista de todos los products
     * Test Exitoso - camino feliz
     */

    @Test
    @DisplayName("Controller: IntegrationTest CU 2 - Obtiene todos los productos registrados")
    void getCantInboundOrderForMonthTestOK() throws Exception{

        MvcResult mvcResult = mockMvc.perform(get("/api/v1/fresh-products/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }

    /**
     * Test integration Case Use 2 - Issue Obtener una lista de todos los products por categoria
     * Test Exitoso
     * Test Not found Exception
     */
    @Test
    @DisplayName("Controller: IntegrationTest CU 2 - Obtiene todos los productos registrados por una Categoria")
    void obtainedAllProductsByCategoryTestOK() throws Exception{

        MvcResult mvcResult = mockMvc.perform(get("/api/v1/fresh-products/list?category=FF"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }

}
