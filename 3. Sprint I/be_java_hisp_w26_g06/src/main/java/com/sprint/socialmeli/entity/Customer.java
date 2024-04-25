package com.sprint.socialmeli.entity;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class Customer {
    private List<Integer> followed = new ArrayList<>();
    private User user;

    public Customer(User user) {
        this.user = user;
    }

    public void follow(Integer userIdToFollow){
        followed.add(userIdToFollow);
    }

    public void unfollow(Integer userIdToFollow){
        followed.remove(userIdToFollow);
    }
}
