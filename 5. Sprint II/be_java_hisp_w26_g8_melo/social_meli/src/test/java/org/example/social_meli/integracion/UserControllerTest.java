package org.example.social_meli.integracion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Deberia dejar de seguir a un usuario")
    void postUnfollowUser() throws Exception {
        Integer userId = 1;
        Integer userIdToUnfollow = 2;

        String url = String.format("/users/%d/unfollow/%d", userId, userIdToUnfollow);

        mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType("application/json"))
                .andDo(print())
                .andExpect(content().string("{\"userId\":1,\"userName\":\"wcalderwood0\",\"follower\":[]}"))
                .andExpect(status().isOk());
    }
    @Test
    @DisplayName("Deberia de seguir a un nuevo usuario")
    void postFollowTest() throws Exception{
        Integer clientID=9;
        Integer sellerID=11;
        String url = String.format("/users/%d/follow/%d", clientID, sellerID);

        mockMvc.perform(MockMvcRequestBuilders.post(url)
                        .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isOk());

    }
}