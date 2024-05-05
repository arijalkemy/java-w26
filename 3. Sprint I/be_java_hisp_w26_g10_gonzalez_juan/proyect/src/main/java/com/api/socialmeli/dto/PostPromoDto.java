package com.api.socialmeli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostPromoDto {
    private Integer user_id;
    private int post_id;
    private String date;
    private ProductDto product;
    private int category;
    private double price;
    private boolean has_promo;
    private double discount;
}
