package com.mercadolibre.pf_be_hisp_w26_t4_aquino.integration;

import com.mercadolibre.pf_be_hisp_w26_t4_aquino.jwt.JwtService;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.model.Role;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = {"SCOPE_SUFFIX= integration_test"})
public class FreshProductIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private JwtService jwtService;

    @Test
    @DisplayName("traigo los lotes proximos a vencer en 10 dias")
    public void getBatchListByDueDateTest() throws Exception {

        //Arrange
        String token= jwtService.getToken(User.builder()
                .username("manager")
                .password("manager")
                .role(Role.MANAGER)
                .build()
        );

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fresh_products/batch/list/due-date/{cantDays}", 10)
                        .header("Authorization", "Bearer " + token).
                        contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].batch_number").value(3))
                .andExpect(jsonPath("$[1].batch_number").value(5))
                .andExpect(jsonPath("$[2].batch_number").value(4))
                .andExpect(jsonPath("$[3].batch_number").value(2));
    }

    @Test
    @DisplayName("traigo los lotes proximos a vencer por categoria Asc de tipo FS en 10 dias")
    public void getBatchListByCategoryOrderByDueDateAscTest() throws Exception {

        //Arrange
        String token= jwtService.getToken(User.builder()
                .username("manager")
                .password("manager")
                .role(Role.MANAGER)
                .build()
        );

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fresh_products/batch/list/due-date2/{cantDays}", 10)
                        .header("Authorization", "Bearer " + token)
                        .param("category", "FS")
                        .param("order", "date_asc")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].batch_number").value(5))
                .andExpect(jsonPath("$[1].batch_number").value(2));
    }

    @Test
    @DisplayName("traigo los lotes proximos a vencer por categoria Desc de tipo FS en 10 dias")
    public void getBatchListByCategoryOrderByDueDateDescTest() throws Exception {

        //Arrange
        String token= jwtService.getToken(User.builder()
                .username("manager")
                .password("manager")
                .role(Role.MANAGER)
                .build()
        );

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fresh_products/batch/list/due-date2/{cantDays}", 10)
                        .header("Authorization", "Bearer " + token)
                        .param("category", "FS")
                        .param("order", "date_desc")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].batch_number").value(2))
                .andExpect(jsonPath("$[1].batch_number").value(5));
    }
}
