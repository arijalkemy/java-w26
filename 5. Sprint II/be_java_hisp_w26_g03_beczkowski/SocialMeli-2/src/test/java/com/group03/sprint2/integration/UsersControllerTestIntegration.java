package com.group03.sprint2.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({MockitoExtension.class, SpringExtension.class})
@SpringBootTest
@AutoConfigureMockMvc
public class UsersControllerTestIntegration {

    @Autowired
    private MockMvc mockMvc;
    private Integer buyerId;
    private Integer sellerId;
    private Integer sellerIdFail;
    private Integer buyerIdFail;

    @BeforeEach
    void setUp() {
        buyerId = 24680;
        sellerId = 1;
        sellerIdFail = 999999;
        buyerIdFail = 999999;
    }

    @Test
    @DisplayName("Should show exit message when you follow valid seller and buyer")
    public void followUserOKTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",
                        buyerId, sellerId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                        .value("Successfully followed user: " + sellerId));
    }

    @Test
    @DisplayName("Should show the bad request message when you try to follow with an id seller that doesnt exist")
    public void followUserBadRequestSellerTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",
                        buyerId, sellerIdFail))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                        .value("There is not seller with ID: " + sellerIdFail));
    }

    @Test
    @DisplayName("Should show the bad request message when you try to follow with an id buyer that doesnt exist")
    public void followUserBadRequestBuyerTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",
                        buyerIdFail, sellerId))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                        .value("There is not buyer with ID: " + buyerIdFail));
    }

    @Test
    @DisplayName("Should show the bad request message when you try to follow and the following already exist")
    public void followUserBadRequestFollowerTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",
                        12345, sellerId))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                        .value("There is already a follower with ID: " + sellerId));
    }

    @Test
    @DisplayName("Should show the followers count")
    public void getFollowersCountOKTest() throws Exception {
        sellerId = 2;
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", sellerId))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers").value("3"));

    }

    @Test
    @DisplayName("Should show the bad request message when you try to count followers with an id seller that doesnt exist")
    public void getFollowersCountBadRequestTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", sellerIdFail))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                        .value("There is not seller with ID: " + sellerIdFail));
    }
}
