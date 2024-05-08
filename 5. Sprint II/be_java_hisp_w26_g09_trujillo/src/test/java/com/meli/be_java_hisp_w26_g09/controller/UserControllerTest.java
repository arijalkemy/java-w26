package com.meli.be_java_hisp_w26_g09.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.be_java_hisp_w26_g09.dto.ResponseDTO;
import com.meli.be_java_hisp_w26_g09.dto.UserDTO;
import com.meli.be_java_hisp_w26_g09.entity.User;
import com.meli.be_java_hisp_w26_g09.util.JsonUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    static ObjectWriter writer;
    private static ObjectMapper objectMapper = new ObjectMapper();
    static User user = new User();
    static UserDTO userDTO = new UserDTO();
    @BeforeAll
    public static void setup() throws IOException {
        userDTO = JsonUtil.readJsonFromFile("core/dto/userDTO.json", UserDTO.class);
        user = JsonUtil.readJsonFromFile("core/entity/user.json", User.class);
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        objectMapper = new ObjectMapper();
    }



    @Test
    @DisplayName("Test for requirement US-0002")
    public void getFollowersCount() throws Exception {

        Integer userFollowers = 2;
        Integer followersCount = 3;

        ResultActions result =
                mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/{userId}/followers/count",userFollowers)
                                .contentType("application/json")
                );

        result.andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();


        String responseBody = result.andReturn().getResponse().getContentAsString();
        UserDTO response = objectMapper.readValue(responseBody, UserDTO.class);
        assertEquals(followersCount,response.getFollowersCount());
    }

    @Test
    @DisplayName("Test for requirement US-0003")
    public void getFollowersList() throws Exception {

        List<User> users = JsonUtil.readJsonFromFileToList("core/entity/usersAll.json", User.class);
        Integer userId = 2;
        Optional<User> userOpt = users.stream()
                .filter(user -> user.getUserId().equals(userId))
                .findFirst();


        ResultActions result =
                mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/{userId}/followers/list",userId)
                                .contentType("application/json")
                );


        result.andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        String responseBody = result.andReturn().getResponse().getContentAsString();
        UserDTO responseUser = objectMapper.readValue(responseBody, UserDTO.class);

        assertEquals(userOpt.get().getUserId(), responseUser.getUserId());
        assertEquals(3, responseUser.getFollowers().size());
    }

    @Test
    @DisplayName("Test for requirement US-0004")
    public void getFollowedList() throws Exception {

        List<User> users = JsonUtil.readJsonFromFileToList("core/entity/usersAll.json", User.class);
        Integer userId = 1;
        Optional<User> userOpt = users.stream()
                .filter(user -> user.getUserId().equals(userId))
                .findFirst();


        ResultActions result =
                mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/{userId}/followed/list",userId)
                                .contentType("application/json")
                );


        result.andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        String responseBody = result.andReturn().getResponse().getContentAsString();
        UserDTO responseUser = objectMapper.readValue(responseBody, UserDTO.class);

        assertEquals(userOpt.get().getUserId(), responseUser.getUserId());
        assertEquals(2, responseUser.getFollowed().size());
    }

    @Test
    @DisplayName("Test for requirement US-0007")
    public void unfollowUser() throws Exception {

        Integer userFollowed = 4;
        Integer userId = 6;

        ResultActions result =
                mockMvc.perform(
                        MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userFollowed}",userId,userFollowed)
                                .contentType("application/json")
                );

        result.andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();


        String responseBody = result.andReturn().getResponse().getContentAsString();
        ResponseDTO response = objectMapper.readValue(responseBody, ResponseDTO.class);
        assertEquals("Unfollow successfull", response.getMessage());
    }


    @Test
    @DisplayName("Test for requirement US-0008")
    public void getFollowersListAsc() throws Exception {


        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(2);
        userDTO.setUserName("AliceSmith");

        List<UserDTO> followers = new ArrayList<>();

        UserDTO follower1 = new UserDTO();
        follower1.setUserId(6);
        follower1.setUserName("JessicaWilson");
        followers.add(follower1);

        UserDTO follower2 = new UserDTO();
        follower2.setUserId(1);
        follower2.setUserName("JohnDoe");
        followers.add(follower2);

        UserDTO follower3 = new UserDTO();
        follower3.setUserId(20);
        follower3.setUserName("OliviaKing");
        followers.add(follower3);

        userDTO.setFollowers(followers);

        String order = "name_asc";
        Integer userId = 2;


        ResultActions result =
                mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/{userId}/followers/list",userId)
                                .param("order",order)
                                .contentType("application/json")
                );

        result.andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();


        String responseBody = result.andReturn().getResponse().getContentAsString();
        UserDTO response = objectMapper.readValue(responseBody, UserDTO.class);
        assertEquals(userDTO, response);
    }

    @Test
    @DisplayName("Test for requirement US-0008")
    public void getFollowedAsc() throws Exception {


        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(1);
        userDTO.setUserName("JohnDoe");

        List<UserDTO> followers = new ArrayList<>();

        UserDTO follower1 = new UserDTO();
        follower1.setUserId(2);
        follower1.setUserName("AliceSmith");
        followers.add(follower1);

        UserDTO follower2 = new UserDTO();
        follower2.setUserId(4);
        follower2.setUserName("EmilyBrown");
        followers.add(follower2);
        userDTO.setFollowed(followers);

        String order = "name_asc";
        Integer userId = 1;


        ResultActions result =
                mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/{userId}/followed/list",userId)
                                .param("order",order)
                                .contentType("application/json")
                );

        result.andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();


        String responseBody = result.andReturn().getResponse().getContentAsString();
        UserDTO response = objectMapper.readValue(responseBody, UserDTO.class);
        assertEquals(userDTO, response);
    }


    @Test
    @DisplayName("Test for requirement US-0001")
    public void postFollow() throws Exception {

        Integer userFollow = 3;
        Integer userFollowed = 9;

        ResultActions result =
                mockMvc.perform(
                        MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",userFollow,userFollowed)
                                .contentType("application/json")
                );

        result.andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();


        String responseBody = result.andReturn().getResponse().getContentAsString();
        ResponseDTO response = objectMapper.readValue(responseBody, ResponseDTO.class);
        assertEquals("The user with id " + userFollow + " is follow to " + userFollowed , response.getMessage());
    }


}