package com.sprint.socialmeli.dto.user;

import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
public class FollowedResponseDTO extends UserResponseDTO implements Serializable {
    private final List<UserResponseDTO> followed;

    public FollowedResponseDTO(Integer user_id, String user_name, List<UserResponseDTO> followed) {
        super(user_id, user_name);
        this.followed = followed;
    }
}
