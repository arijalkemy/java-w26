package com.javabootcamp.socialmeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.javabootcamp.socialmeli.dto.response.ErrorDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectWriter ow;

    @BeforeEach
    void setUp() {
        ow = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    @DisplayName("T-0009 -> Corrobora que el endpoint follow responda con exito")
    void whenFollowUserReturnOk() throws Exception {
        Integer userId = 1;
        Integer userToFollow = 2;
        mockMvc.perform(
                        MockMvcRequestBuilders.post(
                                "/users/{userId}/follow/{userToFollow}",
                                userId,
                                userToFollow
                        )
                )
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Follower added succesfully"));
    }
    @Test
    @DisplayName("T-0010 -> Corrobora follow responda 400 al pasar userId negativo ")
    void whenFollowUserWithNegativeUserIdReturnBadRequest() throws Exception {
        Integer userId = -1;
        Integer userToFollow = 2;
        MvcResult res = mockMvc.perform(
                        MockMvcRequestBuilders.post(
                                "/users/{userId}/follow/{userToFollow}",
                                userId,
                                userToFollow
                        )
                )
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();
        ErrorDto expectedResponse = new ErrorDto(List.of("El id del usuario debe ser mayor a cero."));
        String expectedResponseString = ow.writeValueAsString(expectedResponse);
        String actualResponseString = res.getResponse().getContentAsString();
        Assertions.assertEquals(expectedResponseString, actualResponseString);
    }
    @Test
    @DisplayName("T-0011 -> Corrobora follow responda 400 al pasar userToFollow negativo ")
    void whenFollowUserWithNegativeSellerIdReturnBadRequest() throws Exception {
        Integer userId = 1;
        Integer userToFollow = -2;
        MvcResult res = mockMvc.perform(
                        MockMvcRequestBuilders.post(
                                "/users/{userId}/follow/{userToFollow}",
                                userId,
                                userToFollow
                        )
                )
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();
        ErrorDto expectedResponse = new ErrorDto(List.of("El id del vendedor debe ser mayor a cero."));
        String expectedResponseString = ow.writeValueAsString(expectedResponse);
        String actualResponseString = res.getResponse().getContentAsString();
        Assertions.assertEquals(expectedResponseString, actualResponseString);

    }
}
