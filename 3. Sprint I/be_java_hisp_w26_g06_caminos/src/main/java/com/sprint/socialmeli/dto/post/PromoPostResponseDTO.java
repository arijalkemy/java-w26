package com.sprint.socialmeli.dto.post;

import lombok.Getter;

@Getter
public class PromoPostResponseDTO extends PromoPostDTO{

    private final Integer post_id;

    public PromoPostResponseDTO(Integer user_id,
                                Integer post_id,
                                String date,
                                ProductDTO product,
                                Integer category,
                                Double price,
                                Boolean has_promo,
                                double discount) {
        super(user_id, date, product, category, price, has_promo, discount);
        this.post_id = post_id;
    }
}
