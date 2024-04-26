package com.api.socialmeli.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private Integer user_id;
    private LocalDate date;
    private Product product;
    private Integer post_id;
    private Integer category;
    private Double price;

    @JsonIgnore
    private boolean has_promo;
    @JsonIgnore
    private double discount;

}
