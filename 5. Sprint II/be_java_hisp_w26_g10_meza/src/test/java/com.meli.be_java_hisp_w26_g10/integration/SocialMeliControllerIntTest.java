package com.meli.be_java_hisp_w26_g10.integration;

import com.api.socialmeli.controller.SocialMeliController;
import com.api.socialmeli.dto.SellersCountFollowersDto;
import com.api.socialmeli.service.impl.BuyerServiceImpl;
import com.api.socialmeli.service.impl.SellerServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = {com.api.socialmeli.BeJavaHispW26G10Application.class})
@AutoConfigureMockMvc
public class SocialMeliControllerIntTest {

    @MockBean
    BuyerServiceImpl buyerService;
    @MockBean
    SellerServiceImpl service;

    @Autowired
    private MockMvc mockMvc;


    @Test
    @DisplayName("Test de integracion para la cuenta de la cantidad de usuarios obtenida de forma exitosa")
    public void getCountOfSellersITest() throws Exception {
        Integer userId = 1;
        SellersCountFollowersDto sellerJson = new SellersCountFollowersDto();
        sellerJson.setUser_id(userId);
        sellerJson.setFollowers_count(2);
        sellerJson.setUser_name("Luis");

        when(service.getCountOfSellerFollowers(userId)).thenReturn(sellerJson);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers_count").value(sellerJson.getFollowers_count()));
    }

    @Test
    @DisplayName("Follow Integration test")
    public void followSellerIntegrationOk() throws Exception {
        Integer userId = 1;
        Integer userToFollow = 4;

        this.mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",userId,userToFollow))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    @DisplayName("Unfollow Integration test")
    public void unFollowSellerIntegrationOk() throws Exception {
        Integer userId = 1;
        Integer userToUnFollow = 2;

        buyerService.unfollowUser(userId, userToUnFollow);

        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnFollow}",userId,userToUnFollow))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
