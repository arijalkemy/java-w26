package com.javabootcamp.socialmeli.utils;

import com.javabootcamp.socialmeli.enums.UserType;
import com.javabootcamp.socialmeli.model.User;


public class UserBuilder {

    public static User userClient(Integer id, String name){
        return user(id, name, UserType.CLIENT);
    }

    public static User userClient(Integer id){
        return user(id, UserType.CLIENT.name(), UserType.CLIENT);
    }

    public static User userSeller(Integer id, String name){
        return user(id, name, UserType.SELLER);
    }

    public static User userSeller(Integer id){
        return user(id,UserType.SELLER.name(), UserType.SELLER);
    }

    private static User user(Integer id, String username, UserType userType){
        return new User(id,username,userType);
    }
}
