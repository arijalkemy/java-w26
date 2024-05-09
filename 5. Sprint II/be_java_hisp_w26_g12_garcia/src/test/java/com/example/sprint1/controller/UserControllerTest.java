package com.example.sprint1.controller;

import com.example.sprint1.dto.CountFollowersUserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;


    /**
     * Test case to verify the successful retrieval of followers count for a user.
     *
     * @throws Exception if there is an error during the test execution
     */
    @Test
    void integrationGetFollowersCountHappyPath() throws Exception {
        CountFollowersUserDto dto = CountFollowersUserDto.builder()
                .userId(2)
                .userName("user2")
                .count(0)
                .build();
        String expectedJson = new ObjectMapper().writeValueAsString(dto); // Convert dto to json

        String id = "2";
        String path = "/users/" + id + "/followers/count";

        this.mockMvc.perform(get(path))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expectedJson)) // Verify the expected json
                .andExpect(status().isOk());
    }
}
