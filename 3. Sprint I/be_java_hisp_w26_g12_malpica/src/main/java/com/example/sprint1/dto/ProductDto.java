package com.example.sprint1.dto;

import com.example.sprint1.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Integer id;
    private String product_name;
    private String type;
    private String brand;
    private String color;
    private String notes;
    private Product product;
    private boolean has_promo;
    private Double discount;
}
