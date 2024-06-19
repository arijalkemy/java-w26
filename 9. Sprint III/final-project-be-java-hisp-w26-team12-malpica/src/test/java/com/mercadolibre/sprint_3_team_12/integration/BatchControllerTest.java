package com.mercadolibre.sprint_3_team_12.integration;

import com.mercadolibre.sprint_3_team_12.utils.UtilAutenticationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BatchControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetWareHouseStock_ReturnsOk() throws Exception {

        long productId = 1L; // Set a valid product ID
        UtilAutenticationTest utilAutenticationTest = new UtilAutenticationTest();
        String token = utilAutenticationTest.getTokenAdmin(mockMvc); // Get the token
        // Build the request
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fresh-products/" + productId + "/warehouse/list")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                )
                .andExpect(status().isOk()); // Assert OK status code
    }

}
