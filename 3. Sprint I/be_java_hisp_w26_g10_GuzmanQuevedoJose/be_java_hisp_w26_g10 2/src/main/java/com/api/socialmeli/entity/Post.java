package com.api.socialmeli.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Post {
    private Integer post_id;
    private LocalDate date;
    private Integer category;
    private Double price;
    private Integer user_id;
    private Product product;
    private Boolean has_promo;
    private Double discount;

}
