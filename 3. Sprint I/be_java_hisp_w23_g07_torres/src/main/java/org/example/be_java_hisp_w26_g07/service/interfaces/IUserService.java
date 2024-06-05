package org.example.be_java_hisp_w26_g07.service.interfaces;

import org.example.be_java_hisp_w26_g07.dto.*;

public interface IUserService {
    Boolean userFollowSeller(Integer userId, Integer sellerId);
    FollowedResponseDto findFollowedUsers(Integer id, String order);
    FollowersResponseDto findFollowersByOrder(Integer userId, String order);
    CountFollowersResponseDto getNumberOfSellersFollowed(String userId);
    SuccessResponseDto unfollow(Integer userId, Integer userIdToUnfollow);
}
