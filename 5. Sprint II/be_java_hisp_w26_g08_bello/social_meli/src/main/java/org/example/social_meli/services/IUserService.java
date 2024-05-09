package org.example.social_meli.services;

import org.example.social_meli.dto.UserResponseDTO;

import org.example.social_meli.dto.UserResponseDTO;

import org.example.social_meli.dto.UserCountResponseDTO;

public interface IUserService {
    UserResponseDTO unfollowUser(Integer userId, Integer userIdToUnfollow);
    UserResponseDTO getFollowers(Integer userId);
    void followUser(Integer user_id, Integer user_id_to_follow);
    UserCountResponseDTO countFollowers(Integer userId);
    UserResponseDTO getFollowedById(Integer id);
    UserResponseDTO getOrderedFollowedById(Integer id, String orderBy);
    UserResponseDTO getOrderedFollowersById(Integer id, String orderBy);
}
