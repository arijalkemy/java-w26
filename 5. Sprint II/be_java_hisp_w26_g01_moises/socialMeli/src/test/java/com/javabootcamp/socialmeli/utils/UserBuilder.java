package com.javabootcamp.socialmeli.utils;

import com.javabootcamp.socialmeli.dto.response.UserDto;
import com.javabootcamp.socialmeli.enums.UserType;
import com.javabootcamp.socialmeli.model.User;

import java.util.List;


public class UserBuilder {

    public static List<User> userClientList() {
        return List.of(
                userClient(1),
                userClient(2),
                userClient(3)
        );
    }

    public static User userClient(Integer id, String name) {
        return user(id, name, UserType.CLIENT);
    }

    public static User userClient(Integer id) {
        return user(id, UserType.CLIENT.name(), UserType.CLIENT);
    }

    public static User userSeller(Integer id, String name) {
        return user(id, name, UserType.SELLER);
    }

    public static User userSeller(Integer id) {
        return user(id, UserType.SELLER.name(), UserType.SELLER);
    }

    public static UserDto userClientDto(Integer id) {
        return userDto(id, UserType.CLIENT.name());
    }
    public static List<UserDto> userClientDtoList() {
        return List.of(
                userClientDto(1),
                userClientDto(2),
                userClientDto(3)
        );
    }
    private static UserDto userDto(Integer id, String username) {
        return new UserDto(id, username);
    }
    private static User user(Integer id, String username, UserType userType) {
        return new User(id, username, userType);
    }
}
