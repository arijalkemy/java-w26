package org.example.g14.service;

import org.example.g14.dto.UserFollowDto;
import org.example.g14.dto.UserFollowedDto;

import org.example.g14.model.User;
import org.example.g14.dto.UserWithFollowersCountDto;

import org.example.g14.dto.UserFollowersDto;

public interface IUserService {
    UserFollowedDto getListOfFollowedSellers(int userId, String order);
    UserFollowDto follow(int userId, int userIdToFollow);
    UserFollowersDto getAllFolowers(int id, String order);
    UserFollowDto unfollowSeller(int followerUserId, int sellerUserId);
    UserWithFollowersCountDto countFollowersBySeller(int id);

}
