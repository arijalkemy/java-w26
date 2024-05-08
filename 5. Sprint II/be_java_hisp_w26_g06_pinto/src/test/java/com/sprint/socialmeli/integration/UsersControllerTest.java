package com.sprint.socialmeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sprint.socialmeli.dto.ExceptionDto;
import com.sprint.socialmeli.dto.user.FollowerCountResponseDTO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class UsersControllerTest {

    @Autowired
    MockMvc mockMvc;

    private static Integer sellerId;
    private static Integer customerId;
    private static ObjectMapper writer;

    @BeforeAll
    static void setUp() {
        sellerId = 1;
        customerId = 101;
        writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false);
    }

    @AfterEach
    void tearDown() {
        this.unfollow();
    }

    // Follow integration tests ------ START
    @Test
    @DisplayName("A correct customerId follows a known seller")
     void correctFollow() throws Exception {
        // Arrange
        String expectedResult = "OK";
        // Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .post("/users/{customerId}/follow/{sellerId}", customerId, sellerId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        // Assert
        assertEquals(expectedResult, result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("An unknown customerId follows a known seller")
    void unknownCustomerIdFollowsSeller() throws Exception {
        // Arrange
        Integer unknownCustomerId = 400;
        String expectedExceptionDTOString = writer
                .writeValueAsString(new ExceptionDto("Customer with ID: "+unknownCustomerId+" not found"));
        // Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/{customerId}/follow/{sellerId}",
                                unknownCustomerId, sellerId))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andReturn();
        // Assert
        assertEquals(expectedExceptionDTOString, result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("No customerId sent when follows a known seller")
    void noCustomerIdSentWhenFollowsSeller() throws Exception {
        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/users//follow/{sellerId}", sellerId))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("message").value("El campo no puede estar vacío"))
                .andReturn();
    }

    @Test
    @DisplayName("A correct customerId follows a known seller twice")
    void correctFollowTwiceShouldReject() throws Exception {
        // Act & Assert
        this.correctFollow();
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/{customerId}/follow/{sellerId}", customerId, sellerId))
                .andExpect(MockMvcResultMatchers.status().isConflict())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("message")
                        .value("The user already follows the seller: "+sellerId))
                .andReturn();
    }
    // Follow integration tests ------ END

    // Followers count ----- START

    @Test
    @DisplayName("Seller should have only 1 follower")
    void countOneFollowers() throws Exception {
        // Arrange
        Integer expectedResult = 1;
        String expectedResponse = writer.writeValueAsString(
                new FollowerCountResponseDTO(sellerId, "John Doe", expectedResult));
        // Act
        this.correctFollow();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/users/{userId}/followers/count", sellerId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        // Assert
        assertEquals(expectedResponse, result.getResponse().getContentAsString());
    }

    // --------------------------
    @Test
    @DisplayName("Correct unfollow")
    void correctUnfollow() throws Exception {
        // Arrange
        this.correctFollow();
        String expectedResult = "OK";
        // Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/{customerId}/unfollow/{sellerId}", customerId, sellerId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        // Assert
        assertEquals(expectedResult, result.getResponse().getContentAsString());
    }


    private void unfollow() {
        try {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/{customerId}/unfollow/{sellerId}", customerId, sellerId))
                    .andReturn();
        } catch (Exception e){}
    }
}