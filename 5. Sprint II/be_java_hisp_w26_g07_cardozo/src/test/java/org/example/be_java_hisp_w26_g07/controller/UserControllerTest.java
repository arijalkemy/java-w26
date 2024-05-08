package org.example.be_java_hisp_w26_g07.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.be_java_hisp_w26_g07.dto.users.CountFollowersResponseDto;
import org.example.be_java_hisp_w26_g07.dto.users.FollowedResponseDto;
import org.example.be_java_hisp_w26_g07.dto.users.FollowersResponseDto;
import org.example.be_java_hisp_w26_g07.dto.users.UserInfoFollowsDto;
import org.example.be_java_hisp_w26_g07.service.interfaces.IUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(UserController.class)
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IUserService userService;

    ObjectMapper objectMapper;

    ObjectWriter objectWriter;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        objectWriter = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
    }

    @Test
    @DisplayName("T-0001 follow method unit test")
    void followTest() throws Exception {
        // Given - Arrange
        when(userService.userFollowSeller(5, 2)).thenReturn(true);
        // When - Act
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 5, 2)
        ).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNoContent()).andReturn();
        // Then - Assert
        String body = result.getResponse().getContentAsString();
        Assertions.assertEquals("true", body);
    }

    @Test
    @DisplayName("verifica que el metodo devuelva un objeto de tipo CountFollowersResponseDto")
    void numberOfSellersFollowedTest() throws Exception {
        // Given - Arrange
        CountFollowersResponseDto expected = new CountFollowersResponseDto(1,"Test Name",4);
        when(userService.getNumberOfSellersFollowed(1)).thenReturn(expected);
        String expectedStr = objectMapper.writeValueAsString(expected);
        // When - Act
        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/{userId}/followers/count", 1)
                ).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        // Then - Assert
        String body = result.getResponse().getContentAsString();
        Assertions.assertEquals(expectedStr, body);
    }

    @Test
    @DisplayName("verifica que el metodo devuelva una lista de usuarios por un vendedor dado")
    void listOfFollowersSellesrsTest() throws Exception {
        // Given - Arrange
        FollowersResponseDto expected = new FollowersResponseDto(1,"Test Name", List.of(
                new UserInfoFollowsDto(1,"Test 1"),
                new UserInfoFollowsDto(2,"Test 2"),
                new UserInfoFollowsDto(3,"Test 3")
        ));
        when(userService.findFollowersByOrder(1, null)).thenReturn(expected);
        String expectedStr = objectMapper.writeValueAsString(expected);
        // When - Act
        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/{userId}/followers/list", 1)
                ).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        // Then - Assert
        String body = result.getResponse().getContentAsString();
        Assertions.assertEquals(expectedStr, body);
    }

    @Test
    @DisplayName("verifica que el metodo devuelva una lista de vendedores seguidos por un usuario")
    void followedListTest() throws Exception {
        // Given - Arrange
        FollowedResponseDto expected = new FollowedResponseDto(1,"Test Name", List.of(
                new UserInfoFollowsDto(1,"Test 1"),
                new UserInfoFollowsDto(2,"Test 2"),
                new UserInfoFollowsDto(3,"Test 3")
        ));
        when(userService.findFollowedUsers(1, null)).thenReturn(expected);
        String expectedStr = objectMapper.writeValueAsString(expected);
        // When - Act
        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/{userId}/followed/list", 1)
                ).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        // Then - Assert
        String body = result.getResponse().getContentAsString();
        Assertions.assertEquals(expectedStr, body);
    }

}
