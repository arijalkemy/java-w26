package com.mercadolibre.pf_be_hisp_w26_t07_torres.integration.Controller;

import com.mercadolibre.pf_be_hisp_w26_t07_torres.service.JwtService;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.util.DataUtils;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.util.enums.RoleEnumUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = {"SCOPE_SUFFIX = integration_test"})
public class InboundorderControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JwtService jwtService;

    @Test
    public void updatedInboundOrderBatch() throws Exception {
        String token = jwtService.generateToken(RoleEnumUtil.REPRESENTATIVE, 1L).getToken();
        String body = DataUtils.bodyUpdateInboundOrderIntegration();
        mockMvc.perform(put("/api/v1/fresh-products/inboundorder")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
                        .header("Authorization", "Bearer " + token)
                ).andDo(print())
                .andExpect(status().isCreated())
                .andExpect(result -> assertEquals(
                        DataUtils.responseUpdateInboundOrderIntegration(),
                        result.getResponse().getContentAsString(StandardCharsets.UTF_8)));
    }

    @Test
    public void saveInboundOrderBatch() throws Exception {
        String token = jwtService.generateToken(RoleEnumUtil.REPRESENTATIVE, 1L).getToken();
        String body = DataUtils.bodyCreateInboundOrderIntegration();
        mockMvc.perform(post("/api/v1/fresh-products/inboundorder")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
                        .header("Authorization", "Bearer " + token)
                ).andDo(print())
                .andExpect(status().isCreated())
                .andExpect(result -> assertEquals(
                        DataUtils.responseCreateInboundOrderIntegration(),
                        result.getResponse().getContentAsString(StandardCharsets.UTF_8)));
    }
}
