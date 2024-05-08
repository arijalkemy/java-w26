package com.meli.be_java_hisp_w26_g10.entity;

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
