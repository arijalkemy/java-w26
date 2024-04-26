package com.api.socialmeli.dto;


import com.api.socialmeli.entity.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CompletePostDto {
    private Integer post_id;
    private LocalDate date;
    private Integer category;
    private Double price;
    private Integer user_id;
    private Product product;
    private boolean has_promo;
    private Double discount;
}
