package org.example.social_meli.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
     private Integer product_id;
     private String product_name;
     private String type;
     private String brand;
     private String color;
     private String notes;
}
