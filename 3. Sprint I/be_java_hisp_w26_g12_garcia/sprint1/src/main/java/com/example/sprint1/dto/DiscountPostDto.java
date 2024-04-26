package com.example.sprint1.dto;

import com.example.sprint1.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DiscountPostDto {
    private Integer id;
    private Integer user_id;
    private String date;
    private Integer category;
    private Double price;
    private Product product;
    private boolean has_promo;
    private Double discount;
}
