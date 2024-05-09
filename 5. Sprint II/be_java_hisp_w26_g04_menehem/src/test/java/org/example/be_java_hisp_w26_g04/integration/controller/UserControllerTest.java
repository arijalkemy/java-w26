package org.example.be_java_hisp_w26_g04.integration.controller;

import org.example.be_java_hisp_w26_g04.exceptions.BadRequestException;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Un usuario comprador pueda seguir a un usuario vendedor")
    void follow() throws Exception {
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 789, 123))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.blankOrNullString()))
                .andReturn();
    }

    @Test
    @DisplayName("Lanza BadRequestException si el comprador quiere seguir a un vendedor que ya sigue")
    void followExist() throws Exception {
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 456, 123))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertInstanceOf(BadRequestException.class, result.getResolvedException()));
    }

    @Test
    @DisplayName("Devuelve la cantidad de seguidores que tiene un vendedor")
    void getFollowersCount() throws Exception {
        mockMvc.perform(get("/users/{userId}/followers/count", 123))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{'user_id': 123, 'followers_count' : 1}"))
                .andReturn();

    }

    @Test
    @DisplayName("Lanza BadRequestException si el userId no existe")
    void getFollowersCountNotFound() throws Exception {
        mockMvc.perform(get("/users/{userId}/followers/count", 1))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertInstanceOf(BadRequestException.class, result.getResolvedException()));

    }

    @Test
    @DisplayName("Devuelve la lista de a quienes sigue un comprador, ordenada por nombre en forma descendente")
    void sortFollowedNameDesc() throws Exception{
        mockMvc.perform(get("/users/{userId}/followed/list", 456)
                        .queryParam("order", "name_desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{'followed':[{'user_id':123,'user_name':'JohnDoe'},{'user_id':234,'user_name':'JaneSmith'}]}"))
                .andReturn();
    }

    @Test
    @DisplayName("Devuelve los datos del vendedor consultado y una lista de los usuarios que lo siguen")
    void sortFollowers() throws Exception {
        mockMvc.perform(get("/users/{userId}/followers/list", 123))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    @Test
    @DisplayName("Un usuario comprador pueda dejar de seguir a un usuario vendedor")
    void unfollow() throws Exception {
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", 789, 123))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.blankOrNullString()))
                .andReturn();
    }

}