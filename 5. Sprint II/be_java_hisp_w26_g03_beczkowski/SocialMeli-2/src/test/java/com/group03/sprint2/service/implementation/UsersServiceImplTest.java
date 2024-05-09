package com.group03.sprint2.service.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.group03.sprint2.TestUtils;
import com.group03.sprint2.dto.SellerNumberOfFollowersDTO;
import com.group03.sprint2.dto.response.BuyerResponseDTO;
import com.group03.sprint2.dto.response.MessageResponseDTO;
import com.group03.sprint2.dto.response.SellerResponseDTO;
import com.group03.sprint2.dto.response.UserDataResponseDTO;
import com.group03.sprint2.entity.Buyer;
import com.group03.sprint2.entity.Seller;
import com.group03.sprint2.entity.UserData;
import com.group03.sprint2.exception.entity.BadRequestException;
import com.group03.sprint2.repository.implementation.UsersRepositoryImpl;
import com.group03.sprint2.utils.Constants;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UsersServiceImplTest {
    Integer buyerId;
    Buyer buyer;
    Integer sellerId;
    Seller seller;
    ObjectMapper objectMapper;
    String order;

    @Mock
    UsersRepositoryImpl usersRepository;

    @InjectMocks
    UsersServiceImpl usersService;

    @BeforeEach
    void setup() {
        buyerId = 1;
        buyer = TestUtils.createBuyer(buyerId);
        sellerId = 2;
        seller = TestUtils.createSeller(sellerId);
        objectMapper = new ObjectMapper();
    }

    @Test
    @DisplayName("Should return expected response when buyer follows seller successfully")
    void followUserOkTest() {
        // Arrange
        when(usersRepository.findBuyerById(buyerId)).thenReturn(buyer);
        when(usersRepository.findSellerById(sellerId)).thenReturn(seller);

        MessageResponseDTO expectedResponse = new MessageResponseDTO("Successfully followed user: " + sellerId);

        // Act
        MessageResponseDTO actualResponse = usersService.followUser(buyerId, sellerId);

        // Assert
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("Should throw BadRequestException when buyer tries to follow seller that does not exist")
    void followUserBadRequestTest() {
        // Arrange
        when(usersRepository.findBuyerById(buyerId)).thenReturn(buyer);
        when(usersRepository.findSellerById(sellerId)).thenReturn(null);

        // Act & assert
        BadRequestException badRequestException = assertThrows(BadRequestException.class, () -> usersService.followUser(buyerId,sellerId));
        assertEquals("There is not seller with ID: " + sellerId, badRequestException.getMessage());
    }

    @Test
    @DisplayName("Should return expected response when buyer unfollows seller successfully")
    void unfollowUserOkTest() {
        // Arrange
        seller.getFollowers().add(UserData.builder()
                .userId(buyer.getUserId())
                .userName(buyer.getUserName())
                .build());
        buyer.getFollowed().add(UserData.builder()
                .userId(seller.getUserId())
                .userName(seller.getUserName())
                .build());

        when(usersRepository.findBuyerById(buyerId)).thenReturn(buyer);
        when(usersRepository.findSellerById(sellerId)).thenReturn(seller);

        MessageResponseDTO expectedResponse = new MessageResponseDTO("Successfully unfollowed user: " + sellerId);

        // Act
        MessageResponseDTO actualResponse = usersService.unfollowUser(buyerId, sellerId);

        // Assert
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("Should throw BadRequestException when buyer tries to unfollow a seller that does not exist")
    void unfollowNonExistentUserBadRequestTest() {
        // Arrange
        when(usersRepository.findBuyerById(buyerId)).thenReturn(buyer);
        when(usersRepository.findSellerById(sellerId)).thenReturn(null);

        // Act & assert
        BadRequestException badRequestException = assertThrows(BadRequestException.class, () -> usersService.unfollowUser(buyerId, sellerId));
        assertEquals("There is not seller with ID: " + sellerId, badRequestException.getMessage());
    }

    @Test
    @DisplayName("Should throw BadRequestException when buyer tries to follow a seller they do not follow")
    void unfollowNotFollowedUserBadRequestTest() {
        // Arrange
        when(usersRepository.findBuyerById(buyerId)).thenReturn(buyer);
        when(usersRepository.findSellerById(sellerId)).thenReturn(seller);

        // Act & Assert
        BadRequestException badRequestException = assertThrows(BadRequestException.class,  ()  -> usersService.unfollowUser(buyerId, sellerId));
        assertEquals("There is not a follower with ID: " + buyer.getUserId(), badRequestException.getMessage());
    }

    @Test
    @DisplayName("Should return DTO with followers count")
    void getFollowersCountOkTest() {
        //Arrange
        List<UserData> sellerFollowers = new ArrayList<>();

        for (int i = 1; i <= 4; i++) {
            UserData user = UserData.builder()
                    .userId(i)
                    .userName("User" + i)
                    .build();
            sellerFollowers.add(user);
        }

        seller.setFollowers(sellerFollowers);
        when(usersRepository.findSellerById(sellerId)).thenReturn(seller);

        // Act
        SellerNumberOfFollowersDTO numberOfFollowersDTO = usersService.getNumberOfFollowers(sellerId);

        //Assert
        assertEquals(4, numberOfFollowersDTO.getFollowers());
    }

    @Test
    @DisplayName("Should return a bad request when id seller doesnt exist")
    void getFollowersCountBadRequestTest() {
        Integer id = 99999;
        //Arrange
        when(usersRepository.findSellerById(id)).thenReturn(null);

        //Act and Assert
        BadRequestException badRequestException = assertThrows(BadRequestException.class,
                ()  -> usersService.getNumberOfFollowers(id));
        assertEquals("There is not seller with ID: " + id, badRequestException.getMessage());

    }

    @Test
    @DisplayName("I expect a list in ascending alphabetical order of SellerResponseDTO.")
    void expectListInAscendingAlphabeticalOrderOfSellers() throws Exception{
        checkOrderSellerFollowersTest(false);
    }

    @Test
    @DisplayName("I expect a list in descending alphabetical order of SellerResponseDTO.")
    void expectListInDescendingAlphabeticalOrderOfSellers() throws Exception{
        checkOrderSellerFollowersTest(true);
    }

    @Test
    @DisplayName("I expect a list in ascending alphabetical order of BuyerResponseDTO.")
    void expectListInAscendingAlphabeticalOrderOfBuyer() throws Exception{
        checkOrderBuyerFollowedTest(false);
    }

    @Test
    @DisplayName("I expect a list in descending alphabetical order of BuyerResponseDTO.")
    void expectListInDescendingAlphabeticalOrderOfBuyer() throws Exception{
        checkOrderBuyerFollowedTest(true);
    }

    @Test
    @DisplayName("Should throw exception when show seller followers receive invalid order param.")
    void showSellerFollowersSortedByNameBadRequestTest() throws Exception{
        // Arrange
        order = "invalid_name_order";

        when(usersRepository.findSellerById(sellerId)).thenReturn(seller);

        // Act & Assert
        BadRequestException exception = assertThrows(BadRequestException.class,
                () -> usersService.showSellerFollowers(sellerId, order));
        assertEquals("Invalid parameter to order list: " + order, exception.getMessage());
    }

    @Test
    @DisplayName("Should throw exception when show buyer followed receive invalid order param.")
    void showBuyerFollowedSortedByNameBadRequestTest() throws Exception{
        // Arrange
        order = "invalid_name_order";

        when(usersRepository.findBuyerById(buyerId)).thenReturn(buyer);

        // Act & Assert
        BadRequestException exception = assertThrows(BadRequestException.class,
                () -> usersService.showBuyerFollowed(buyerId, order));
        assertEquals("Invalid parameter to order list: " + order, exception.getMessage());
    }

    void checkOrderSellerFollowersTest(boolean isReversedOrder) throws Exception{
        // Arrange
        sellerId = 1;
        if (isReversedOrder) {
            order = Constants.ORDER_NAME_DESCENDANT;
        } else {
            order = Constants.ORDER_NAME_ASCENDANT;
        }
        Seller seller = TestUtils.getSellerById(sellerId);
        when(usersRepository.findSellerById(sellerId)).thenReturn(seller);

        List<UserData> buyers = sortUserDataList(seller.getFollowers(), isReversedOrder);

        SellerResponseDTO expectedResult = new SellerResponseDTO(
                seller.getUserId(),
                seller.getUserName(),
                buyers.stream().map(s -> objectMapper.convertValue(s, UserDataResponseDTO.class)).collect(Collectors.toList()),
                null);
        // Act
        SellerResponseDTO realResponse = usersService.showSellerFollowers(sellerId, order);

        // Assert
        assertEquals(expectedResult, realResponse);
    }

    void checkOrderBuyerFollowedTest(boolean isReversedOrder) throws Exception{
        // Arrange
        buyerId = 12345;
        if (isReversedOrder) {
            order = Constants.ORDER_NAME_DESCENDANT;
        } else {
            order = Constants.ORDER_NAME_ASCENDANT;
        }

        Buyer buyer = TestUtils.getBuyerById(buyerId);
        when(usersRepository.findBuyerById(buyerId)).thenReturn(buyer);

        List<UserData> sellers = sortUserDataList(buyer.getFollowed(), isReversedOrder);

        BuyerResponseDTO expectedResult = new BuyerResponseDTO(
                buyer.getUserId(),
                buyer.getUserName(),
                sellers.stream().map(s -> objectMapper.convertValue(s, UserDataResponseDTO.class)).collect(Collectors.toList()));
        // Act
        BuyerResponseDTO realResponse = usersService.showBuyerFollowed(buyerId, order);

        // Assert
        assertEquals(expectedResult, realResponse);
    }

    List<UserData> sortUserDataList(List<UserData> list, boolean isReversedOrder) {
        if (isReversedOrder) {
            return list.stream()
                    .sorted(Comparator.comparing(UserData::getUserName).reversed())
                    .collect(Collectors.toList());
        } else {
            return list.stream()
                    .sorted(Comparator.comparing(UserData::getUserName))
                    .collect(Collectors.toList());
        }
    }
}
