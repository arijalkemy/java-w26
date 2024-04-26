package org.mercadolibre.NotNullTeam.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Post {
    private static Long currentId = 1L;
    private Long id;
    private Seller seller;
    private LocalDate date;
    private Product product;
    private int category;
    private Double price;
    private Boolean hasPromo;
    private Double discount;

    public Post(Seller seller, LocalDate date, Product product, int category, Double price) {
        this.id = currentId;
        this.seller = seller;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
        this.hasPromo = false;
        this.discount = 0.0;
        currentId++;
    }
}
