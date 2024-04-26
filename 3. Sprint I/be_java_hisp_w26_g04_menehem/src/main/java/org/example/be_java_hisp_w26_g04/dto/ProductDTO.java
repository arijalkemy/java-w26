package org.example.be_java_hisp_w26_g04.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonPropertyOrder({"productId", "productName", "typeProduct", "brand", "color", "notes"})
public class ProductDTO {
    @JsonProperty("product_id")
    @JsonAlias("productId")
    private int productId;
    @JsonProperty("product_name")
    @JsonAlias("productName")
    private String productName;
    @JsonProperty("type")
    @JsonAlias("typeProduct")
    private String typeProduct;
    private String brand;
    private String color;
    private String notes;
}
