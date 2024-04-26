package com.api.socialmeli.dto;

import com.api.socialmeli.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoPostDto {
    private Integer post_id;
    private Integer user_id;
    private LocalDate date;
    private Product product;
    private Integer category;
    private Double price;
    private Boolean has_promo;
    private Double discount;
}
