package com.meli.be_java_hisp_w26_g09.service;

import com.meli.be_java_hisp_w26_g09.dto.ResponseDTO;
import com.meli.be_java_hisp_w26_g09.dto.UserDTO;

import java.util.List;

public interface IUserService {

    UserDTO getFollowedById(Integer id);

    UserDTO getFollowersById(Integer id);

    UserDTO getFollowedByIdOrdered(Integer id, String order);

    UserDTO getFollowersByIdOrdered(Integer id, String order);

    List<UserDTO> getAllUsers();

    ResponseDTO unfollowUser(int userId, int userToUnfollow);

    ResponseDTO follow(Integer userId, Integer userIdToFollow);

    UserDTO getFollowedCount(Integer id);

}
