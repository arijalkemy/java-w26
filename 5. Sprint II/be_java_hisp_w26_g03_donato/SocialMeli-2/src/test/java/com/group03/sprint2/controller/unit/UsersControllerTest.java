package com.group03.sprint2.controller.unit;

import com.group03.sprint2.TestUtils;
import com.group03.sprint2.controller.UsersController;
import com.group03.sprint2.dto.PublicationDTO;
import com.group03.sprint2.dto.response.*;
import com.group03.sprint2.dto.SellerNumberOfFollowersDTO;
import com.group03.sprint2.dto.response.MessageResponseDTO;
import com.group03.sprint2.exception.entity.BadRequestException;
import com.group03.sprint2.service.implementation.UsersServiceImpl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
class UsersControllerTest {
    static Integer buyerId;
    static Integer sellerId;

    @Mock
    UsersServiceImpl usersService;

    @InjectMocks
    UsersController usersController;

    @BeforeAll
    static void setup() {
        buyerId = 12345;
        sellerId = 1;
    }

    @Test
    @DisplayName("Should return Ok status when buyer follows seller")
    void followUserOkTest() {
        // Arrange
        MessageResponseDTO expectedServiceResponse = new MessageResponseDTO("Successfully followed user: " + sellerId);
        when(usersService.followUser(buyerId, sellerId))
                .thenReturn(expectedServiceResponse);
        ResponseEntity<MessageResponseDTO> expectedResponse = ResponseEntity.ok().body(expectedServiceResponse);

        // Act
        ResponseEntity<MessageResponseDTO> actualResponse = usersController.followUser(buyerId, sellerId);

        // Assert
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("Should throw BadRequestException when buyer tries to follow seller that does not exist")
    void followUserBadRequestTest() {
        // Arrange
        when(usersService.followUser(buyerId, sellerId))
                .thenThrow(new BadRequestException("There is not seller with ID: " + sellerId));

        // Act & assert
        BadRequestException badRequestException = assertThrows(BadRequestException.class, () -> usersController.followUser(buyerId, sellerId));
        assertEquals("There is not seller with ID: " + sellerId, badRequestException.getMessage());
    }

    @Test
    @DisplayName("Should return Ok status when buyer unfollows seller")
    void unfollowUserOkTest() {
        // Arrange
        MessageResponseDTO expectedServiceResponse = new MessageResponseDTO("Successfully unfollowed user: " + sellerId);
        when(usersService.unfollowUser(buyerId, sellerId)).thenReturn(expectedServiceResponse);
        ResponseEntity<MessageResponseDTO> expectedResponse = ResponseEntity.ok().body(expectedServiceResponse);

        // Act
        ResponseEntity<MessageResponseDTO> actualResponse = usersController.unfollowUser(buyerId, sellerId);

        // Assert
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("Should throw BadRequestException when buyer tries to unfollow seller that does not exist")
    void unfollowNonExistentUserBadRequestTest() {
        // Arrange
        when(usersService.unfollowUser(buyerId, sellerId)).
                thenThrow(new BadRequestException("There is not seller with ID: " + sellerId));

        // Act & Assert
        BadRequestException badRequestException = assertThrows(BadRequestException.class, () -> usersController.unfollowUser(buyerId, sellerId));
        assertEquals("There is not seller with ID: " + sellerId, badRequestException.getMessage());
    }

    @Test
    @DisplayName("Should throw BadRequestException when buyer tries to unfollow a seller they do not follow")
    void unfollowNotFollowedUserBadRequestTest() {
        // Arrange
        when(usersService.unfollowUser(buyerId, sellerId)).
                thenThrow(new BadRequestException("There is not a follower with ID: " + sellerId));

        // Act & Assert
        BadRequestException badRequestException = assertThrows(BadRequestException.class, () -> usersController.unfollowUser(buyerId, sellerId));
        assertEquals("There is not a follower with ID: " + sellerId, badRequestException.getMessage());
    }


    @Test
    @DisplayName("Should get correct followed list")
    void followedListOkOrder() {
        // Arrange
        MessageResponseDTO expectedServiceResponse = new MessageResponseDTO("Successfully followed user: " + sellerId);
        when(usersService.followUser(buyerId, sellerId))
                .thenReturn(expectedServiceResponse);
        ResponseEntity<MessageResponseDTO> expectedResponse = ResponseEntity.ok().body(expectedServiceResponse);

        // Act

        ResponseEntity<MessageResponseDTO> actualResponse = usersController.followUser(buyerId, sellerId);

        // Assert

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("Should Get Followers Count Correctly")
    void getFollowersCountCorrectlyTest() {
        //Arrange
        SellerNumberOfFollowersDTO expectedServiceResponse = new SellerNumberOfFollowersDTO();
        expectedServiceResponse.setUserId(sellerId);
        expectedServiceResponse.setUsername("User1");
        expectedServiceResponse.setFollowers(5);

        when(usersService.getNumberOfFollowers(sellerId)).thenReturn(expectedServiceResponse);

        //Act
        ResponseEntity<SellerNumberOfFollowersDTO> actualResponse = usersController.getFollowersCount(sellerId);

        //Assert
        assertEquals(expectedServiceResponse.getFollowers(), actualResponse.getBody().getFollowers());
        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
    }


    @Test
    @DisplayName("Should show follower list sorted by name.")
    void getFollowersListOrderByNameOKTest() throws IOException {
        // Arrange
        String userName = "nombre_vendedor_1";
        List<UserDataResponseDTO> followersBySellerId = TestUtils.getFollowersDTOBySellerId(sellerId);
        List<PublicationDTO> publicationsDTO = TestUtils.getPublicationDTOs(sellerId);
        SellerResponseDTO sellerResponseDTO = new SellerResponseDTO(sellerId, userName, followersBySellerId, publicationsDTO);

        when(usersService.showSellerFollowers(sellerId, "name_asc")).thenReturn(sellerResponseDTO);
        ResponseEntity<SellerResponseDTO> expectedResponse = ResponseEntity.ok().body(sellerResponseDTO);

        // Act
        ResponseEntity<SellerResponseDTO> actualResponse =
                usersController.getFollowersList(sellerId, "name_asc");

        // then
        assertEquals(expectedResponse, actualResponse);
        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
    }

    @Test
    @DisplayName("Should throw exception when Get followers list receive invalid order param.")
    void getFollowersListOrderByNameBadRequestTest() throws IOException {
        // Arrange
        String order = "invalid_name_asc";
        String errorMessage = "Invalid parameter to order list: " + order;
        when(usersService.showSellerFollowers(sellerId, order)).thenThrow(new BadRequestException(errorMessage));

        // Act & Assert
        BadRequestException badRequestException = assertThrows(BadRequestException.class, () -> usersController.getFollowersList(sellerId, order));
        assertEquals(errorMessage, badRequestException.getMessage());
    }

    @Test
    @DisplayName("Should show followed list sorted by name.")
    void getFollowedListOrderByNameOKTest() throws IOException {
        // Arrange
        String userName = "nombre_de_usuario_1";
        List<UserDataResponseDTO> followersByBuyerId = TestUtils.getFollowedDTOByBuyerId(buyerId);
        BuyerResponseDTO buyerResponseDTO = new BuyerResponseDTO(buyerId, userName, followersByBuyerId);

        when(usersService.showBuyerFollowed(buyerId, "name_asc")).thenReturn(buyerResponseDTO);
        ResponseEntity<BuyerResponseDTO> expectedResponse = ResponseEntity.ok().body(buyerResponseDTO);

        // Act
        ResponseEntity<BuyerResponseDTO> actualResponse = usersController.getFollowedList(buyerId, "name_asc");

        // Assert
        assertEquals(expectedResponse, actualResponse);
        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
    }

    @Test
    @DisplayName("Should throw exception when Get followed list receive invalid order param.")
    void getFollowedListOrderByNameBadRequestTest() throws IOException {
        // Arrange
        String order = "invalid_name_asc";
        String errorMessage = "Invalid parameter to order list: " + order;
        when(usersService.showBuyerFollowed(sellerId, order)).thenThrow(new BadRequestException(errorMessage));

        // Act & Assert
        BadRequestException badRequestException = assertThrows(BadRequestException.class, () -> usersController.getFollowedList(sellerId, order));
        assertEquals(errorMessage, badRequestException.getMessage());
    }
}
