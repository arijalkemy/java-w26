package org.example.sprint1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"productId", "productName", "type", "brand", "color", "notes"})
public class  ProductDTO {

    @JsonProperty("product_id")
    @Positive
    @NotNull
    private int productId;

    @JsonProperty("product_name")
    @NotEmpty
    private String productName;

    @NotEmpty
    private String type;

    @NotEmpty
    private String brand;

    @NotEmpty
    private String color;

    @NotEmpty
    private String notes;
}
