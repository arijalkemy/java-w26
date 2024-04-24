package com.sprint.socialmeli.dto.user;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class UserWithPromoPostsDTO extends UserResponseDTO implements Serializable {
    private final Long promo_products_count;

    public UserWithPromoPostsDTO(Integer user_id, String user_name, Long promo_products_count) {
        super(user_id, user_name);
        this.promo_products_count = promo_products_count;
    }
}
