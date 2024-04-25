package com.sprint.socialmeli.entity;

import java.time.LocalDate;
import java.util.Map;

public interface IFollower {
    void follow(Integer followedId, LocalDate date);
    void unfollow(Integer unfollowedId);
    Map<Integer, LocalDate> getFollowed();
}
