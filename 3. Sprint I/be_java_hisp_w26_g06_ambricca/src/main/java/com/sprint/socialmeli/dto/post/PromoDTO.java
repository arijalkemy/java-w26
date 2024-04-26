package com.sprint.socialmeli.dto.post;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class PromoDTO extends PostDTO implements Serializable {
    private boolean has_promo;
    private double discount;

    public PromoDTO(Integer user_id, String date, ProductDTO product, Integer category, Double price, Double discount, Boolean has_promo) {
        super(user_id, date, product, category, price);
        this.discount = discount;
        this.has_promo = has_promo;
    }
}
