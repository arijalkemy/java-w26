package org.example.g14.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private int id;
    private LocalDate date;
    private double price;
    private int category;
    private double discount;
    private boolean hasPromo;
    private Product product;
    private int idUser;

    public Post(LocalDate date, double price, int category, Product product, int idUser) {
        this.date = date;
        this.price = price;
        this.category = category;
        this.product = product;
        this.idUser = idUser;
    }

    public Post(LocalDate date, double price, int category, double discount, boolean hasPromo, Product product, int idUser) {
        this.date = date;
        this.price = price;
        this.category = category;
        this.discount = discount;
        this.hasPromo = hasPromo;
        this.product = product;
        this.idUser = idUser;
    }
}
