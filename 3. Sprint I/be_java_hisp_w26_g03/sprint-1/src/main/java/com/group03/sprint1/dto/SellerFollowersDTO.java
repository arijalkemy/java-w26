package com.group03.sprint1.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class SellerFollowersDTO implements Serializable{
    Integer userId;
    String username;
    Integer followers;

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }
}
