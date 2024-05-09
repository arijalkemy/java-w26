package org.example.g14.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.g14.dto.response.UserFollowersCountResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class FollowersCountIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper; // ObjectMapper para parsear JSON

    @Test
    public void getCountFollowersTest() throws Exception {
        UserFollowersCountResponseDto countResponseDto = new UserFollowersCountResponseDto(
                1,
                "John Doe",
                3
        );

        ResultActions results = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/users/{userId}/followers/count", 1)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        results.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        MvcResult result = results.andReturn();

        String jsonResponse = result.getResponse().getContentAsString();

        UserFollowersCountResponseDto actualResponseDto = objectMapper.readValue(jsonResponse, UserFollowersCountResponseDto.class);
        
        Assertions.assertEquals(countResponseDto, actualResponseDto);
    }
}
