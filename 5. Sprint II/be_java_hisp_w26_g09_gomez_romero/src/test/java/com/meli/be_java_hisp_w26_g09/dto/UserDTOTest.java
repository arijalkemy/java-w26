package com.meli.be_java_hisp_w26_g09.dto;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDTOTest {

    @Test
    @DisplayName("Test all args constructor")
    void testAllArgsConstructor() {
        Integer userId = 1;
        String userName = "TestUser";
        RoleDTO role = new RoleDTO();
        List<UserDTO> followed = Arrays.asList(new UserDTO(), new UserDTO());
        List<UserDTO> followers = Arrays.asList(new UserDTO(), new UserDTO());
        Integer followersCount = 10;

        UserDTO userDTO = new UserDTO(userId, userName, role, followed, followers, followersCount);

        assertEquals(userId, userDTO.getUserId());
        assertEquals(userName, userDTO.getUserName());
        assertEquals(role, userDTO.getRole());
        assertEquals(followed, userDTO.getFollowed());
        assertEquals(followers, userDTO.getFollowers());
        assertEquals(followersCount, userDTO.getFollowersCount());
    }

    @Test
    @DisplayName("Test no args constructor")
    void testNoArgsConstructor() {
        UserDTO userDTO = new UserDTO();

        assertEquals(null, userDTO.getUserId());
        assertEquals(null, userDTO.getUserName());
        assertEquals(null, userDTO.getRole());
        assertEquals(null, userDTO.getFollowed());
        assertEquals(null, userDTO.getFollowers());
        assertEquals(null, userDTO.getFollowersCount());
    }

    @Test
    @DisplayName("Test builder")
    void testBuilder() {
        Integer userId = 1;
        String userName = "TestUser";

        UserDTO userDTO = UserDTO.builder().userId(userId).userName(userName).build();

        assertEquals(userId, userDTO.getUserId());
        assertEquals(userName, userDTO.getUserName());
    }

    @Test
    @DisplayName("Test validation")
    void testValidation() {
        UserDTO userDTO = new UserDTO(-1, "ThisUsernameIsTooLong", null, null, null, -1);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        var violations = validator.validate(userDTO);

        assertEquals(2, violations.size());
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals("ID must be greater than zero")));
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals("Username max length must be 15 characters")));
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals("Username max length must be 15 characters")));
    }
}