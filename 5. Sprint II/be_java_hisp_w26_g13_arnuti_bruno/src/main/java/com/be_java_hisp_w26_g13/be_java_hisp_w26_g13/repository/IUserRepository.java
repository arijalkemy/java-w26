package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.repository;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.entity.User;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.entity.UserMinimalData;

import java.util.List;

public interface IUserRepository {
    List<User> getAll();
    User findById(int id);
    UserMinimalData findFollowedById(User user, int idFollowed);
    UserMinimalData findFollowerById(User user, int idFollowed);
    void unfollowed(User user, UserMinimalData followed);
    void deleteFollower(User user, UserMinimalData followed);




}
