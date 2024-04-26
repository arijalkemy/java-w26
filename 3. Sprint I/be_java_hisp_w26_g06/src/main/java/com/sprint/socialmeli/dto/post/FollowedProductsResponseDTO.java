package com.sprint.socialmeli.dto.post;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
@AllArgsConstructor
public class FollowedProductsResponseDTO implements Serializable {
    private final Integer user_id;
    private final List<PostResponseDTO> posts;
}
