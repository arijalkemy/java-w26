package com.sprint.socialmeli.dto.post;

import com.sprint.socialmeli.dto.user.UserResponseDTO;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

// Individual
@Getter
public class PromoListResponseDTO extends UserResponseDTO implements Serializable {
    private final List<PromoPostResponseDTO> posts;

    public PromoListResponseDTO(Integer user_id, String user_name, List<PromoPostResponseDTO> posts) {
        super(user_id, user_name);
        this.posts = posts;
    }
}
