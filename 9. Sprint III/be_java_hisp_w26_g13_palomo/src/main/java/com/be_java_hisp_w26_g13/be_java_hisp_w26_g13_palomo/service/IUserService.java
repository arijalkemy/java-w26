package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.service;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.dto.ResponseFollowedByUserDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.dto.ResponseFollowersCountDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.dto.FullUserDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.dto.ResponseFollowDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.dto.ResponseUserFollowersDTO;

import java.util.List;

public interface IUserService {
    ResponseFollowDTO followUser(Integer userId, Integer userIdToFollow);
    List<FullUserDTO> retrieveAllUsers();
    ResponseFollowDTO unfollow(int userId, int userIdToUnfollow);
    ResponseFollowedByUserDTO getOrderedFollowedSellers(int userId, String order);
    ResponseFollowersCountDTO getFollowersCount(int userId);
    ResponseUserFollowersDTO getOrderedFollowersList(int userId, String order);
}
