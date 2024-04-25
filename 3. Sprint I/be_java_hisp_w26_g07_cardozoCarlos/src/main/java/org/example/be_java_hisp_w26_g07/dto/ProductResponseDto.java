package org.example.be_java_hisp_w26_g07.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("user_name")
    public String userName;
    @JsonProperty("product_id")
    private Integer id;
    @JsonProperty("product_name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("color")
    private String color;
    @JsonProperty("notes")
    private String notes;
    @JsonProperty("category")
    private String category;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("discount")
    private Double discount;
    @JsonProperty("price_discount")
    private Double priceDiscount;
}
