package com.javabootcamp.socialmeli.service;


import com.javabootcamp.socialmeli.dto.response.UserDto;
import com.javabootcamp.socialmeli.dto.response.FollowedSellersDto;
import com.javabootcamp.socialmeli.dto.response.FollowersCountDto;
import com.javabootcamp.socialmeli.dto.response.ResponseDto;
import com.javabootcamp.socialmeli.dto.response.SellerWithFollowersDTO;
import com.javabootcamp.socialmeli.enums.OrderType;
import com.javabootcamp.socialmeli.model.User;

import java.util.List;

public interface UserService {

    FollowedSellersDto searchFollowedById(Integer userId);

    FollowedSellersDto searchFollowedById(Integer userId, OrderType order);
    List<UserDto> getAllUsers();
    SellerWithFollowersDTO searchFollowersById(Integer userId);
    SellerWithFollowersDTO searchFollowersById(Integer userId,OrderType order);
    FollowersCountDto countFollowersById(Integer userId);

    ResponseDto addFollower(Integer followerdId, Integer followedId);

    ResponseDto deleteFollower(Integer followerId, Integer followedId);
    List<Integer> getListSellerId(Integer userId);
    User searchUserById(Integer id);
}
