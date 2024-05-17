package com.javabootcamp.socialmeli.repository;

import java.util.List;
import java.util.Optional;

import com.javabootcamp.socialmeli.model.Follow;
import com.javabootcamp.socialmeli.model.User;

public interface FollowRepository {
    void add(Follow follow);
    void delete(Follow follow);
    List<User> findFollowersById(Integer id);
    List<User> findFollowedsById(Integer id);
    List<User> findFollowedsByIdAsc(Integer id);

    List<User> findFollowedsByIdDesc(Integer id);
    int countFollowersById(Integer id);
    Optional<Follow> findByFollowerIdAndFollowedId(Integer followerId, Integer followedId);
    List<User> searchFollowersByUserAndOrderAsc(Integer id);
    List<User> searchFollowersByUserAndOrderDesc(Integer id);
}
