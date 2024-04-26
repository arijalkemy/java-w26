package com.sprint.socialmeli.dto.post;

import lombok.Getter;

@Getter
public class PromoPostDTO extends PostDTO {

    private final boolean has_promo;
    private final double discount;

    public PromoPostDTO(Integer user_id, String date, ProductDTO product, Integer category, Double price, boolean hasPromo,
                        double discount) {
        super(user_id, date, product, category, price);
        this.has_promo = hasPromo;
        this.discount = discount;
    }
}
