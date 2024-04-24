package com.sprint.socialmeli.dto.user;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class FollowerCountResponseDTO extends UserResponseDTO implements Serializable {
    private final Integer follower_count;

    public FollowerCountResponseDTO(Integer user_id, String user_name, Integer follower_count) {
        super(user_id, user_name);
        this.follower_count = follower_count;
    }
}
