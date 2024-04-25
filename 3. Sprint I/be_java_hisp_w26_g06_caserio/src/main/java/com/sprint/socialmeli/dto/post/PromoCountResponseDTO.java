package com.sprint.socialmeli.dto.post;

import lombok.Getter;

@Getter
public class PromoCountResponseDTO {
    private final Integer promo_products_count;
    private final String user_name;
    private final Integer user_id;

    public PromoCountResponseDTO(Integer promo_products_count, String user_name, Integer user_id) {
        this.user_name = user_name;
        this.user_id = user_id;
        this.promo_products_count = promo_products_count;
    }
}
