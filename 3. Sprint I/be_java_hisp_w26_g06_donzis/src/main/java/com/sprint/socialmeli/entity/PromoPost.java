package com.sprint.socialmeli.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PromoPost extends Post {
    private double discount;

    public PromoPost(Product product, LocalDate postDate, Integer category, double price, double discount) {
        super(product, postDate, category, price);
        this.discount = discount;
    }
}
