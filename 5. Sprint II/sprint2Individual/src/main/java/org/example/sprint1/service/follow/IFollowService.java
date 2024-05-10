package org.example.sprint1.service.follow;

import org.example.sprint1.dto.CountFollowersDTO;
import org.example.sprint1.dto.ExceptionDTO;
import org.example.sprint1.dto.SellerFollowerDto;
import org.example.sprint1.dto.FollowedSellersDTO;

public interface IFollowService {
    void userIdToFollow(int userId,int userIdToFollow);

    CountFollowersDTO countFollowers(Integer sellerId);

    void unfollowSeller(Integer userId, Integer userIdToUnfollow);

    SellerFollowerDto getSellerFollowers(int userId, String order);

    FollowedSellersDTO getFollowedSellers(int userId, String order);

}
