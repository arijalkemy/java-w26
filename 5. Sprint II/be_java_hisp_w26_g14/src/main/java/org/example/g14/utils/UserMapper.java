package org.example.g14.utils;

import org.example.g14.dto.response.UserResponseDto;
import org.example.g14.model.User;

public class UserMapper {

    public static UserResponseDto transferToUserDto(User user){
        return new UserResponseDto(user.getId(), user.getName());
    }

}
