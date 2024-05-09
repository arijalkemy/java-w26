package com.meli.be_java_hisp_w26_g09.integration;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.MethodMode;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w26_g09.dto.UserDTO;
import com.meli.be_java_hisp_w26_g09.util.FactoryUserDTO;


@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    final String BASE_ENDPOINT = "/users";
    final ObjectMapper objectMapper = new ObjectMapper();
    /*
     * Target: /{userId}/followers/list
     * 1. OK Null YA
     * 2. Ok With Order YA
     * 5. Bad is not a Seller YA
     */

    @Test
    @DisplayName("Test to get followers with Valid User without order")
    public void getFollowersValidSeller() throws Exception {
        // Arrange
        String endpointUnderTest = BASE_ENDPOINT + "/{userId}/followers/list";

        Integer userId = 2;
        RequestBuilder request = MockMvcRequestBuilders.get(endpointUnderTest, userId)
                .contentType(MediaType.APPLICATION_JSON);

        // Act
        ResultActions response = this.mockMvc.perform(request);
        response.andDo(MockMvcResultHandlers.print());

        // Assertions
        response.andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    @DisplayName("Test to get followers with Valid User with order Desc")
    @DirtiesContext
    public void getFollowersValidSellerAsc() throws Exception {
        // Arrange
        String endpointUnderTest = BASE_ENDPOINT + "/{userId}/followers/list";
        String order = "name_desc";

        UserDTO responseExpected = FactoryUserDTO.getFollowersDTOWithOrderDesc();

        Integer userId = 2;
        RequestBuilder request = MockMvcRequestBuilders.get(endpointUnderTest, userId)
                .param("order", order)
                .contentType(MediaType.APPLICATION_JSON);

        // Act
        ResultActions response = this.mockMvc.perform(request);
        response.andDo(MockMvcResultHandlers.print());

        UserDTO responseResult = objectMapper.readValue(response.andReturn().getResponse().getContentAsString(),
                UserDTO.class);

        // Assertions
        response.andExpect(MockMvcResultMatchers.status().isOk());
        Assertions.assertEquals(responseExpected, responseResult);
    }

    @Test
    @DisplayName("Test to get followers with Invalid User (Customer)")
    public void getFollowersInvalidUserAsCustomer() throws Exception {
        // Arrange
        String endpointUnderTest = BASE_ENDPOINT + "/{userId}/followers/list";

        Integer userId = 1;
        RequestBuilder request = MockMvcRequestBuilders.get(endpointUnderTest, userId)
                .contentType(MediaType.APPLICATION_JSON);

        // Act
        ResultActions response = this.mockMvc.perform(request);
        response.andDo(MockMvcResultHandlers.print());

        // Assertions
        response.andExpect(MockMvcResultMatchers.status().isBadRequest());
        response.andExpect(
                MockMvcResultMatchers.jsonPath("$.message").value("The customers don't have an option for followers"));
    }

    @Test
    @DisplayName("Test to get followers with User that not exists")
    public void getFollowersNotExistsUser() throws Exception {
        // Arrange
        String endpointUnderTest = BASE_ENDPOINT + "/{userId}/followers/list";

        Integer userId = 9999;
        RequestBuilder request = MockMvcRequestBuilders.get(endpointUnderTest, userId)
                .contentType(MediaType.APPLICATION_JSON);

        // Act
        ResultActions response = this.mockMvc.perform(request);
        response.andDo(MockMvcResultHandlers.print());

        // Assertions
        response.andExpect(MockMvcResultMatchers.status().isNotFound());
        response.andExpect(
                MockMvcResultMatchers.jsonPath("$.message").value("No information was found about those followed."));
    }

    /*
     * Target: /{userId}/followed/list
     * 1. OK Null YA
     * 2. Ok With Order YA
     * 3. Bad is not a Seller YA
     */

    @Test
    @DisplayName("Test to get followeds with Valid User without order")
    public void getFollowedsValidSeller() throws Exception {
        // Arrange
        String endpointUnderTest = BASE_ENDPOINT + "/{userId}/followed/list";

        Integer userId = 1;
        RequestBuilder request = MockMvcRequestBuilders.get(endpointUnderTest, userId)
                .contentType(MediaType.APPLICATION_JSON);

        // Act
        ResultActions response = this.mockMvc.perform(request);
        response.andDo(MockMvcResultHandlers.print());

        // Assertions
        response.andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    @DisplayName("Test to get followeds with Valid User without order")
    @DirtiesContext(methodMode = MethodMode.BEFORE_METHOD)
    public void getFollowedsValidSellerOrderDesc() throws Exception {
        // Arrange
        String endpointUnderTest = BASE_ENDPOINT + "/{userId}/followed/list";
        String order = "name_desc";

        UserDTO responseExpected = FactoryUserDTO.getFollowedDTOWithOrderDesc();

        Integer userId = 1;
        RequestBuilder request = MockMvcRequestBuilders.get(endpointUnderTest, userId)
                .contentType(MediaType.APPLICATION_JSON)
                .param("order", order);

        // Act
        ResultActions response = this.mockMvc.perform(request);
        response.andDo(MockMvcResultHandlers.print());

        UserDTO responseResult = objectMapper.readValue(response.andReturn().getResponse().getContentAsString(),
                UserDTO.class);

        // Assertions
        response.andExpect(MockMvcResultMatchers.status().isOk());
        Assertions.assertEquals(responseExpected, responseResult);
    }

    /*
     * target: Base ENDPOINT
     */

    @Test
    @DisplayName("Test to get All Users")
    public void getAllUsers() throws Exception {
        // Arrange
        RequestBuilder request = MockMvcRequestBuilders.get(BASE_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON);

        // Act

        ResultActions result = mockMvc.perform(request);
        result.andDo(MockMvcResultHandlers.print());

        // Assertion
        result.andExpect(status().isOk());
    }

    /*
     * target: /{userId}/follow/{userIdToFollow}
     * ValidadRequest
     * User alredy follow to seller
     * User not Customer
     * User not Seller
     * User Not exists 1 y 2
     */

    @Test
    @DisplayName("Test to verify that user is followed when params is valid")
    public void followValidRequest() throws Exception {
        // Arrange
        Integer userId = 1;
        Integer userIdToFollow = 7;

        String endpointUnderTest = BASE_ENDPOINT + "/{userId}/follow/{userIdToFollow}";

        RequestBuilder request = MockMvcRequestBuilders.post(endpointUnderTest, userId, userIdToFollow)
                .contentType(MediaType.APPLICATION_JSON);

        // Act
        ResultActions result = mockMvc.perform(request);
        result.andDo(MockMvcResultHandlers.print());

        // Assertions
        result.andExpect(status().isOk());
        result.andExpect(jsonPath("$.message").value("The user with id 1 is follow to 7"));
    }

    @Test
    @DisplayName("Test to verify that try follow to user that already followed")
    public void followUserFollowed() throws Exception {
        // Arrange
        Integer userId = 1;
        Integer userIdToFollow = 4;

        String endpointUnderTest = BASE_ENDPOINT + "/{userId}/follow/{userIdToFollow}";

        RequestBuilder request = MockMvcRequestBuilders.post(endpointUnderTest, userId, userIdToFollow)
                .contentType(MediaType.APPLICATION_JSON);

        // Act
        ResultActions result = mockMvc.perform(request);
        result.andDo(MockMvcResultHandlers.print());

        // Assertions
        result.andExpect(status().isBadRequest());
        result.andExpect(jsonPath("$.message").value("The user already follow to this customer."));
    }

    @Test
    @DisplayName("Test to verify that try follow to user that is not a Seller")
    public void followUserNotSeller() throws Exception {
        // Arrange
        Integer userId = 1;
        Integer userIdToFollow = 1;

        String endpointUnderTest = BASE_ENDPOINT + "/{userId}/follow/{userIdToFollow}";

        RequestBuilder request = MockMvcRequestBuilders.post(endpointUnderTest, userId, userIdToFollow)
                .contentType(MediaType.APPLICATION_JSON);

        // Act
        ResultActions result = mockMvc.perform(request);
        result.andDo(MockMvcResultHandlers.print());

        // Assertions
        result.andExpect(status().isBadRequest());
        result.andExpect(
                jsonPath("$.message").value("Some submitted user does not comply with the role restrictions."));
    }

    @Test
    @DisplayName("Test to verify that try the action follow from user that is not a Customer")
    public void followByNotCustomer() throws Exception {
        // Arrange
        Integer userId = 2;
        Integer userIdToFollow = 1;

        String endpointUnderTest = BASE_ENDPOINT + "/{userId}/follow/{userIdToFollow}";

        RequestBuilder request = MockMvcRequestBuilders.post(endpointUnderTest, userId, userIdToFollow)
                .contentType(MediaType.APPLICATION_JSON);

        // Act
        ResultActions result = mockMvc.perform(request);
        result.andDo(MockMvcResultHandlers.print());

        // Assertions
        result.andExpect(status().isBadRequest());
        result.andExpect(
                jsonPath("$.message").value("Some submitted user does not comply with the role restrictions."));
    }


    @Test
    @DisplayName("Test to verify that try the action follow from user that not exists")
    public void followWithUserNotExists() throws Exception {
        // Arrange
        Integer userId = 99;
        Integer userIdToFollow = 1;

        String endpointUnderTest = BASE_ENDPOINT + "/{userId}/follow/{userIdToFollow}";

        RequestBuilder request = MockMvcRequestBuilders.post(endpointUnderTest, userId, userIdToFollow)
                .contentType(MediaType.APPLICATION_JSON);

        // Act
        ResultActions result = mockMvc.perform(request);
        result.andDo(MockMvcResultHandlers.print());

        // Assertions
        result.andExpect(status().isNotFound());
        result.andExpect(
                jsonPath("$.message").value("The user with id 99 was not found."));
    }


    /*
     * Target: /{userId}/followers/count
     * 1. Is not a Seller
     * 2. Ok
     */

    @Test
    @DisplayName("Test to verify count of followers of Seller")
    public void getCountFollowersBySeller() throws Exception {
        // Arrange
        Integer userId = 2;
        String endpointUnderTest = BASE_ENDPOINT + "/{userId}/followers/count";

        RequestBuilder request = MockMvcRequestBuilders.get(endpointUnderTest, userId)
                .contentType(MediaType.APPLICATION_JSON);
        
        // Act
        ResultActions result = mockMvc.perform(request);
        result.andDo(MockMvcResultHandlers.print());

        // Assertions
        result.andExpect(status().isOk());
    }


    @Test
    @DisplayName("Test to verify count of followers of Customer")
    public void getCountFollowersByCustomer() throws Exception {
        // Arrange
        Integer userId = 1;
        String endpointUnderTest = BASE_ENDPOINT + "/{userId}/followers/count";

        RequestBuilder request = MockMvcRequestBuilders.get(endpointUnderTest, userId)
                .contentType(MediaType.APPLICATION_JSON);
        
        // Act
        ResultActions result = mockMvc.perform(request);
        result.andDo(MockMvcResultHandlers.print());

        // Assertions
        result.andExpect(status().isBadRequest());
        result.andExpect(jsonPath("$.message").value("The customers don't have an option for followers"));
    }

    /*
     * Target: /{userId}/unfollow/{userIdToUnfollow}
     * 1. Customer Unfollow to Seller
     * 2. Customer not follow this seller 
     * 3. Is a seller
     * 4. UserId Not extist
     * 5. userIdUnfollow not exist
     */

    @Test
    @DisplayName("Test yo verifiy that Customer Unfollow to Seller with IDs valid")
    public void unfollowValid() throws Exception{
        //Arrange
        Integer userId = 1;
        Integer userIdToUnFollow = 2;
        String endpointUnderTest = BASE_ENDPOINT + "/{userId}/unfollow/{userIdToUnfollow}";

        RequestBuilder request = MockMvcRequestBuilders.post(endpointUnderTest, userId, userIdToUnFollow);

        //Act
        ResultActions result = mockMvc.perform(request);
        result.andDo(MockMvcResultHandlers.print());

        //Assertions

        result.andExpect(status().isOk());
        result.andExpect(jsonPath("$.message").value("Unfollow successfull"));
    }


    @Test
    @DisplayName("Test yo verifiy that Customer Unfollow to Seller with IDs valid when not exists follow")
    public void unfollowInvalidNotExistFollow() throws Exception{
        //Arrange
        Integer userId = 1;
        Integer userIdToUnFollow = 3;
        String endpointUnderTest = BASE_ENDPOINT + "/{userId}/unfollow/{userIdToUnfollow}";

        RequestBuilder request = MockMvcRequestBuilders.post(endpointUnderTest, userId, userIdToUnFollow);

        //Act
        ResultActions result = mockMvc.perform(request);
        result.andDo(MockMvcResultHandlers.print());

        //Assertions

        result.andExpect(status().isNotFound());
        result.andExpect(jsonPath("$.message").value("User not found in followers list"));
    }


    @Test
    @DisplayName("Test yo verifiy that Customer Unfollow to Seller when UserId is not exists")
    public void unfollowInvalidCustomer() throws Exception{
        //Arrange
        Integer userId = 999;
        Integer userIdToUnFollow = 1;
        String endpointUnderTest = BASE_ENDPOINT + "/{userId}/unfollow/{userIdToUnfollow}";

        RequestBuilder request = MockMvcRequestBuilders.post(endpointUnderTest, userId, userIdToUnFollow);

        //Act
        ResultActions result = mockMvc.perform(request);
        result.andDo(MockMvcResultHandlers.print());

        //Assertions

        result.andExpect(status().isNotFound());
        result.andExpect(jsonPath("$.message").value("User not found"));
    }
     


}
