package com.mercadolibre.project_be_java_hisp_w26_t7.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.mercadolibre.project_be_java_hisp_w26_t7.service.BatchServiceImpl;
import com.mercadolibre.project_be_java_hisp_w26_t7.service.JwtService;
import com.mercadolibre.project_be_java_hisp_w26_t7.util.RoleEnumUtil;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("integration_test")
@ExtendWith(MockitoExtension.class)
class BatchControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JwtService jwtService;

    @Mock
    private BatchServiceImpl batchService;

    LocalDate fixedDate = LocalDate.of(2024, 6, 14);
    @MockBean
    Clock clock;
    @InjectMocks
    private BatchController batchController;



    @BeforeEach
    void setUp() {
        when(clock.instant()).thenReturn(fixedDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        when(clock.getZone()).thenReturn(ZoneId.systemDefault());
    }

//    @Test
//    void getBatchesNearExpiryTest() throws Exception {
//        String token =  jwtService.generateToken(RoleEnumUtil.REPRESENTATIVE, 1L).getToken();
//        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fresh-products/batch/list/due-date/{cantDays}",
//            5).header("Authorization", "Bearer "+ token))
//            .andDo(print()).andExpect(status().isOk())
//            .andExpect(content().contentType("application/json"))
//            .andExpect(MockMvcResultMatchers.jsonPath("$.batch_stock.length()").value(2))
//            .andExpect(MockMvcResultMatchers.jsonPath("$.batch_stock[0].batch_number").value(4))
//            .andExpect(MockMvcResultMatchers.jsonPath("$.batch_stock[0].product_id").value(2))
//            .andExpect(MockMvcResultMatchers.jsonPath("$.batch_stock[0].product_type_id").value(1))
//            .andExpect(MockMvcResultMatchers.jsonPath("$.batch_stock[0].due_date").value("15-06-2024"))
//            .andExpect(MockMvcResultMatchers.jsonPath("$.batch_stock[0].current_quantity").value(80));
//
//
//    }

    @Test
    void getBatchesNearExpiryWrongRoleTest() throws Exception {
        String token =  jwtService.generateToken(RoleEnumUtil.BUYER, 1L).getToken();
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fresh-products/batch/list/due-date/{cantDays}",
                        5).header("Authorization", "Bearer "+ token))
                .andDo(print()).andExpect(status().isUnauthorized());


    }

}



