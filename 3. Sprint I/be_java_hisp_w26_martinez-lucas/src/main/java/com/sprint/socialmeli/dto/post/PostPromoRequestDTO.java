package com.sprint.socialmeli.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
public class PostPromoRequestDTO extends PostDTO implements Serializable {
    private boolean _has_promo;
    private double _discount;

    public PostPromoRequestDTO(Integer user_id, String date, ProductDTO product, Integer category, Double price,
                               boolean has_promo, double discount) {
        super(user_id, date, product, category, price);
        this._has_promo = has_promo;
        this._discount = discount;
    }
}
