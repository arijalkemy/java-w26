package com.sprint.socialmeli.dto.post;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class PostPromoDTO extends PostResponseDTO implements Serializable {

    private boolean has_promo;
    private double discount;

    public PostPromoDTO(Integer user_id, Integer post_id, String date, ProductDTO product, Integer category,
                        Double price, boolean has_promo, double discount) {
        super(user_id, post_id, date, product, category, price);
        this.has_promo = has_promo;
        this.discount = discount;
    }
}
