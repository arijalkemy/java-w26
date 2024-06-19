package com.mercadolibre.fresh_market.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mercadolibre.fresh_market.exceptions.EntityNotFound;
import com.mercadolibre.fresh_market.model.User;
import com.mercadolibre.fresh_market.repository.IUserRepository;
import com.mercadolibre.fresh_market.service.impl.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private IUserRepository userRepositoryMock;

    @InjectMocks
    private UserService systemUnderTest;

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




}
