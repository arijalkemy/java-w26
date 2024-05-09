package com.group03.sprint2.repository.implementation;

import com.group03.sprint2.TestUtils;
import com.group03.sprint2.entity.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UsersRepositoryImplTest {
    @Autowired
    UsersRepositoryImpl usersRepository;

    static List<Buyer> buyers;
    static List<Seller> sellers;

    @BeforeAll
    static void loadSellers() throws IOException {
        sellers = TestUtils.loadSellersTest();
        buyers = TestUtils.loadBuyersTest();
    }

    @Test
    @DisplayName("Should find seller by id")
    void findSellerOkTest() {
        // Arrange
        Integer sellerId = 4;
        Seller expectedSeller = sellers.stream().filter(s -> s.getUserId().equals(sellerId)).findFirst().orElse(null);

        // Act

        Seller actualSeller = usersRepository.findSellerById(sellerId);

        // Assert

        assertEquals(expectedSeller, actualSeller);
    }

    @Test
    @DisplayName("Should find buyer by id")
    void findBuyerOkTest() {
        // Arrange
        Integer buyerId = 12345;
        Buyer expectedBuyer = buyers.stream().filter(s -> s.getUserId().equals(buyerId)).findFirst().orElse(null);

        // Act
        Buyer actualBuyer = usersRepository.findBuyerById(buyerId);

        // Assert
        assertEquals(expectedBuyer, actualBuyer);
    }

    @Test
    @DisplayName("Should return null if buyer id does not exists")
    void findBuyerNullTest() {
        // Arrange
        Integer buyerId = 1;

        // Act
        Buyer actualBuyer = usersRepository.findBuyerById(buyerId);

        // Assert
        assertNull(actualBuyer);
    }

    @Test
    @DisplayName("Should return null if seller id does not exists")
    void findSellerNullTest() {
        // Arrange
        Integer sellerId = 200;

        // Act
        Seller actualSeller = usersRepository.findSellerById(sellerId);

        // Assert
        assertNull(actualSeller);
    }

    @Test
    @DisplayName("Should find buyer sellers followed by id")
    void findBuyerSellersFollowedByUserIdOkTest() {
        // Arrange
        Integer buyerId = 24680;
        List<UserData> expectedUserData = buyers.stream()
                .filter(user -> user.getUserId().equals(buyerId))
                .findFirst().orElse(null).getFollowed();

        // Act
        List<UserData> actualUserData = usersRepository.findBuyerSellersFollowedByUserId(buyerId);

        // Assert
        assertEquals(expectedUserData, actualUserData);
    }

    @Test
    @DisplayName("Should return null if buyer id does not exists")
    void findBuyerSellersFollowedByUserIdNullTest() {
        // Arrange
        Integer buyerId = 1;

        // Act
        List<UserData> actualUserData = usersRepository.findBuyerSellersFollowedByUserId(buyerId);

        // Assert
        assertNull(actualUserData);
    }
}