package org.example.be_java_hisp_w26_g04.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {
    @JsonProperty("product_id")
    private int productId;
    @JsonProperty("product_name")
    private String productName;
    @JsonProperty("type")
    private String typeProduct;
    private String brand;
    private String color;
    private String notes;
}
