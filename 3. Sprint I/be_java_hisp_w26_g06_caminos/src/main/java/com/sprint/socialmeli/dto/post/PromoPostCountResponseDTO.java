package com.sprint.socialmeli.dto.post;

import com.sprint.socialmeli.dto.user.UserResponseDTO;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class PromoPostCountResponseDTO extends UserResponseDTO implements Serializable {

    private final Integer promo_count;

    public PromoPostCountResponseDTO(Integer user_id, String user_name, Integer promo_count) {
        super(user_id, user_name);
        this.promo_count = promo_count;
    }

}
