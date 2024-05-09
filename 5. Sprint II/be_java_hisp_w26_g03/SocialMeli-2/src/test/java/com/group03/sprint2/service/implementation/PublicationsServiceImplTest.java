package com.group03.sprint2.service.implementation;

import com.group03.sprint2.TestUtils;
import com.group03.sprint2.dto.PublicationDTO;
import com.group03.sprint2.entity.Buyer;
import com.group03.sprint2.entity.Seller;
import com.group03.sprint2.entity.UserData;
import com.group03.sprint2.exception.entity.BadRequestException;
import com.group03.sprint2.exception.entity.NotFoundException;
import com.group03.sprint2.repository.implementation.UsersRepositoryImpl;
import com.group03.sprint2.utils.Constants;
import com.group03.sprint2.utils.Utils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static com.group03.sprint2.TestUtils.getExpectedPublications;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class PublicationsServiceImplTest {
    static Integer buyerId;
    static Integer sellerId;
    static List<UserData> userSellersFollowed;
    static Seller seller;
    String order;

    @Mock
    UsersRepositoryImpl usersRepository;

    @InjectMocks
    PublicationsServiceImpl publicationsService;

    @BeforeAll()
    static void setup() throws Exception {
        buyerId = 24680;
        sellerId = 2;
        userSellersFollowed = TestUtils.getFollowedByBuyerId(buyerId);
        seller = TestUtils.getSellerById(sellerId);
    }

    void checkLastTwoWeeksOrder(String orderToCheck) throws Exception {
        when(usersRepository.findBuyerSellersFollowedByUserId(buyerId)).thenReturn(userSellersFollowed);
        List<PublicationDTO> expectedPublications = getExpectedPublications(seller, Objects.equals(orderToCheck, Constants.ORDER_NAME_ASCENDANT));

        when(usersRepository.findSellerById(sellerId)).thenReturn(seller);

        // act
        List<PublicationDTO> actualPublications =
                publicationsService.findFollowedLastTwoWeeksPublications(buyerId, order);

        // assert
        assertEquals(expectedPublications, actualPublications);
    }

    @Test
    @DisplayName("Should show publications from last two weeks with out order")
    void findFollowedLastTwoWeeksPublicationsOkTest() throws IOException {
        // Arrange
        when(usersRepository.findBuyerSellersFollowedByUserId(buyerId)).thenReturn(userSellersFollowed);

        seller.getPublications().forEach(p -> p.setDate(LocalDate.now()));
        when(usersRepository.findSellerById(sellerId)).thenReturn(seller);

        // Act
        List<PublicationDTO> actualPublications =
                publicationsService.findFollowedLastTwoWeeksPublications(buyerId, order);

        // Assert
        for(PublicationDTO publicationDTO : actualPublications){
            assertTrue(Utils.isNotNull(publicationDTO.getDate()) &&
                    publicationDTO.getDate().isAfter(LocalDate.now().minusWeeks(Constants.WEEKS_TO_FIND)));
        }
    }

    @Test
    @DisplayName("Should dont show publications because does not exists publications in this weeks")
    void findFollowedLastTwoWeeksPublicationsNotFoundTest() throws IOException {
        // Arrange
        when(usersRepository.findBuyerSellersFollowedByUserId(buyerId)).thenReturn(userSellersFollowed);

        seller.getPublications().forEach(p -> p.setDate(LocalDate.of(2020,10, 4)));
        when(usersRepository.findSellerById(sellerId)).thenReturn(seller);

        // Act & Assert
        NotFoundException exception = assertThrows(NotFoundException.class,
                () -> publicationsService.findFollowedLastTwoWeeksPublications(buyerId, order));
        assertEquals("There are no publications in the last 2 weeks for the specified user.", exception.getMessage());
    }

    @Test
    @DisplayName("Should dont show publications because does not exist the user.")
    void findFollowedLastTwoWeeksPublicationsBuyerBadRequestTest() throws IOException {
        // Arrange
        Integer buyerId = 99999;
        when(usersRepository.findBuyerSellersFollowedByUserId(buyerId)).thenReturn(null);

        // Act & Assert
        BadRequestException exception = assertThrows(BadRequestException.class,
                () -> publicationsService.findFollowedLastTwoWeeksPublications(buyerId, order));
        assertEquals("The specified user does not exist in the system.", exception.getMessage());
    }

    @Test
    @DisplayName("Should dont show publications because does not have any followed sellers.")
    void findFollowedLastTwoWeeksPublicationsBuyerNotFoundTest() throws IOException {
        // Arrange
        Buyer buyer = TestUtils.createBuyer(buyerId);

        when(usersRepository.findBuyerSellersFollowedByUserId(buyerId)).thenReturn(buyer.getFollowed());

        // Act & Assert
        NotFoundException exception = assertThrows(NotFoundException.class,
                () -> publicationsService.findFollowedLastTwoWeeksPublications(buyerId, order));
        assertEquals("The specified user does not have any followed sellers.", exception.getMessage());
    }

    @Test
    @DisplayName("Verify wrong funcionality with a random string for order")
    void findFollowedLastTwoWeeksPublicationsOrderBadRequestTest() throws IOException {
        // Arrange
        order = "order";

        // Act & Assert
        BadRequestException exception = assertThrows(BadRequestException.class,
                () -> publicationsService.findFollowedLastTwoWeeksPublications(buyerId, order));
        assertEquals("Invalid order type.", exception.getMessage());

    }

    @Test
    @DisplayName("Should show publications from last two weeks in ascending order")
    void findFollowedLastTwoWeeksPublicationsAscendingOrderOkTest() throws Exception {
        checkLastTwoWeeksOrder(Constants.ORDER_DATE_ASCENDANT);
    }

    @Test
    @DisplayName("Should show publications from last two weeks in descending order")
    void findFollowedLastTwoWeeksPublicationsDescendingOrderOkTest() throws Exception {
        checkLastTwoWeeksOrder(Constants.ORDER_DATE_DESCENDANT);
    }
}