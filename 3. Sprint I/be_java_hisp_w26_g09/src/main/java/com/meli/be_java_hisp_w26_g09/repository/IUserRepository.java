package com.meli.be_java_hisp_w26_g09.repository;

import com.meli.be_java_hisp_w26_g09.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {

    Optional<User> findById(Integer id);

    List<User> findAll();

    void unfollowUser(User userWhoUnfollow, User userToUnfollow);

    void addFollowed(User customer, User seller);
}
