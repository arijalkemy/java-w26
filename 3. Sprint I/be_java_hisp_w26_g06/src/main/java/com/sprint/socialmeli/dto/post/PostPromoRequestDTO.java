package com.sprint.socialmeli.dto.post;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class PostPromoRequestDTO extends PostDTO implements Serializable {
    private boolean has_promo;
    private double discount;

    public PostPromoRequestDTO(Integer user_id, String date, ProductDTO product, Integer category, Double price,
    boolean hasPromo, double discount) {
        super(user_id, date, product, category, price);
        this.has_promo = hasPromo;
        this.discount = discount;
    }
}
