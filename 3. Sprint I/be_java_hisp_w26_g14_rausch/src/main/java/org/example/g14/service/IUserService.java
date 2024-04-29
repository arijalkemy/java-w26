package org.example.g14.service;

import org.example.g14.dto.*;

import org.example.g14.model.Post;

import java.util.List;

public interface IUserService {
    UserFollowedDto getListOfFollowedSellers(int userId, String order);
    UserFollowDto follow(int userId, int userIdToFollow);
    UserFollowersDto getAllFolowers(int id, String order);
    UserFollowDto unfollowSeller(int followerUserId, int sellerUserId);
    UserWithFollowersCountDto countFollowersBySeller(int id);
}
