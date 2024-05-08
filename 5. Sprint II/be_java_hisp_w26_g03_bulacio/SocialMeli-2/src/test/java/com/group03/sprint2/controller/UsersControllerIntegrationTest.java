package com.group03.sprint2.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.group03.sprint2.dto.SellerNumberOfFollowersDTO;
import com.group03.sprint2.dto.response.MessageResponseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class UsersControllerIntegrationTest {
    static final String ERROR_MESSAGE_NON_EXISTENT_SELLER = "There is not seller with ID: ";
    static final Integer NON_EXISTENT_SELLER_ID = 9999;

    final ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Should return Ok status when buyer follows seller")
    void followOkTest() throws Exception {
        Integer buyerId = 67890;
        Integer sellerId = 1;
        MessageResponseDTO expectedResponseDTO = new MessageResponseDTO("Successfully followed user: " + sellerId);
        String expectedResponseString = writer.writeValueAsString(expectedResponseDTO);

        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/users/{userId}/follow/{userIdToFollow}", buyerId, sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String actualResponseString = mvcResult.getResponse().getContentAsString();

        assertEquals(expectedResponseString, actualResponseString);
    }

    @Test
    @DisplayName("Should return Ok status when retrieving seller's followers count")
    void getSellerFollowersListOkTest() throws Exception {
        Integer sellerId = 1;
        String username = "nombre_vendedor_1";
        Integer followers = 1;
        SellerNumberOfFollowersDTO expectedResponseDTO = SellerNumberOfFollowersDTO.builder()
                .userId(sellerId).username(username).followers(followers)
                .build();
        String expectedResponseString = writer.writeValueAsString(expectedResponseDTO);

        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/users/{userId}/followers/count", sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String actualResponseString = mvcResult.getResponse().getContentAsString();

        assertEquals(expectedResponseString, actualResponseString);
    }

    @Test
    @DisplayName("Should return bad request status when getting followers count from a seller that doesn't exist")
    void getSellerFollowersListBadRequestTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", NON_EXISTENT_SELLER_ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value( ERROR_MESSAGE_NON_EXISTENT_SELLER + NON_EXISTENT_SELLER_ID));
    }

    @Test
    @DisplayName("Should return Ok status when buyer unfollows seller")
    void unfollowOkTest() throws Exception {
        Integer buyerId = 24680;
        Integer sellerId = 3;
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", buyerId, sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value( "Successfully unfollowed user: " + sellerId));
    }

    @Test
    @DisplayName("Should return bad request status when buyer unfollows seller they do not follow")
    void unfollowBadRequestTest() throws Exception {
        Integer buyerId = 67890;
        Integer sellerId = 2;
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", buyerId, sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value( "There is not a follower with ID: " + buyerId));
    }
}
