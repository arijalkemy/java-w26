package org.example.sprint1.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"productId", "productName", "type", "brand", "color", "notes"})
@Builder
public class  Product {
    @JsonProperty("product_id")
    private int productId;
    @JsonProperty("product_name")
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
