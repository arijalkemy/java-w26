package com.api.socialmeli.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer product_id;
    private String product_name;
    private String brand;
    private String type;
    private String color;
    private String notes;

}
