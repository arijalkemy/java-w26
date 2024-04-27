package org.example.be_java_hisp_w26_g07.service.interfaces;

import org.example.be_java_hisp_w26_g07.dto.CountFollowersResponseDto;
import org.example.be_java_hisp_w26_g07.dto.FollowedResponseDto;
import org.example.be_java_hisp_w26_g07.dto.FollowersResponseDto;
import org.example.be_java_hisp_w26_g07.dto.SuccessResponseDto;

public interface IUserService {
    Boolean userFollowSeller(Integer userId, Integer sellerId);

    FollowedResponseDto findFollowedUsers(Integer id, String order);

    FollowersResponseDto findFollowersByOrder(Integer userId, String order);

    CountFollowersResponseDto getNumberOfSellersFollowed(Integer userId);

    SuccessResponseDto unfollow(Integer userId, Integer userIdToUnfollow);
}
