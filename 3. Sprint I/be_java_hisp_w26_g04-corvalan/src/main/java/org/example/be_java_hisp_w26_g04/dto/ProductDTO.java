package org.example.be_java_hisp_w26_g04.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {
    @JsonAlias("productId")
    @JsonProperty("product_id")
    private int productId;
    @JsonAlias("productName")
    @JsonProperty("product_name")
    private String productName;
    @JsonAlias("typeProduct")
    @JsonProperty("type")
    private String typeProduct;
    private String brand;
    private String color;
    private String notes;
}
