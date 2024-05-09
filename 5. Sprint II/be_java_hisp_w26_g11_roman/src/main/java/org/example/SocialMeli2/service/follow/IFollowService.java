package org.example.SocialMeli2.service.follow;

import org.example.SocialMeli2.dto.CountFollowersDTO;
import org.example.SocialMeli2.dto.SellerFollowerDto;
import org.example.SocialMeli2.dto.FollowedSellersDTO;

public interface IFollowService {
    void userIdToFollow(int userId,int userIdToFollow);

    CountFollowersDTO countFollowers(Integer sellerId);

    void unfollowSeller(Integer userId, Integer userIdToUnfollow);

    SellerFollowerDto getSellerFollowers(int userId, String order);

    FollowedSellersDTO getFollowedSellers(int userId, String order);

}
