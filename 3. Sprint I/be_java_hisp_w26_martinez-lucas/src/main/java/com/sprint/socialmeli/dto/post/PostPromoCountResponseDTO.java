package com.sprint.socialmeli.dto.post;

import com.sprint.socialmeli.dto.user.UserResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class PostPromoCountResponseDTO extends UserResponseDTO implements Serializable {
    private final int promo_products_count;
    public PostPromoCountResponseDTO(Integer user_id, String user_name, int promo_products_count) {
        super(user_id, user_name);
        this.promo_products_count = promo_products_count;
    }
}
