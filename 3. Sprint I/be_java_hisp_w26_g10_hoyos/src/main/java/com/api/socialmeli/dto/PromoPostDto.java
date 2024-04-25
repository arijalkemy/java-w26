package com.api.socialmeli.dto;

import com.api.socialmeli.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromoPostDto {
    private Integer post_id;
    private LocalDate date;
    private Integer category;
    private Double price;
    private Integer user_id;
    private Product product;
    private Boolean has_promo;
    private Double discount;
}
