package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.FollowersCountDto;
import com.javabootcamp.socialmeli.dto.ResponseDto;
import com.javabootcamp.socialmeli.dto.UserDto;
import com.javabootcamp.socialmeli.enums.OrderType;
import com.javabootcamp.socialmeli.model.User;

import java.util.List;

public interface FollowService {

    void addFollow(User follower, User followed);


    List<UserDto> searchFollowersByUser(int idUser);


    List<User> searchFollowedByUser(Integer idUser);

    List<User> searchFollowedByUserOrder(Integer idUser, OrderType order);

    ResponseDto deleteFollow(Integer followerId, Integer followedId);

    int countFollowers(User user);


    List<UserDto> searchFollowersByUserAndOrderDesc(Integer userId);


    List<UserDto> searchFollowersByUserAndOrderAsc(Integer userId);

    List<FollowersCountDto> searchTopFiveFollowedWithCountFollowers();


}
