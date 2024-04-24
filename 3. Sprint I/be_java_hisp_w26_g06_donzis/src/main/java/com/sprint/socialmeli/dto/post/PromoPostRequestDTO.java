package com.sprint.socialmeli.dto.post;

import lombok.Getter;
import lombok.NonNull;

import java.io.Serializable;

@Getter
public class PromoPostRequestDTO extends PostDTO implements Serializable {
    @NonNull
    private final Boolean has_promo;
    @NonNull
    private final Double discount;

    public PromoPostRequestDTO(@NonNull Integer user_id, @NonNull String date, @NonNull ProductDTO product,
                               @NonNull Integer category, @NonNull Double price,
                               @NonNull Boolean has_promo, @NonNull Double discount) {
        super(user_id, date, product, category, price);
        this.has_promo = has_promo;
        this.discount = discount;
    }
}
