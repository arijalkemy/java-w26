package com.meli.be_java_hisp_w26_g09.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w26_g09.dto.ResponseDTO;
import com.meli.be_java_hisp_w26_g09.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testGetFollowersList() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list",2))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testGetFollowedList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list",1))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testGetFollowersCount() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        UserDTO responseObj = new UserDTO();
        responseObj.setUserId(2);
        responseObj.setFollowersCount(3);
        responseObj.setUserName("AliceSmith");
        responseObj.setFollowers(null);
        String responseJson = objectMapper.writeValueAsString(responseObj);
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",2))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(responseJson));
    }

    @Test
    void testPostFollow() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        ResponseDTO responseObj = new ResponseDTO("The user with id 3 is follow to 2");
        String responseJson = objectMapper.writeValueAsString(responseObj);
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",3,2))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(responseJson));
    }

    @Test
    void testUnfollowUser() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        ResponseDTO responseObj = new ResponseDTO("Unfollow successfull");
        String responseJson = objectMapper.writeValueAsString(responseObj);
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}",1,2))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(responseJson));
    }

    @Test
    void testGetAllUsers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users",1,2))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
