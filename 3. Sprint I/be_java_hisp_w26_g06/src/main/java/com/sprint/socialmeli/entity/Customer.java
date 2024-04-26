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

    /**
     *
     * @param userIdToFollow seller id
     * add the seller id to the followed list
     */
    public void follow(Integer userIdToFollow){
        followed.add(userIdToFollow);
    }

    /**
     *
     * @param userIdToFollow seller id
     * remove the seller id from the followed list
     */
    public void unfollow(Integer userIdToFollow){
        followed.remove(userIdToFollow);
    }
}
