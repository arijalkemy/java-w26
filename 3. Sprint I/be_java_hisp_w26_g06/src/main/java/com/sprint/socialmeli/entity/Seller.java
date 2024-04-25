package com.sprint.socialmeli.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seller implements IFollower{
    private User user;
    private Map<Integer, LocalDate> followed = new HashMap<>();

    public Seller(User user) {
        this.user = user;
    }

    @Override
    public void follow(Integer followedId, LocalDate date) {
        followed.put(followedId, date);
    }

    @Override
    public void unfollow(Integer unfollowedId) {
        followed.remove(unfollowedId);
    }
}
