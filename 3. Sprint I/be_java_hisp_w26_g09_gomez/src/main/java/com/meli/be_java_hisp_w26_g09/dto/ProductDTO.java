package com.meli.be_java_hisp_w26_g09.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonPropertyOrder({
        "product_id",
        "product_name",
        "type",
        "brand",
        "color",
        "notes"
})
public class ProductDTO implements Serializable {
    @JsonProperty("product_id")
    private Integer productId;
    @JsonProperty("product_name")
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
