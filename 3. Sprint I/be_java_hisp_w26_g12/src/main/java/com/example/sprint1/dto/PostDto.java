package com.example.sprint1.dto;

import com.example.sprint1.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    private Integer id;
    private Integer user_id;
    private String date;
    private Integer category;
    private Double price;
    private Product product;
}
