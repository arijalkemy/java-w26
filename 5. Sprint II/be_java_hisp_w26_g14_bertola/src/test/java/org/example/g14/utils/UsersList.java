package org.example.g14.utils;

import org.example.g14.model.User;

import java.util.ArrayList;
import java.util.List;

public class UsersList {
    public static List<User> getMockedUsers() {
        List<User> userList = new ArrayList<>();

        userList.add(new User(2, "Alice", new ArrayList<>(), new ArrayList<>()));
        userList.add(new User(3, "Charlie", new ArrayList<>(), new ArrayList<>()));
        userList.add(new User(4, "Bob", new ArrayList<>(), new ArrayList<>()));

        return userList;
    }

    public static List<User> getMockedUsersOrderedAsc() {
        List<User> userList = new ArrayList<>();

        userList.add(new User(2, "Alice", new ArrayList<>(), new ArrayList<>()));
        userList.add(new User(3, "Bob", new ArrayList<>(), new ArrayList<>()));
        userList.add(new User(4, "Charlie", new ArrayList<>(), new ArrayList<>()));

        return userList;
    }

    public static List<User> getMockedUsersOrderedDesc() {
        List<User> userList = new ArrayList<>();

        userList.add(new User(2, "Charlie", new ArrayList<>(), new ArrayList<>()));
        userList.add(new User(3, "Bob", new ArrayList<>(), new ArrayList<>()));
        userList.add(new User(4, "Alice", new ArrayList<>(), new ArrayList<>()));

        return userList;
    }
}
