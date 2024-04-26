package com.example.sprint1.service;

import java.util.List;

import com.example.sprint1.dto.CountFollowersUserDto;
import com.example.sprint1.dto.FollowListDto;
import com.example.sprint1.dto.FollowerListDto;
import com.example.sprint1.dto.FollowerUsersDto;
import com.example.sprint1.model.User;

public interface IUserService {
    void addFollower(Integer userID, Integer userIdToFollow);

    CountFollowersUserDto getFollowerCount(Integer userId);

    FollowerListDto getFollowerList(Integer userId, String order);

    FollowListDto getFollowedList(Integer userId);

    String setUnfollow(Integer userId, Integer userIdToUnfollow);

    FollowerListDto getFollowersOrdered(Integer userId, String order);

    List<User> getUsers();

    FollowerUsersDto convertToFollowUserDto(User user);

    FollowListDto getFollowedOrdered(Integer userId, String order);

}
