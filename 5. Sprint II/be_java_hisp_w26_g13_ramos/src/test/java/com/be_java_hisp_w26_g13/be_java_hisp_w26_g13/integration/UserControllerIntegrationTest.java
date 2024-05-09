package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.integration;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.ResponseUserFollowersDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.UserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Perform test obtaining the list of followers of a user")
    public void getFollowersListTest() throws Exception {

        ResponseUserFollowersDTO expectedResponse = ResponseUserFollowersDTO.builder()
                .userId(1)
                .userName("Alice Morrison")
                .followers(List.of(
                        UserDTO.builder()
                                .userId(15)
                                .userName("Oscar Lee")
                                .build(),
                        UserDTO.builder()
                                .userId(2)
                                .userName("Bob Smith")
                                .build()
                ))
                .build();


        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/users/{userId}/followers/list", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(result -> {
                    String jsonResponse = result.getResponse().getContentAsString();
                    ResponseUserFollowersDTO jsonResponseDTO = new ObjectMapper()
                            .readValue(jsonResponse, ResponseUserFollowersDTO.class);
                    assertEquals(expectedResponse, jsonResponseDTO);
                })
                .andReturn();

    }

    @Test
    @DisplayName("Perform test obtaining the list of followers of a user that does not exist")
    public void getFollowersListUserNotFoundTest() throws Exception {

        String expectedResponse = "User with id 200 does not exist";


        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/{userId}/followers/list", 200))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value(expectedResponse))
                .andReturn();

    }
}
