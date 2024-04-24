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
    private static Integer idCounter = 0;
    private boolean hasPromo;
    private double discount;

    public Post(Product product, LocalDate postDate, Integer category, double price) {
        this.product = product;
        this.postDate = postDate;
        this.category = category;
        this.price = price;
        this.id = idCounter++;
        this.hasPromo = false;
    }

    public Post(Product product, LocalDate postDate, Integer category, double price, double discount) {
        this.product = product;
        this.postDate = postDate;
        this.category = category;
        this.price = price;
        this.id = idCounter++;
        this.hasPromo = true;
        this.discount = discount;
    }
}
