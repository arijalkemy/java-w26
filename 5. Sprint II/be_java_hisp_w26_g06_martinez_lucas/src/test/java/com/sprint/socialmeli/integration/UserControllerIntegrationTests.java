package com.sprint.socialmeli.integration;

import com.sprint.socialmeli.dto.user.FollowedResponseDTO;
import com.sprint.socialmeli.dto.user.FollowersResponseDTO;
import com.sprint.socialmeli.dto.user.UserResponseDTO;
import com.sprint.socialmeli.entity.Customer;
import com.sprint.socialmeli.service.user.IUsersService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired IUsersService usersService;

    Customer customer;

    @BeforeEach
    public void setup(){
        customer = usersService.checkAndGetCustomer(101);
        customer.setFollowed(new ArrayList<>());
    }


    @Test
    @DisplayName("Test to Endpoint users/{userId}/followers/count - Seller follower count")
    public void sellerIdFollowerCount() throws Exception{
        Integer sellerId = 1;
        this.mockMvc.perform(get("/users/{userId}/followers/count", sellerId))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.follower_count").value(0));
    }

    @Test
    @DisplayName("Test to Endpoint users/{userId}/followers/count - Seller follower count with Work Parameter")
    public void sellerIdFollowerCountWrongParameter() throws Exception{
        Integer sellerId = -1;
        this.mockMvc.perform(get("/users/{userId}/followers/count", sellerId))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El userId debe ser mayor a cero"));
    }

    @Test
    @DisplayName("Test to Endpoint /users/{userId}/followers/list - Seller Followers List")
    public void sellerFollowerList() throws Exception{
        FollowersResponseDTO followersResponseDto = new FollowersResponseDTO(
                1,
                "John Doe",
                new ArrayList<>()
        );

        this.mockMvc.perform(get("/users/{userId}/followers/list", 1))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(followersResponseDto.getUser_id()))
                .andExpect(jsonPath("$.user_name").value(followersResponseDto.getUser_name()))
                .andExpect(jsonPath("$.followers").isArray());
    }

    @Test
    @DisplayName("Test to Endpoint /users/{userId}/followed/list - Customer Followed List")
    public void customerFollowedList() throws Exception {

        customer.setFollowed(List.of(1));

        FollowedResponseDTO followedResponseDTO = new FollowedResponseDTO(
                101,
                "Alice Johnson",
                new ArrayList<>(List.of(
                        new UserResponseDTO(1, "John Doe")
                ))
        );

        this.mockMvc
                .perform(get("/users/{userId}/followed/list", customer.getUser().getUserId()))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(followedResponseDTO.getUser_id()))
                .andExpect(jsonPath("$.user_name").value(followedResponseDTO.getUser_name()))
                .andExpect(jsonPath("$.followed").isArray())
                .andExpect(jsonPath("$.followed.length()").value(1))
                .andExpect(jsonPath("$.followed[0].user_name").value("John Doe"));
    }

    @Test
    @DisplayName("Test to Endpoint /users/{userId}/unfollow/{userIdToUnfollow} - Unfollow")
    public void unfollow() throws Exception{
        customer.setFollowed(new ArrayList<>(List.of(1, 2)));
        this.mockMvc
                .perform(post("/users/{userId}/unfollow/{userIdToUnfollow}",
                                customer.getUser().getUserId(), 1))
                .andDo(print())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test to Endpoint /users/{userId}/follow/{userIdToFollow} - Follow")
    public void follow() throws Exception{
        this.mockMvc
                .perform(post("/users/{userId}/follow/{userIdToFollow}",
                        customer.getUser().getUserId(), 2))
                .andDo(print())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test to Endpoint /users/{userId}/follow/{userIdToFollow} - Follow Already Existing User")
    public void followAlreadyFollowedUser() throws Exception{
        customer.setFollowed(List.of(2));
        this.mockMvc
                .perform(post("/users/{userId}/follow/{userIdToFollow}",
                        customer.getUser().getUserId(), 2))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.message")
                        .value("The user already follows the seller: 2"));
    }

    @Test
    @DisplayName("Test to Endpoint /users/{userId}/follow/{userIdToFollow} - Follow Not Existing User")
    public void followNotExistingUser() throws Exception{
        this.mockMvc
                .perform(post("/users/{userId}/follow/{userIdToFollow}",
                        customer.getUser().getUserId(), 200))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Seller with ID: 200 not found"));

    }

}
