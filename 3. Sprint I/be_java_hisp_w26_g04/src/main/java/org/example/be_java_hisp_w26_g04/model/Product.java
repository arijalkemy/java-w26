package org.example.be_java_hisp_w26_g04.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @JsonAlias("product_id")
    private int productId;
    @JsonAlias("product_name")
    private String productName;
    @JsonAlias("type")
    private String typeProduct;
    private String brand;
    private String color;
    private String notes;
}
