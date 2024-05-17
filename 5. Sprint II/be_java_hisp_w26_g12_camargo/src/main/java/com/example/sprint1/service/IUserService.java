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

    FollowListDto getFollowerList(Integer userId, String order);

    FollowListDto getFollowedList(Integer userId, String order);

    void setUnfollow(Integer userId, Integer userIdToUnfollow);

    List<User> getUsers();

    FollowerUsersDto convertToFollowUserDto(User user);

    void addPostToUser(Integer userId, Integer postId);
}
