package com.meli.be_java_hisp_w26_g09.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class ProductDTO implements Serializable {
    @JsonProperty("product_id")
    @NotNull(message = "Product ID is required, can't be null")
    @Positive(message = "Product ID must be greater than zero")
    private Integer productId;

    @JsonProperty("product_name")
    @NotEmpty(message = "Product name is required, can't be null")
    @Size(max = 40, message = "Product name max length must be 40 characters")
    @Pattern(regexp = "[a-zA-Z0-9-\\s-,-.]+")
    private String productName;

    @NotEmpty(message = "Type is required, can't be null")
    @Size(max = 15, message = "Type max length must be 15 characters")
    @Pattern(regexp = "[a-zA-Z0-9-\\s-,-.]+")
    private String type;

    @NotEmpty(message = "Brand is required, can't be null")
    @Size(max = 25, message = "Brand max length must be 25")
    @Pattern(regexp = "[a-zA-Z0-9-\\s-,-.]+")
    private String brand;

    @NotEmpty(message = "Color is required, can't be null")
    @Size(max = 15, message = "Color max length must be 15 characters")
    @Pattern(regexp = "[a-zA-Z0-9-\\s-,-.]+")
    private String color;

    @Size(max = 80, message = "Notes max length must be 80 characters")
    @Pattern(regexp = "[a-zA-Z0-9-\\s-,-.]+")
    private String notes;
}
