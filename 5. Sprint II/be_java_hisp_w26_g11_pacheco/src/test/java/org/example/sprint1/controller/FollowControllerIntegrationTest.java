package org.example.sprint1.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FollowControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetSellerFollowers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/101/followers/list")
                        .param("order", "name_asc")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetFollowedSellers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/234/followed/list")
                        .param("order", "name_asc")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}