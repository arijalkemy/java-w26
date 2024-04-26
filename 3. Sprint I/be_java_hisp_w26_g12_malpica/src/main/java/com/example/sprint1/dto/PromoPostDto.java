package com.example.sprint1.dto;

import com.example.sprint1.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromoPostDto {
    private Integer id;
    private Integer user_id;
    private String date;
    private Integer category;
    private Double price;
    private Product product;
    private Boolean has_promo;
    private Double discount;

}
