package com.sprint.socialmeli.dto.post;

import com.sprint.socialmeli.dto.user.UserResponseDTO;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
public class PostPromoListResponseDTO extends UserResponseDTO implements Serializable {
    List<PostPromoDTO> posts;

    public PostPromoListResponseDTO(Integer user_id, String user_name, List<PostPromoDTO> posts) {
        super(user_id, user_name);
        this.posts = posts;
    }
}
