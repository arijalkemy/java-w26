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
    private Double price;
    private Boolean hasPromo;
    private Double discount;
    private static Integer idCounter = 0;

    public Post(Product product, LocalDate postDate, Integer category, Double price) {
        this.product = product;
        this.postDate = postDate;
        this.category = category;
        this.price = price;
        this.hasPromo = false;
        this.discount = 0.0;
        this.id = idCounter++;
    }

    public Post(Product product, LocalDate postDate, Integer category, Double price, Boolean hasPromo, Double discount) {
        this.product = product;
        this.postDate = postDate;
        this.category = category;
        this.price = price;
        this.hasPromo = hasPromo;
        this.discount = discount;
        this.id = idCounter++;
    }
}
