package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.service;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.ResponseFollowedByUserDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.ResponseFollowersCountDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.FullUserDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.ResponseFollowDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.ResponseUserFollowersDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.ResponseFollowedByUserDTO;
import java.util.List;
import java.util.Optional;

public interface IUserService {
    ResponseFollowDTO followUser(Integer userId, Integer userIdToFollow);
    List<FullUserDTO> retrieveAllUsers();
    ResponseFollowDTO unfollow(int userId, int userIdToUnfollow);
    ResponseFollowedByUserDTO getOrderedFollowedSellers(int userId, String order);
    ResponseFollowersCountDTO getFollowersCount(int userId);
    ResponseUserFollowersDTO getOrderedFollowersList(int userId, String order);
}
