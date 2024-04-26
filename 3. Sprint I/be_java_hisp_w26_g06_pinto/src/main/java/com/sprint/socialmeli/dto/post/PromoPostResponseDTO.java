package com.sprint.socialmeli.dto.post;

import java.io.Serializable;

// Individual
public class PromoPostResponseDTO extends PostDTO implements Serializable {
    private final Boolean has_promo;
    private final Double discount;
    private final Integer post_id;

    public PromoPostResponseDTO(
            Integer user_id,
            Integer post_id,
            String date,
            ProductDTO product,
            Integer category,
            Double price,
            Boolean has_promo,
            Double discount
    ) {
        super(user_id, date, product, category, price);
        this.has_promo = has_promo;
        this.discount = discount;
        this.post_id = post_id;
    }
}
