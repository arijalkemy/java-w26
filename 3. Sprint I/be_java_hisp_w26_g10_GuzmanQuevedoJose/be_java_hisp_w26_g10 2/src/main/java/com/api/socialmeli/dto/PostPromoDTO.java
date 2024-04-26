package com.api.socialmeli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostPromoDTO {
    private Integer user_id;
    private Integer post_id;
    private LocalDate date;
    private ProductDto product;
    private Integer category;
    private Double price;
    private Boolean has_promo;
    private Double discount;
}
