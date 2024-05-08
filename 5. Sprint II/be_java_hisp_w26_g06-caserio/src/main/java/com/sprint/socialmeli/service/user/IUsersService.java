package com.sprint.socialmeli.service.user;

import com.sprint.socialmeli.dto.user.FollowersResponseDTO;
import com.sprint.socialmeli.dto.user.FollowerCountResponseDTO;


import com.sprint.socialmeli.dto.user.FollowedResponseDTO;
import com.sprint.socialmeli.entity.Customer;
import com.sprint.socialmeli.entity.Seller;

public interface IUsersService {
    void follow(Integer customerId, Integer sellerId);
    FollowerCountResponseDTO getFollowersCount(Integer sellerId);
    FollowersResponseDTO getFollowers(Integer sellerId, String orderType);
    void unfollow(Integer userId, Integer userIdToUnfollow);
    FollowedResponseDTO listFollowedUsers(Integer userId, String order);

    Customer checkAndGetCustomer(Integer customerId);
    Seller checkAndGetSeller(Integer sellerId);
}
