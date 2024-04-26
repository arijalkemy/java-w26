package com.example.sprint1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Integer id;
    private String product_name;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
