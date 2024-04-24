package com.sprint.socialmeli.dto.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

// INDIVIDUAL
@Getter
public class PromoPostRequestDTO extends PostDTO implements Serializable {
    private final Boolean has_promo;
    private final Double discount;

    public PromoPostRequestDTO(
            Integer user_id,
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
    }
}
