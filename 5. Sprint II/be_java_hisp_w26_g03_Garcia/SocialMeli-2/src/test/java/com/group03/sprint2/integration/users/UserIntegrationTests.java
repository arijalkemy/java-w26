package com.group03.sprint2.integration.users;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.group03.sprint2.dto.SellerNumberOfFollowersDTO;
import com.group03.sprint2.dto.response.BuyerResponseDTO;
import com.group03.sprint2.dto.response.MessageResponseDTO;
import com.group03.sprint2.dto.response.SellerResponseDTO;
import com.group03.sprint2.dto.response.UserDataResponseDTO;
import com.group03.sprint2.exception.dto.ExceptionDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class UserIntegrationTests {
    ObjectWriter writer = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();
    @Autowired
    MockMvc mockMvc;


    @Test
    @DisplayName("Should return status 400 BadRequest - Follow User")
    void followUserIntegrationBadRequestTest() throws Exception{
        Integer buyerId = 24680;
        Integer sellerId = 2;

        ExceptionDTO exceptionDTO = new ExceptionDTO("There is already a follower with ID: " + sellerId);
        String expectedMessage = writer.writeValueAsString(exceptionDTO);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/{userId}/follow/{userIdToFollow}", buyerId, sellerId))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(expectedMessage)).andReturn();
    }

    @Test
    @DisplayName("Should return status 200 OK - Follow User")
    void followUserIntegrationOkTest() throws Exception{
        Integer buyerId = 67890;
        Integer sellerId = 1;

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/{userId}/follow/{userIdToFollow}", buyerId, sellerId))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should return status 200 OK and followers count - Get Followers Count")
    void getFollowersCountOkTest() throws Exception{
        Integer sellerId = 2;
        SellerNumberOfFollowersDTO expectedResponse = new SellerNumberOfFollowersDTO(2, "nombre_vendedor_2", 3);
        String expectedResponseJson = writer.writeValueAsString(expectedResponse);


        mockMvc.perform(MockMvcRequestBuilders
                        .get("/users/{userId}/followers/count", sellerId))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponseJson));
    }


    @Test
    @DisplayName("Should return status 200 OK and followers list - Get Followers List")
    void getFollowersListOkTest() throws Exception{
        Integer sellerId = 2;
        List<UserDataResponseDTO> followers = List.of(new UserDataResponseDTO(12345, "nombre_de_usuario_1"),
                                new UserDataResponseDTO(67890, "nombre_de_usuario_2"),
                                new UserDataResponseDTO(24680, "nombre_de_usuario_3"));

        SellerResponseDTO expectedResponse = new SellerResponseDTO(sellerId, "nombre_vendedor_2", followers, null);

        String expectedResponseJson = writer.writeValueAsString(expectedResponse);


        mockMvc.perform(MockMvcRequestBuilders
                        .get("/users/{userId}/followers/list", sellerId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponseJson));
    }

    @Test
    @DisplayName("Should return status 400 BadRequest - Get Followers List")
    void getFollowersListBadRequestTest() throws Exception{
        Integer sellerId = 222222;

        ExceptionDTO exceptionDTO = new ExceptionDTO("There is not seller with ID: " + sellerId);
        String expectedMessage = writer.writeValueAsString(exceptionDTO);


        mockMvc.perform(MockMvcRequestBuilders
                        .get("/users/{userId}/followers/list", sellerId))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(expectedMessage));

    }

    @Test
    @DisplayName("Should return status 200 OK and followed list - Get Followed List")
    void getFollowedListOkTest() throws Exception{
        Integer buyerId = 12345;
        List<UserDataResponseDTO> followed = List.of(
                new UserDataResponseDTO(3, "nombre_vendedor_1"),
                new UserDataResponseDTO(2, "nombre_vendedor_2"));

        BuyerResponseDTO expectedResponse = new BuyerResponseDTO(buyerId, "nombre_de_usuario_1", followed);

        String expectedResponseJson = writer.writeValueAsString(expectedResponse);


        mockMvc.perform(MockMvcRequestBuilders
                        .get("/users/{userId}/followed/list", buyerId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponseJson));
    }

    @Test
    @DisplayName("Should return status 400 BadRequest - Get Followed List")
    void getFollowedListBadRequestTest() throws Exception{
        Integer buyerId = 8765432;

        ExceptionDTO exceptionDTO = new ExceptionDTO("There is not buyer with ID: " + buyerId);
        String expectedMessage = writer.writeValueAsString(exceptionDTO);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/users/{userId}/followed/list", buyerId))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(expectedMessage));
    }

    @Test
    @DisplayName("Should return status 200 OK - Unfollow User")
    void unfollowUserOkTest() throws Exception{
        Integer buyerId = 12345;
        Integer sellerId = 1;

        MessageResponseDTO message = new MessageResponseDTO("Successfully unfollowed user: " + sellerId);
        String expectedMessage = writer.writeValueAsString(message);


        mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/{userId}/unfollow/{userIdToUnfollow}", buyerId, sellerId))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedMessage));
    }



    @Test
    @DisplayName("Should return status 400 BadRequest - Unfollow User")
    void unfollowUserBadRequestTest() throws Exception{
        Integer buyerId = 76544;
        Integer sellerId = 1;

        MessageResponseDTO message = new MessageResponseDTO("There is not buyer with ID: " + buyerId);
        String expectedMessage = writer.writeValueAsString(message);


        mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/{userId}/unfollow/{userIdToUnfollow}", buyerId, sellerId))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(expectedMessage));
    }

}
