package com.sprint.socialmeli.dto.user;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
public class FollowersResponseDTO extends UserResponseDTO implements Serializable {
    private final List<UserResponseDTO> followers;

    public FollowersResponseDTO(Integer user_id, String user_name, List<UserResponseDTO> followers) {
        super(user_id, user_name);
        this.followers = followers;
    }
}
