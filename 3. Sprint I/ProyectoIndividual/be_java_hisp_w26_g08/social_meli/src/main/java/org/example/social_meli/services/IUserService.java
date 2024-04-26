package org.example.social_meli.services;

import org.example.social_meli.dto.PromProductCountResponseDTO;
import org.example.social_meli.dto.UserResponseDTO;
import org.example.social_meli.dto.UserCountResponseDTO;

public interface IUserService {
    void followUser(Integer user_id, Integer user_id_to_follow);
    UserCountResponseDTO countFollowers(Integer userId);
    UserResponseDTO getFollowers(Integer userId);
    UserResponseDTO getFollowedById(Integer id);
    UserResponseDTO unfollowUser(Integer userId, Integer userIdToUnfollow);
    UserResponseDTO getOrderedFollowedById(Integer id, String orderBy);
    UserResponseDTO getOrderedFollowersById(Integer id, String orderBy);
}
