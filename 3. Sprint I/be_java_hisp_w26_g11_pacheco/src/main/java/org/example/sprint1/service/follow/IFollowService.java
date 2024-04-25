package org.example.sprint1.service.follow;

import org.example.sprint1.dto.ExceptionDTO;
import org.example.sprint1.dto.SellerFollowerDto;
import org.example.sprint1.dto.FollowedSellersDTO;

public interface IFollowService {
    void userIdToFollow(int userId,int userIdToFollow);

    int countFollowers(int sellerId);

    void unfollowSeller(int userId, int userIdToUnfollow);

    SellerFollowerDto getSellerFollowers(int userId, String order);

    FollowedSellersDTO getFollowedSellers(int userId, String order);

}
