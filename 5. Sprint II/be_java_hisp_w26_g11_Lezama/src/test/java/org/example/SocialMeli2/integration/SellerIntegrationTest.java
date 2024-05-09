package org.example.SocialMeli2.integration;

import org.example.SocialMeli2.controller.FollowController;
import org.example.SocialMeli2.dto.CountFollowersDTO;
import org.example.SocialMeli2.exception.NotFoundException;
import org.example.SocialMeli2.service.follow.FollowService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = FollowController.class)

public class SellerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private FollowService followService;
    @Test
    public void testCountFollowersToUser() throws Exception {
        CountFollowersDTO dto = new CountFollowersDTO(1, "ElectroJoaquin",3);
        given(followService.countFollowers(1)).willReturn(dto);
        mockMvc.perform(get("/users/1/followers/count")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("ElectroJoaquin"))
                .andExpect(jsonPath("$.followers_count").value(3));
    }
    @Test
    public void testCountFollowersToUserWithNotFound() throws Exception {
        given(followService.countFollowers(anyInt())).willThrow(new NotFoundException("Vendedor no encontrado"));
        // Simula una petición HTTP GET que resulta en un vendedor no encontrado
        mockMvc.perform(get("/users/999/followers/count")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof NotFoundException))
                .andExpect(result -> assertEquals("Vendedor no encontrado", result.getResolvedException().getMessage()));
    }
}
