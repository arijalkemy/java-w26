package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @JsonProperty("product_id")
    private int productId;

    @JsonProperty("product_name")
    private String productName;

    private String type;
    private String brand;
    private String color;
    private String notes;
}
