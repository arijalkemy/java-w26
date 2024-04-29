package org.example.g14.service;

import org.example.g14.dto.UserFollowedDto;

import org.example.g14.dto.UserWithFollowersCountDto;

import org.example.g14.dto.UserFollowersDto;

public interface IUserService {
    
    UserFollowedDto getListOfFollowedSellers(int userId, String order);
    UserFollowedDto follow(int userId, int userIdToFollow);
    UserFollowedDto unfollowSeller(int followerUserId, int sellerUserId);
    UserFollowersDto getAllFolowers(int id, String order);
    UserWithFollowersCountDto countFollowersBySeller(int id);
}
