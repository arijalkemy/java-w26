package com.sprint.socialmeli.dto.post;

import com.sprint.socialmeli.dto.user.UserResponseDTO;
import lombok.Getter;

import java.io.Serializable;

// Individual
@Getter
public class PromoCountResponseDTO extends UserResponseDTO implements Serializable {
    private final Integer promo_products_count;

    public PromoCountResponseDTO(Integer user_id, String user_name, Integer promo_products_count) {
        super(user_id, user_name);
        this.promo_products_count = promo_products_count;
    }
}
