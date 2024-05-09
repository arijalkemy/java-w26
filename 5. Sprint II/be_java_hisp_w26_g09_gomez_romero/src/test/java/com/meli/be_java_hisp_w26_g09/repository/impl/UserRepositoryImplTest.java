package com.meli.be_java_hisp_w26_g09.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w26_g09.entity.Role;
import com.meli.be_java_hisp_w26_g09.entity.User;
import com.meli.be_java_hisp_w26_g09.repository.IUserRepository;
import com.meli.be_java_hisp_w26_g09.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UserRepositoryImplTest {
    @Mock
    private IUserRepository userRepository;

    @Mock
    private UserRepositoryImpl userRepositoryImpl;

    @BeforeEach
    void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);
        userRepositoryImpl = new UserRepositoryImpl();
    }

    @Test
    @DisplayName("Test findById")
    void findById_ValidId_ReturnsUser() {
        Integer userId = 1;
        User user = new User(userId, "JohnDoe", new Role(Role.ID_CUSTOMER, "Customer"), Arrays.asList(
                new User(2, "AliceSmith", new Role(Role.ID_SELLER, "Seller"), null),
                new User(4, "EmilyBrown", new Role(Role.ID_SELLER, "Seller"), null)
        ));
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        Optional<User> result = userRepositoryImpl.findById(userId);

        assertTrue(result.isPresent());
        assertEquals(user.getUserId(), result.get().getUserId());
        assertEquals(user.getUserName(), result.get().getUserName());
        assertEquals(user.getRole(), result.get().getRole());
        assertEquals(user.getFollowed(), result.get().getFollowed());
    }

    @Test
    @DisplayName("Test findById with null id")
    void findById_WithNullId_ReturnsEmptyOptional() {
        Integer nullId = null;

        Optional<User> result = userRepositoryImpl.findById(nullId);

        assertFalse(result.isPresent());
    }

    @Test
    @DisplayName("Test findById with zero id")
    void findById_WithZeroId_ReturnsEmptyOptional() {
        Integer zeroId = 0;

        Optional<User> result = userRepositoryImpl.findById(zeroId);

        assertFalse(result.isPresent());
    }

    @Test
    @DisplayName("Test findAll")
    void findAll_ReturnsAllUsers() {
        List<User> result = userRepositoryImpl.findAll();

        assertEquals(20, result.size());
    }

    @Test
    @DisplayName("Test unfollowUser")
    void unfollowUser_UserToUnfollowExists_RemoveUserFromFollowed() {
        User userWhoUnfollow = new User(1, "JohnDoe", new Role(Role.ID_CUSTOMER, "Customer"), new ArrayList<>());
        User userToUnfollow = new User(2, "AliceSmith", new Role(Role.ID_SELLER, "Seller"), new ArrayList<>());
        userWhoUnfollow.getFollowed().add(userToUnfollow);

        userRepositoryImpl.unfollowUser(userWhoUnfollow, userToUnfollow);

        assertTrue(userWhoUnfollow.getFollowed().isEmpty());
    }

    @Test
    @DisplayName("Test addFollowed")
    void addFollowed_AddSellerToCustomerFollowed_SuccessfullyAdded() {
        User customer = new User(1, "JohnDoe", new Role(Role.ID_CUSTOMER, "Customer"), new ArrayList<>());
        User seller = new User(2, "AliceSmith", new Role(Role.ID_SELLER, "Seller"), new ArrayList<>());

        userRepositoryImpl.addFollowed(customer, seller);

        assertEquals(1, customer.getFollowed().size());
        assertEquals(seller, customer.getFollowed().get(0));
    }
}