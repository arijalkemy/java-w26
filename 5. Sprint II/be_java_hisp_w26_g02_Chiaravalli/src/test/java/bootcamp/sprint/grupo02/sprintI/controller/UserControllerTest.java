package bootcamp.sprint.grupo02.sprintI.controller;

import bootcamp.sprint.grupo02.sprintI.model.Buyer;
import bootcamp.sprint.grupo02.sprintI.repository.BuyerRepository;
import bootcamp.sprint.grupo02.sprintI.service.BuyerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;


    @Test
    @DisplayName("should follow a user successfully")
    void followUserReturnsOk() throws Exception {
        int userId = 1;
        int userIdToFollow = 1;

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Cannot follow seller because is already followed. ")
    void followAgainUserReturnsCannotFollowMessage() throws Exception {
        int userId = 1;
        int userIdToFollow = 1;

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                        .value("Cannot follow seller because is already followed. "));
    }

    @Test
    @DisplayName("Should throw Seller not found message")
    void followUserReturnsNotFoundSeller() throws Exception {
        int userId = 1;
        int userIdToFollow = 5;

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}"
                        , userId, userIdToFollow))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                        .value("Seller not found: " + userIdToFollow));
    }

    @Test
    @DisplayName("should throw El id debe ser mayor a cero message")
    void followUserWithNegativeId() throws Exception {
        int userId = -1;
        int userIdToFollow = 1;

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}"
                        , userId, userIdToFollow))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].message")
                        .value("El Id debe ser mayor a cero"));
    }


    @Test
    @DisplayName("should unfollow a user successfully")
    void unfollowUserReturnsOk() throws Exception {
        int userId = 1;
        int userIdToUnfollow = 1;

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}"
                        , userId, userIdToUnfollow))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    @DisplayName("should unfollow a user successfully")
    void unfollowUserReturnsNotFoundBuyer() throws Exception {
        int userId = 10;
        int userIdToUnfollow = 1;

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}"
                        , userId, userIdToUnfollow))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                        .value("Buyer not found: " + userId));
    }

    @Test
    @DisplayName("Cannot unfollow seller because not followed previously")
    void unfollowAgainUserReturnsCannotUnfollowMessage() throws Exception {
        int userId = 1;
        int userIdToUnfollow = 1;

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}"
                        , userId, userIdToUnfollow))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content()
                        .string("Cannot unfollow seller because not followed previously"));
    }


}
