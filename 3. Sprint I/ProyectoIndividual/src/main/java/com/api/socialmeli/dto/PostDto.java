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
public class PostDto {
    private Integer post_id;
    private Integer user_id;
    private LocalDate date;
    private Product product;
    private Integer category;
    private Double price;
    @JsonIgnore
    private Boolean has_promo;
    @JsonIgnore
    private Double discount;
}
