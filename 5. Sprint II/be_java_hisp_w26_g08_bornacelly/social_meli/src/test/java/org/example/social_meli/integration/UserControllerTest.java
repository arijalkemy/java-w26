package org.example.social_meli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.social_meli.dto.UserResponseDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Deberia dejar de seguir a un usuario")
    void postUnfollowUserTest() throws Exception {
        //Arrange
        Integer userId = 1;
        Integer userIdToUnfollow = 2;

        String url = String.format("/users/%d/unfollow/%d", userId, userIdToUnfollow);

        UserResponseDTO userResponseDTO = new UserResponseDTO(1,"wcalderwood0", List.of());

        //Act
        ResultActions results = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isOk());

        //Asserts
        String resultString = results.andReturn().getResponse().getContentAsString();
        String expectedString = objectMapper.writeValueAsString(userResponseDTO);

        Assertions.assertEquals(expectedString, resultString);
    }

    @Test
    @DisplayName("Deberia permitir al usuario con id 3 seguir al 2")
    void postfollowUserTest() throws Exception {
        //Arrange
        Integer userId = 3;
        Integer userIdTofollow = 2;

        String url = String.format("/users/%d/follow/%d", userId, userIdTofollow);

        //Act
        mockMvc.perform(MockMvcRequestBuilders.post(url))
                .andDo(print())
                //Asserts
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Se debería obtner la lista de seguidos del usuario con id 1")
    void getFollowedUsersTest() throws Exception {
        //Arrange
        Integer userId = 1;
        UserResponseDTO userResponseDTO = new UserResponseDTO(1,"wcalderwood0", List.of());

        String url = String.format("/users/%d/followed/list", userId);

        //Act
        ResultActions results = mockMvc.perform(MockMvcRequestBuilders.get(url))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());

        String resultString = results.andReturn().getResponse().getContentAsString();
        String expectedString = objectMapper.writeValueAsString(userResponseDTO);

        //Asserts
        Assertions.assertEquals(expectedString, resultString);

    }
}