package com.api.socialmeli.controller;


import com.api.socialmeli.dto.SellersCountFollowersDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SocialMeliControllerTest {
    @Autowired
    MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    @DisplayName("Test de integracion para el conteo de followers de un vendedor")
    public void followerCountIntegrationOk() throws Exception{
        Integer id = 1;
        SellersCountFollowersDto expected = new SellersCountFollowersDto();
        expected.setUser_id(id);
        expected.setUser_name("Meli");
        expected.setFollowers_count(4);

        String expectedResponse = mapper.writeValueAsString(expected);

        MvcResult result = mockMvc.perform(get("/users/{userId}/followers/count",id))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(expectedResponse,result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("Test de integracion para el follow a un vendedor")
    public void followSellerIntegrationOk() throws Exception {
        Integer userId = 1;
        Integer userToFollow = 4;

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",userId,userToFollow))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    @DisplayName("Test de integracion para el unfollow a un vendedor")
    public void unFollowSellerIntegrationOk() throws Exception {
        Integer userId = 1;
        Integer userToUnFollow = 2;

        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnFollow}",userId,userToUnFollow))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
