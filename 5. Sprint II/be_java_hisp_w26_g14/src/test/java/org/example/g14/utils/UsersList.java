package org.example.g14.utils;

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
}
