package org.example.g14.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private int user_id;
    private int post_id;
    private LocalDate date;
    private ProductDto product;
    private int category;
    private double price;
    private boolean has_promo;
    private double discount;

    public PostDto(int idUser, int postId, LocalDate date, ProductDto product, int category, double price){
        this.user_id = idUser;
        this.post_id = postId;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
    }
}
