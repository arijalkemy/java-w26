package com.mercadolibre.project_be_java_hisp_w26_t7.controller;

import com.mercadolibre.project_be_java_hisp_w26_t7.service.JwtService;
import com.mercadolibre.project_be_java_hisp_w26_t7.util.enums.RoleEnumUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("integration_test")
@ExtendWith(MockitoExtension.class)
class BatchControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JwtService jwtService;

    LocalDate fixedDate = LocalDate.of(2024, 6, 14);
    @MockBean
    Clock clock;

    @BeforeEach
    void setUp() {
        when(clock.instant()).thenReturn(fixedDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        when(clock.getZone()).thenReturn(ZoneId.systemDefault());
    }

    @Test
    void getBatchesNearExpiryWrongRoleTest() throws Exception {
        String token = jwtService.generateToken(RoleEnumUtil.BUYER, 1L).getToken();
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fresh-products/batch/list/due-date/{cantDays}",
                        5).header("Authorization", "Bearer " + token))
                .andDo(print()).andExpect(status().isUnauthorized());
    }

}



