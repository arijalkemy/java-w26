package com.sprint.socialmeli.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Post {
    private Integer id;
    private Product product;
    private LocalDate postDate;
    private Integer category;
    private double price;
    private boolean has_promo;
    private double discount;
    private static Integer idCounter = 0;

    public Post(Product product, LocalDate postDate, Integer category, double price) {
        this.product = product;
        this.postDate = postDate;
        this.category = category;
        this.price = price;
        this.discount = 0;
        this.has_promo = false;
        this.id = idCounter++;
    }
}
