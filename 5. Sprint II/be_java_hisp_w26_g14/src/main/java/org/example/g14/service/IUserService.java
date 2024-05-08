package org.example.g14.service;

import org.example.g14.dto.response.UserFollowedResponseDto;

import org.example.g14.dto.response.UserFollowersCountResponseDto;

import org.example.g14.dto.response.UserFollowersResponseDto;

public interface IUserService {
    
    UserFollowedResponseDto getListOfFollowedSellers(int userId, String order);
    UserFollowedResponseDto follow(int userId, int userIdToFollow);
    UserFollowedResponseDto unfollowSeller(int followerUserId, int sellerUserId);
    UserFollowersResponseDto getAllFolowers(int id, String order);
    UserFollowersCountResponseDto countFollowersBySeller(int id);
}
