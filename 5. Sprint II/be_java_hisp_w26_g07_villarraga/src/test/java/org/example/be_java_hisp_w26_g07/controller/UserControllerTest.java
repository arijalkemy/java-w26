package org.example.be_java_hisp_w26_g07.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.be_java_hisp_w26_g07.dto.SuccessResponseDto;
import org.example.be_java_hisp_w26_g07.dto.users.CountFollowersResponseDto;
import org.example.be_java_hisp_w26_g07.service.interfaces.IUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
        Mockito.when(userService.userFollowSeller(5, 2)).thenReturn(true);
        // When - Act
        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 5, 2)
                ).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNoContent()).andReturn();
        // Then - Assert
        String body = result.getResponse().getContentAsString();
        assertEquals("true", body);
    }

    @Test
    @DisplayName("T-0002 dejar de seguir un vendedor correctamente")
    public void unfollowEndpointSuccessful() throws Exception {
        // Assert
        Integer userId = 1;
        Integer userIdToUnfollow = 2;
        SuccessResponseDto expected = new SuccessResponseDto("Se ha dejado de seguir al usuario");

        // Act
        when(userService.unfollow(userId, userIdToUnfollow)).thenReturn(expected);

        // Assert
        mockMvc.perform(post("/users/{userId}/unfollow/{sellerId}", userId, userIdToUnfollow))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(expected.getMessage()));
    }

    @Test
    @DisplayName("Verifica que el endpoint para contar los seguidores de un vendedor devuelva un objeto de tipo " +
            "CountFollowersResponseDto")
    void numberOfSellersFollowedTest() throws Exception {
        Integer userId = 1;
        CountFollowersResponseDto countFollowersResponseDto = new CountFollowersResponseDto(userId, "Monica", 3);
        String jsonExpected = objectWriter.writeValueAsString(countFollowersResponseDto);
        when(userService.getNumberOfSellersFollowed(userId)).thenReturn(countFollowersResponseDto);
        ResultActions result = mockMvc.perform(get("/users/{userId}/followers/count", userId));
        result.andExpect(status().isOk())
                .andDo(print())
                .andExpect(r -> assertEquals(
                        jsonExpected, r.getResponse().getContentAsString()
                ));
    }
}
