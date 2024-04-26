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
    private double discount = 0;
    private Product product;
    private int idUser;
    private boolean hasPromo = false;

    public Post(LocalDate date, double price, int category, Product product, int idUser) {
        this.date = date;
        this.price = price;
        this.category = category;
        this.product = product;
        this.idUser = idUser;
    }

    public Post(LocalDate date, double price, int category, Product product,
                int idUser, boolean hasPromo, double discount){
        this.date = date;
        this.price = price;
        this.category = category;
        this.product = product;
        this.idUser = idUser;
        this.discount = discount;
        this.hasPromo = hasPromo;
    }
}
