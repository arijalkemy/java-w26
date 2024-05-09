package org.example.g14.utils;

import org.example.g14.dto.response.UserFollowedResponseDto;
import org.example.g14.dto.response.UserResponseDto;
import org.example.g14.model.User;

import java.util.ArrayList;
import java.util.List;

public class UsersList {
    public static List<User> getMockedUsers() {
        List<User> userList = new ArrayList<>();

        userList.add(new User(2, "Alice", new ArrayList<>(), new ArrayList<>())); // ID 2
        userList.add(new User(3, "Charlie", new ArrayList<>(), new ArrayList<>()));   // ID 3
        userList.add(new User(4, "Bob", new ArrayList<>(), new ArrayList<>())); // ID 4

        return userList;
    }

    public static UserFollowedResponseDto getMockedUserFollowedResponseDtoSortedAsc() {
        return new UserFollowedResponseDto(2, "Jane Smith", List.of(
                new UserResponseDto(4, "Emily Brown"),
                new UserResponseDto(5, "William Taylor")
        ));
    }

    public static UserFollowedResponseDto getMockedUserFollowedResponseDtoSortedDesc() {
        return new UserFollowedResponseDto(2, "Jane Smith", List.of(
                new UserResponseDto(5, "William Taylor"),
                new UserResponseDto(4, "Emily Brown")
        ));
    }
}
