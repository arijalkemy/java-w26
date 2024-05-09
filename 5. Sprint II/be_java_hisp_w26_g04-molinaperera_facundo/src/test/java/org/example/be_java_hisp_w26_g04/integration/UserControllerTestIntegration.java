package org.example.be_java_hisp_w26_g04.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class UserControllerTestIntegration {


    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Verifica el unfollow del usuario 456 al seller 234")
    void unfollow() throws Exception {
        int userId=456;
        int userIdToFollow=234;

        mockMvc.perform(MockMvcRequestBuilders
                .post("/users/{userId}/unfollow/{userIdToFollow}", userId, userIdToFollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("Verifica el follow de un usuario 456 al  seller 234")
    void follow() throws Exception {
        int userId=456;
        int userIdToFollow=234;

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/{userId}/unfollow/{userIdToFollow}", userId, userIdToFollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }
    @Test
    @DisplayName("Verifica que se realice el ordenamiento de los followers de forma asc con el id del buyer 789")
    void sortFollowers() throws Exception {
        int userId=234;
        String order= "name_asc";

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", userId)
                .param("order",order).contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("user_id").value(234))
                .andExpect(jsonPath("followers.[0].user_id").value(789))//buyer ordenado asc
                .andReturn();
    }

    @Test
    @DisplayName("Verifica que la cantidad de seguidores para el seller 234 sean 2")
    void getFollowersCount() throws Exception {
        int userId=234;
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",userId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("user_id").value(userId))
                .andExpect(jsonPath("followers_count").value(2))
                .andReturn();
    }

    @Test
    @DisplayName("Verifica que la lista de seguidos del buyer 456 este ordenada asc, con el seller 123")
    void sortFollowed() throws Exception{
        int userId=456;
        String order= "name_asc";

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", userId)
                        .param("order",order).contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("user_id").value(userId))
                .andExpect(jsonPath("followed.[0].user_id").value(123))//seller ordenado asc
                .andReturn();
    }

}
