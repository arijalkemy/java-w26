package org.example.social_meli.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
    @DisplayName("Debería mostrar los vendedores seguidos por un usuario")
    public void getFollowedUsers() throws Exception{
        Integer userId = 1;

        String url = String.format("/users/%d/followed/list", userId);
        String expectedResponse = "{" +
                "\"userId\":1,\"userName\":\"wcalderwood0\"," +
                "\"follower\":" +
                "[{\"userId\":2,\"userName\":\"dclail1\"},{\"userId\":5,\"userName\":\"msynnott4\"}]}";

        mockMvc.perform(MockMvcRequestBuilders.get(url)
                        .contentType("application/json"))
                .andDo(print())
                .andExpect(content().string(expectedResponse))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Debería mostrar los seguidores de un vendedor")
    public void getFollowersTest() throws Exception {
        Integer userId = 5;

        String url = String.format("/users/%d/followers/list", userId);
        String expectedResponse = "{" +
                "\"userId\":5,\"userName\":\"msynnott4\"," +
                "\"follower\":" +
                "[{\"userId\":3,\"userName\":\"ceverett2\"},{\"userId\":1,\"userName\":\"wcalderwood0\"}]}";

        mockMvc.perform(MockMvcRequestBuilders.get(url)
                        .contentType("application/json"))
                .andDo(print())
                .andExpect(content().string(expectedResponse))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Debería mostrar la cantidad de seguidores de un vendedor")
    public void getCountUserFollowersTest() throws Exception{
        Integer userId = 2;

        String url = String.format("/users/%d/followers/count/", userId);
        String expectedResponse = "{\"userId\":2,\"userName\":\"dclail1\",\"followersCount\":2}";
        mockMvc.perform(MockMvcRequestBuilders.get(url)
                        .contentType("application/json"))
                .andDo(print())
                .andExpect(content().string(expectedResponse))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Deberia dejar de seguir a un usuario")
    void postUnfollowUserTest() throws Exception {
        Integer userId = 1;
        Integer userIdToUnfollow = 2;

        String url = String.format("/users/%d/unfollow/%d", userId, userIdToUnfollow);

        mockMvc.perform(MockMvcRequestBuilders.post(url)
                        .contentType("application/json"))
                .andDo(print())
                .andExpect(content().string(
                        "{\"userId\":1,\"userName\":\"wcalderwood0\",\"follower\":" +
                                "[{\"userId\":5,\"userName\":\"msynnott4\"}]}"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Debería seguir a un usuario")
    public void postFollowUserTest() throws Exception{
        Integer userId = 18;
        Integer userIdToFollow = 19;

        String url = String.format("/users/%d/follow/%d", userId, userIdToFollow);

        mockMvc.perform(MockMvcRequestBuilders.post(url)
                        .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Debería organizar seguidores de manera ascendente ")
    public void getOrderFollowersAscTest() throws Exception{
        Integer userId = 2;
        String orderBy = "name_asc";

        String url = String.format("/users/%d/followers/list?order=%s", userId, orderBy);
        String expectedResponse = "{" +
                "\"userId\":2,\"userName\":\"dclail1\"," +
                "\"follower\":" +
                "[{\"userId\":3,\"userName\":\"ceverett2\"},{\"userId\":1,\"userName\":\"wcalderwood0\"}]}";

        mockMvc.perform(MockMvcRequestBuilders.get(url)
                        .contentType("application/json"))
                .andDo(print())
                .andExpect(content().string(expectedResponse))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Debería organizar seguidores de manera ascendente ")
    public void getOrderFollowersDescTest() throws Exception{
        Integer userId = 2;
        String orderBy = "name_desc";

        String url = String.format("/users/%d/followers/list?order=%s", userId, orderBy);
        String expectedResponse = "{" +
                "\"userId\":2,\"userName\":\"dclail1\"," +
                "\"follower\":" +
                "[{\"userId\":1,\"userName\":\"wcalderwood0\"},{\"userId\":3,\"userName\":\"ceverett2\"}]}";

        mockMvc.perform(MockMvcRequestBuilders.get(url)
                        .contentType("application/json"))
                .andDo(print())
                .andExpect(content().string(expectedResponse))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Debería organizar seguidores de manera ascendente ")
    public void getOrderFollowedUsersAscTest() throws Exception{
        Integer userId = 1;
        String orderBy = "name_asc";

        String url = String.format("/users/%d/followed/list?order=%s", userId, orderBy);
        String expectedResponse = "{" +
                "\"userId\":1,\"userName\":\"wcalderwood0\"," +
                "\"follower\":" +
                "[{\"userId\":2,\"userName\":\"dclail1\"},{\"userId\":5,\"userName\":\"msynnott4\"}]}";

        mockMvc.perform(MockMvcRequestBuilders.get(url)
                        .contentType("application/json"))
                .andDo(print())
                .andExpect(content().string(expectedResponse))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Debería organizar seguidores de manera ascendente ")
    public void getOrderFollowedUsersDescTest() throws Exception{
        Integer userId = 1;
        String orderBy = "name_desc";

        String url = String.format("/users/%d/followed/list?order=%s", userId, orderBy);
        String expectedResponse = "{" +
                "\"userId\":1,\"userName\":\"wcalderwood0\"," +
                "\"follower\":" +
                "[{\"userId\":5,\"userName\":\"msynnott4\"},{\"userId\":2,\"userName\":\"dclail1\"}]}";

        mockMvc.perform(MockMvcRequestBuilders.get(url)
                        .contentType("application/json"))
                .andDo(print())
                .andExpect(content().string(expectedResponse))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Debería mostrar error con exception")
    public void getFollowersErrorTest() throws Exception {
        Integer userId = 1;

        String url = String.format("/users/%d/followers/list", userId);
        String expectedResponse = "{" +
                "\"message\":\"El usuario 1 no es vendedor\"}";

        mockMvc.perform(MockMvcRequestBuilders.get(url)
                        .contentType("application/json"))
                .andDo(print())
                .andExpect(content().string(expectedResponse))
                .andExpect(status().isBadRequest());
    }

}