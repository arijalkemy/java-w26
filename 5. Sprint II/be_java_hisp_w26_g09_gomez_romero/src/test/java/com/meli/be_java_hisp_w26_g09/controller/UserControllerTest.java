package com.meli.be_java_hisp_w26_g09.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.be_java_hisp_w26_g09.dto.ResponseDTO;
import com.meli.be_java_hisp_w26_g09.dto.UserDTO;
import com.meli.be_java_hisp_w26_g09.service.IUserService;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IUserService userService;

    ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

    @Test
    @DisplayName("Test to get all the followers of a seller")
    void UserController_GetFollowersList_Success() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(2);

        userDTO.setUserName("AliceSmith");
        userDTO.setFollowers(Arrays.asList(
                UserDTO.builder().userId(1).userName("JohnDoe").build(),
                UserDTO.builder().userId(6).userName("JessicaWilson").build(),
                UserDTO.builder().userId(20).userName("OliviaKing").build()
        ));

        String expectedResponse = writer.writeValueAsString(userDTO);

        when(userService.getFollowersById(anyInt())).thenReturn(userDTO);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/2/followers/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id", CoreMatchers.is(userDTO.getUserId())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name", CoreMatchers.is(userDTO.getUserName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers.size()", CoreMatchers.is(userDTO.getFollowers().size())))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        String actualResponse = mvcResult.getResponse().getContentAsString();

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("Test to get all the followers of a seller order asc")
    void UserController_GetFollowersListOrderAsc_Success() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(2);

        userDTO.setUserName("AliceSmith");
        userDTO.setFollowers(Arrays.asList(
                UserDTO.builder().userId(1).userName("JohnDoe").build(),
                UserDTO.builder().userId(6).userName("JessicaWilson").build(),
                UserDTO.builder().userId(20).userName("OliviaKing").build()
        ));

        String expectedResponse = writer.writeValueAsString(userDTO);

        when(userService.getFollowersByIdOrdered(anyInt(), anyString())).thenReturn(userDTO);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/2/followers/list")
                        .param("order", "name_asc"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id", CoreMatchers.is(userDTO.getUserId())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name", CoreMatchers.is(userDTO.getUserName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers.size()", CoreMatchers.is(userDTO.getFollowers().size())))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        String actualResponse = mvcResult.getResponse().getContentAsString();

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("Test to get all users followed by a customer")
    void UserController_GetFollowedList_Success() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(1);
        userDTO.setUserName("JohnDoe");

        userDTO.setFollowed(Arrays.asList(
                UserDTO.builder().userId(2).userName("AliceSmith").build(),
                UserDTO.builder().userId(4).userName("EmilyBrown").build()
        ));

        String expectedResponse = writer.writeValueAsString(userDTO);

        when(userService.getFollowedById(anyInt())).thenReturn(userDTO);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/1/followed/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id", CoreMatchers.is(userDTO.getUserId())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name", CoreMatchers.is(userDTO.getUserName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed.size()", CoreMatchers.is(userDTO.getFollowed().size())))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        String actualResponse = mvcResult.getResponse().getContentAsString();

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("Test to get all users followed by a customer order asc")
    void UserController_GetFollowedListOrderAsc_Success() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(1);
        userDTO.setUserName("JohnDoe");

        userDTO.setFollowed(Arrays.asList(
                UserDTO.builder().userId(2).userName("AliceSmith").build(),
                UserDTO.builder().userId(4).userName("EmilyBrown").build()
        ));

        String expectedResponse = writer.writeValueAsString(userDTO);

        when(userService.getFollowedByIdOrdered(userDTO.getUserId(), "name_asc")).thenReturn(userDTO);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/1/followed/list")
                        .param("order", "name_asc"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id", CoreMatchers.is(userDTO.getUserId())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name", CoreMatchers.is(userDTO.getUserName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed.size()", CoreMatchers.is(userDTO.getFollowed().size())))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        String actualResponse = mvcResult.getResponse().getContentAsString();

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("Test to get all users")
    void UserController_GetAllUsers_Success() throws Exception {
        List<UserDTO> users = Arrays.asList(
                UserDTO.builder().userId(1).userName("JohnDoe").followed(Arrays.asList(
                        UserDTO.builder().userId(2).userName("AliceSmith").build(),
                        UserDTO.builder().userId(3).userName("EmilyBrown").build()
                )).build(),
                UserDTO.builder().userId(2).userName("AliceSmith").build(),
                UserDTO.builder().userId(3).userName("EmilyBrown").build()
        );

        String expectedResponse = writer.writeValueAsString(users);

        when(userService.getAllUsers()).thenReturn(users);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(users.size())))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        String actualResponse = mvcResult.getResponse().getContentAsString();

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("Test to follow a user")
    void UserController_FollowAUser_Success() throws Exception{
        int userId = 1;
        int userIdToFollow = 2;

        String message = "The user with id " + userId + " is follow to " + userIdToFollow;

        when(userService.follow(userId, userIdToFollow)).thenReturn(new ResponseDTO(message));

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/users/1/follow/2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", CoreMatchers.is(message)))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        String expectedResponse = "{\"message\":\"" + message + "\"}";
        String actualResponse = mvcResult.getResponse().getContentAsString();

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("Test to unfollow a user")
    void UserController_UnfollowAUser_Success() throws Exception {
        int userId = 1;
        int userIdToUnfollow = 2;

        String message = "Unfollow successfull";

        when(userService.unfollowUser(userId, userIdToUnfollow)).thenReturn(new ResponseDTO(message));

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/users/1/unfollow/2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", CoreMatchers.is(message)))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        String expectedResponse = "{\"message\":\"" + message + "\"}";
        String actualResponse = mvcResult.getResponse().getContentAsString();

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("Test to get followers count")
    void UserController_GetFollowersCount_Success() throws Exception{
        UserDTO userDTO = UserDTO.builder().userId(1).userName("AliceSmith").followersCount(3).build();

        String expectedResponse = writer.writeValueAsString(userDTO);

        when(userService.getFollowersCount(userDTO.getUserId())).thenReturn(userDTO);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/1/followers/count"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id", CoreMatchers.is(userDTO.getUserId())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name", CoreMatchers.is(userDTO.getUserName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers_count", CoreMatchers.is(userDTO.getFollowersCount())))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        String actualResponse = mvcResult.getResponse().getContentAsString();

        assertEquals(actualResponse, expectedResponse);
    }

}