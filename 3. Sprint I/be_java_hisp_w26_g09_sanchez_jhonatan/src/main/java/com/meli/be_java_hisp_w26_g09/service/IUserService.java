package com.meli.be_java_hisp_w26_g09.service;

import com.meli.be_java_hisp_w26_g09.dto.ResponseDTO;
import com.meli.be_java_hisp_w26_g09.dto.UserDTO;
import com.meli.be_java_hisp_w26_g09.entity.User;

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

    User getUser(Integer id);

    boolean isSeller(Integer id);

    boolean isCustomer(Integer id);

}
