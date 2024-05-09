package com.meli.be_java_hisp_w26_g09.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w26_g09.dto.ExceptionDTO;
import com.meli.be_java_hisp_w26_g09.dto.ResponseDTO;
import com.meli.be_java_hisp_w26_g09.dto.UserDTO;
import com.meli.be_java_hisp_w26_g09.exception.NotContentFollowedException;
import com.meli.be_java_hisp_w26_g09.exception.NotFoundException;
import com.meli.be_java_hisp_w26_g09.service.IUserService;
import com.meli.be_java_hisp_w26_g09.util.JsonUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IUserService userService;

    private ObjectMapper objectMapper;
    private UserDTO userDTO;

    @BeforeEach
    void setUp() throws IOException {
        objectMapper = new ObjectMapper();
        userDTO = JsonUtil.readJsonFromFile("core/dto/userDTO.json", UserDTO.class);
    }

    @Test
    @DisplayName("Get all users successful")
    void getAllUsersSuccessful() throws Exception {
        // arrange
        List<UserDTO> userDTOsExpected = JsonUtil.readJsonFromFileToList("core/entity/usersAll.json",
                UserDTO.class);

        when(userService.getAllUsers()).thenReturn(userDTOsExpected);

        // act and assert
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        Set<UserDTO> responseUserDTOs = objectMapper.
                readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<>() {
                });
        assertEquals(new HashSet<>(userDTOsExpected), responseUserDTOs);
    }

    @Test
    @DisplayName("Get all followers by seller id")
    void testGetAllFollowersBySellerIdSuccessful() throws Exception {
        // arrange
        int sellerID = 2;
        userDTO = JsonUtil.readJsonFromFile(
                "followers/ordered/responseDTOAsc.json", UserDTO.class);

        when(userService.getFollowersById(sellerID)).thenReturn(userDTO);

        // act and assert
        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/{userId}/followers/list", sellerID)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(userDTO.getUserId()))
                .andReturn();

        assertEquals(objectMapper.writeValueAsString(userDTO),
                mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Get all followers by seller id, when seller not found")
    void testGetAllFollowersBySellerId_NotFoundException() throws Exception {
        // arrange
        int sellerID = 2;
        ExceptionDTO exceptionDTOExpect = JsonUtil.readJsonFromFile(
                "followers/notfound/exceptionDTO.json", ExceptionDTO.class);

        when(userService.getFollowersById(sellerID))
                .thenThrow(new NotFoundException("No information was found about those followers."));

        // act and assert
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", sellerID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(exceptionDTOExpect.getMessage()));
    }

    @Test
    @DisplayName("Get all followers by seller id with name ordered ascending")
    void testGetAllFollowersBySellerId_WithNameOrderedAscending() throws Exception {
        // arrange
        int sellerID = 2;
        String order = "name_asc";
        userDTO = JsonUtil.readJsonFromFile(
                "followers/ordered/responseDTOAsc.json", UserDTO.class);

        when(userService.getFollowersByIdOrdered(sellerID, order))
                .thenReturn(userDTO);

        // act and assert
        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/{userId}/followers/list", sellerID)
                                .param("order", order)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(userDTO.getUserId()))
                .andReturn();

        assertEquals(objectMapper.writeValueAsString(userDTO),
                mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Get all followers by seller id with name ordered descending")
    void testGetAllFollowersBySellerId_WithNameOrderedDescending() throws Exception {
        // arrange
        int sellerID = 2;
        String order = "name_desc";
        userDTO = JsonUtil.readJsonFromFile(
                "followers/ordered/responseDTODesc.json", UserDTO.class);

        when(userService.getFollowersByIdOrdered(sellerID, order))
                .thenReturn(userDTO);

        // act and assert
        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/{userId}/followers/list", sellerID)
                                .param("order", order)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(userDTO.getUserId()))
                .andReturn();

        assertEquals(objectMapper.writeValueAsString(userDTO),
                mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Get all followed by customer id")
    void testGetAllFollowedByCustomerIdSuccessful() throws Exception {
        // arrange
        int customerID = 1;
        userDTO = JsonUtil.readJsonFromFile(
                "followed/ordered/responseDTOAsc.json", UserDTO.class);

        when(userService.getFollowedById(customerID)).thenReturn(userDTO);

        // act and assert
        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/{userId}/followed/list", customerID)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(userDTO.getUserId()))
                .andReturn();

        assertEquals(objectMapper.writeValueAsString(userDTO),
                mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Get all followed by customer id, when customer not found")
    void testGetAllFollowedByCustomerId_NotFoundException() throws Exception {
        // arrange
        int customerID = 1;
        ExceptionDTO exceptionDTOExpect = JsonUtil.readJsonFromFile(
                "followed/notfound/exceptionDTO.json", ExceptionDTO.class);

        when(userService.getFollowedById(customerID))
                .thenThrow(new NotFoundException("No information was found about those followed."));

        // act and assert
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", customerID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(exceptionDTOExpect.getMessage()));
    }

    @Test
    @DisplayName("Get all followed by customer id with name ordered ascending")
    void testGetAllFollowedByCustomerId_WithNameOrderedAscending() throws Exception {
        // arrange
        int customerID = 1;
        String order = "name_asc";
        userDTO = JsonUtil.readJsonFromFile(
                "followed/ordered/responseDTOAsc.json", UserDTO.class);

        when(userService.getFollowedByIdOrdered(customerID, order))
                .thenReturn(userDTO);

        // act and assert
        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/{userId}/followed/list", customerID)
                                .param("order", order)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(userDTO.getUserId()))
                .andReturn();

        assertEquals(objectMapper.writeValueAsString(userDTO),
                mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Get all followed by seller id with name ordered descending")
    void testGetAllFollowedByCustomerId_WithNameOrderedDescending() throws Exception {
        // arrange
        int customerID = 1;
        String order = "name_desc";
        userDTO = JsonUtil.readJsonFromFile(
                "followed/ordered/responseDTODesc.json", UserDTO.class);

        when(userService.getFollowedByIdOrdered(customerID, order))
                .thenReturn(userDTO);

        // act and assert
        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/{userId}/followed/list", customerID)
                                .param("order", order)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(userDTO.getUserId()))
                .andReturn();

        assertEquals(objectMapper.writeValueAsString(userDTO),
                mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Get all followed by seller id when not content followed")
    void testGetAllFollowedByCustomerId_NotContentFollowedException() throws Exception {
        // arrange
        int customerID = 2;
        ExceptionDTO exceptionDTO = JsonUtil.readJsonFromFile(
                "followed/notcontent/exceptionDTO.json", ExceptionDTO.class);

        when(userService.getFollowedById(customerID))
                .thenThrow(new NotContentFollowedException("The seller does not have the option to follow"));

        // act and assert
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/{userId}/followed/list", customerID)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(exceptionDTO.getMessage()));
    }

    @Test
    @DisplayName("Customer follow to seller successful")
    void testPostFollowSuccessful() throws Exception {
        // arrange
        int customerID = 1;
        int sellerID = 9;
        ResponseDTO responseDTO = JsonUtil.readJsonFromFile(
                "followers/successful/responseDTOFollow.json", ResponseDTO.class);

        when(userService.follow(customerID, sellerID))
                .thenReturn(responseDTO);

        // act and assert
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToUnfollow}",
                                        customerID, sellerID)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(responseDTO.getMessage()));
    }

    @Test
    @DisplayName("Customer unfollow to seller successful")
    void testPostUnfollowSuccessful() throws Exception {
        // arrange
        int customerID = 1;
        int sellerID = 9;
        ResponseDTO responseDTO = JsonUtil.readJsonFromFile(
                "followers/successful/responseDTOUnfollow.json", ResponseDTO.class);

        when(userService.unfollowUser(customerID, sellerID))
                .thenReturn(responseDTO);

        // act and assert
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}",
                                        customerID, sellerID)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(responseDTO.getMessage()));
    }

    @Test
    @DisplayName("Get followers count by seller id")
    void testGetFollowersCountSuccessfull() throws Exception {
        // arrange
        int sellerID = 2;
        userDTO = JsonUtil.readJsonFromFile(
                "followers/successful/responseDTOCount.json", UserDTO.class);

        when(userService.getFollowersCount(sellerID)).thenReturn(userDTO);

        // act and assert
        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/{userId}/followers/count", sellerID)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(userDTO.getUserId()))
                .andReturn();

        assertEquals(objectMapper.writeValueAsString(userDTO),
                mvcResult.getResponse().getContentAsString());
    }
}