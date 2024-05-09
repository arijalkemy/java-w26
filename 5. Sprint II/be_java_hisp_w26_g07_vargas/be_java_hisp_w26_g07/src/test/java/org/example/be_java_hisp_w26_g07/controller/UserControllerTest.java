package org.example.be_java_hisp_w26_g07.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.be_java_hisp_w26_g07.entity.User;
import org.example.be_java_hisp_w26_g07.service.interfaces.IUserService;
import org.example.be_java_hisp_w26_g07.utils.GeneratorDataTest;
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
    @DisplayName("T-0001: Follow method unit test")
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


}
