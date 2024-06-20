package com.mercadolibre.fresh_market.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.mercadolibre.fresh_market.config.security.AuthService;
import com.mercadolibre.fresh_market.exceptions.UnauthorizedAccessException;
import com.mercadolibre.fresh_market.model.enums.Role;
import com.mercadolibre.fresh_market.util.JsonUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mercadolibre.fresh_market.exceptions.EntityNotFound;
import com.mercadolibre.fresh_market.model.User;
import com.mercadolibre.fresh_market.repository.IUserRepository;
import com.mercadolibre.fresh_market.service.impl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private IUserRepository userRepositoryMock;

    @Mock
    private AuthService authService;

    @InjectMocks
    private UserServiceImpl systemUnderTest;

    @Test
    @DisplayName("Test to verify user return when user register given email exists")
    void getUserByEmailWhenUserExistsReturnUser()
    {
        //Arrange
        String email = "Fake@gmail.com";
        User userExpected = User.builder().email(email).build();
        //Act
        when(userRepositoryMock.findUserByEmail(email)).thenReturn(Optional.of(userExpected));

        User reuslt = systemUnderTest.getUserByEmail(email);

        //Assertions
        verify(userRepositoryMock).findUserByEmail(email);
        assertEquals(userExpected, reuslt);   
    }


    @Test
    @DisplayName("Test to verify user exception throws when user register given email that not exists")
    void getUserByEmailWhenUserNotExistsThrowException()
    {
        //Arrange
        String email = "Fake@gmail.com";
        String messageExpected = "The user with username: " + email + " was not found.";
        //Act
        when(userRepositoryMock.findUserByEmail(email)).thenReturn(Optional.empty());

        EntityNotFound excetionResult = assertThrows(EntityNotFound.class, ()->{
            systemUnderTest.getUserByEmail(email);
        });

        //Assertions
        assertEquals(messageExpected, excetionResult.getDescription());
    }


    @Test
    @DisplayName("Validate seller user successfully")
    void testValidateUserSellerSuccess() throws Exception {
        // Arrange
        User user = JsonUtil.readJsonFromFile("user.json", User.class);
        when(userRepositoryMock.findById(1L)).thenReturn(Optional.of(user));
        when(authService.getUserId()).thenReturn(1L);

        // Act
        User result = systemUnderTest.validateUserSeller(1L);

        // Assert
        assertNotNull(result);
        assertEquals(Role.SELLER, result.getRole());
    }


    @Test
    @DisplayName("User not found")
    void testValidateUserSellerNotFound() {
        // Arrange
        when(userRepositoryMock.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(EntityNotFound.class, () -> systemUnderTest.validateUserSeller(1L));
    }

    @Test
    @DisplayName("User is not a seller")
    void testValidateUserSellerNotSeller() {
        // Arrange
        User user = User.builder()
                .id(1L)
                .role(Role.BUYER)
                .build();
        when(userRepositoryMock.findById(1L)).thenReturn(Optional.of(user));

        // Act & Assert
        assertThrows(UnauthorizedAccessException.class, () -> systemUnderTest.validateUserSeller(1L));
    }

    @Test
    @DisplayName("User is not authorized")
    void testValidateUserSellerNotAuthorized() throws Exception {
        // Arrange
        User user = JsonUtil.readJsonFromFile("user.json", User.class);
        when(userRepositoryMock.findById(1L)).thenReturn(Optional.of(user));
        when(authService.getUserId()).thenReturn(2L);

        // Act & Assert
        assertThrows(UnauthorizedAccessException.class, () -> systemUnderTest.validateUserSeller(1L));
    }

}
