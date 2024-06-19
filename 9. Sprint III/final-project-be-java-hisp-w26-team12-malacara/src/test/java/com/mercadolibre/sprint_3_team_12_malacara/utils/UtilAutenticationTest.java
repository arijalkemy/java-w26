package com.mercadolibre.sprint_3_team_12_malacara.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.sprint_3_team_12_malacara.dto.request.LoginRequestDTO;
import org.json.JSONObject;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@SpringBootTest()
@AutoConfigureMockMvc
public class UtilAutenticationTest {

    ObjectWriter writer;
    private String token;


    public String getTokenAdmin(MockMvc mockMvc) throws Exception {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        LoginRequestDTO login = new LoginRequestDTO("Quetzalli", "Quetzalli");
        String loginDTO = writer.writeValueAsString(login);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(loginDTO)
                )
                .andExpect(status().isOk())
                .andReturn();

        JSONObject jsonObject = new JSONObject(result.getResponse().getContentAsString());
        token = jsonObject.getString("token");
        return token;
    }

    public String getTokenUser(MockMvc mockMvc) throws Exception {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        LoginRequestDTO login = new LoginRequestDTO("Joaquin", "Joaquin");
        String loginDTO = writer.writeValueAsString(login);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(loginDTO)
                )
                .andExpect(status().isOk())
                .andReturn();

        JSONObject jsonObject = new JSONObject(result.getResponse().getContentAsString());
        token = jsonObject.getString("token");
        return token;
    }
}
